package pizzeria.gui.panels;

import pizzeria.gui.components.ItemDetailsPanel;
import pizzeria.gui.components.Navbar;
import pizzeria.order_system.menu.models.MenuItem;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;

public class AddItemPanel extends AbstractGridBagPanel {

    public AddItemPanel(JFrame parentFrame, JPanel previousPanel, MenuItem menuItem) {
        super(parentFrame);

        setBackground(BG_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(new Navbar(parentFrame, menuItem.getName(), this, previousPanel), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new ItemDetailsPanel(parentFrame, menuItem), gbc);

        revalidate();
        repaint();
    }
}
