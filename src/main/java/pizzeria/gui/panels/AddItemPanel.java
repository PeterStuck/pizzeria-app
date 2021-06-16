package pizzeria.gui.panels;

import pizzeria.gui.components.DetailsPanel;
import pizzeria.order_system.menu.models.MenuItem;

import javax.swing.*;

public class AddItemPanel extends AbstractPanelWithNavbar {

    public AddItemPanel(JFrame parentFrame, JPanel previousPanel, MenuItem menuItem) {
        super(parentFrame, previousPanel, menuItem.getName());

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new DetailsPanel(parentFrame, menuItem), gbc);

        revalidate();
        repaint();
    }
}
