package pizzeria.gui.panels;

import pizzeria.gui.components.ItemSelectorPanel;
import pizzeria.gui.components.SectionHeader;
import pizzeria.order_system.menu.repositories.menu_item.MenuItemRepository;

import javax.swing.*;
import java.awt.*;

public class MenuItemSelectPanel extends AbstractGridBagPanel {

    public MenuItemSelectPanel(JFrame parentFrame, MenuItemRepository repository, String title) {
        super(parentFrame);
        setBackground(BG_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(new SectionHeader(title), gbc);

        JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setViewportView(new ItemSelectorPanel(parentFrame, repository.findAll()));
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
