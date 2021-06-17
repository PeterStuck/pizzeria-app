package pizzeria.gui.components;

import pizzeria.gui.panels.AddItemPanel;
import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.repositories.menu_item.MenuItemRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static pizzeria.gui.settings.PizzeriaColors.BTN_COLOR;

public class ItemSelectorPanel extends AbstractGridBagPanel {

    private final MenuItemRepository repository;
    private final String placeholderImagePath;

    public ItemSelectorPanel(JFrame parentFrame, MenuItemRepository repository, String placeholderImagePath) {
        super(parentFrame);
        this.repository = repository;
        this.placeholderImagePath = placeholderImagePath;

        var panelDim = new Dimension(700, (int) (Math.ceil((double)repository.findAll().size() / 3) * 170) + 50);
        setPreferredSize(panelDim);
        setMinimumSize(panelDim);

        setBackground(BTN_COLOR);

        arrangeTiles();

        revalidate();
        repaint();
    }

    private void arrangeTiles() {
        final int OUTER_MARGIN = 75;
        final int INNER_MARGIN = 25;
        final int TOP_BOTTOM_MARGIN = 10;
        final int MAX_TILES_IN_ROW = 3;

        List<MenuItem> items = repository.findAll();
        for (int i = 0, y = 0, k = 0; i < items.size(); i++) {
            switch (k) {
                case MAX_TILES_IN_ROW:
                    k = 0;
                    y++;
                case 0:
                    gbc.insets = new Insets(TOP_BOTTOM_MARGIN, OUTER_MARGIN, TOP_BOTTOM_MARGIN, INNER_MARGIN);
                    break;
                case (MAX_TILES_IN_ROW - 1):
                    gbc.insets = new Insets(TOP_BOTTOM_MARGIN, INNER_MARGIN, TOP_BOTTOM_MARGIN, OUTER_MARGIN);
                    break;
                default:
                    gbc.insets = new Insets(TOP_BOTTOM_MARGIN, INNER_MARGIN, TOP_BOTTOM_MARGIN, INNER_MARGIN);
            }

            gbc.gridx = k;
            gbc.gridy = y;
            MenuItem item = items.get(i);
            var itemPanel = new ItemPanel(parentFrame, item.getName(), String.valueOf(item.getPrice()), placeholderImagePath);
            itemPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        JPanel previousMenuSelectPanel = (JPanel) ItemSelectorPanel.this.getParent().getParent().getParent();
                        parentFrame.getContentPane().removeAll();

                        String clickedPizzaName = ((ItemPanel) e.getSource()).getClickedPizzaName();
                        MenuItem menuItem = repository.findByName(clickedPizzaName);
                        parentFrame.add(new AddItemPanel(parentFrame, previousMenuSelectPanel, menuItem));

                        revalidate();
                        repaint();
                        parentFrame.revalidate();
                        parentFrame.repaint();
                    } catch (MenuItemNotFoundException menuItemNotFoundException) {
                        JOptionPane.showMessageDialog(null, "Nie znaleziono pozycji w bazie!", "Oops. Coś poszło nie tak.", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(itemPanel, gbc);
            k++;
        }
    }

}
