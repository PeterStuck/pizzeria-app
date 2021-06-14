package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;
import pizzeria.order_system.menu.models.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static pizzeria.gui.settings.PizzeriaColors.BTN_COLOR;

public class ItemSelectorPanel extends AbstractGridBagPanel {

    public ItemSelectorPanel(JFrame parentFrame, List<MenuItem> items) {
        super(parentFrame);

        var panelDim = new Dimension(700, (int) (Math.ceil((double)items.size() / 3) * 170) + 50);
        setPreferredSize(panelDim);
        setMinimumSize(panelDim);

        setBackground(BTN_COLOR);

        arrangeTiles(parentFrame, items);

        revalidate();
        repaint();
    }

    private void arrangeTiles(JFrame parentFrame, List<MenuItem> items) {
        final int OUTER_MARGIN = 75;
        final int INNER_MARGIN = 25;
        final int TOP_BOTTOM_MARGIN = 10;
        final int MAX_TILES_IN_ROW = 3;

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
            add(new ItemPanel(parentFrame, item.getName(), String.valueOf(item.getPrice()), "src\\main\\java\\assets\\placeholder.png"), gbc);
            k++;
        }
    }

}
