package pizzeria.gui.panels;

import pizzeria.gui.components.ItemSelectorPanel;
import pizzeria.order_system.menu.repositories.menu_item.MenuItemRepository;

import javax.swing.*;

public class MenuItemSelectPanel extends AbstractPanelWithNavbar {

    public MenuItemSelectPanel(JFrame parentFrame, MenuItemRepository repository, String title, String placeholderPath) {
        super(parentFrame, new CategorySelectPanel(parentFrame), title);

        JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setViewportView(new ItemSelectorPanel(parentFrame, repository, placeholderPath));
        scrollPane.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 300;
        gbc.ipadx = 700;
        add(scrollPane, gbc);

        revalidate();
        repaint();
    }

}
