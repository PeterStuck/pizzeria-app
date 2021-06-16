package pizzeria.gui.panels;

import pizzeria.gui.components.Navbar;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;

public abstract class AbstractPanelWithNavbar extends AbstractGridBagPanel {

    private Navbar navbar;

    public AbstractPanelWithNavbar(JFrame parentFrame, JPanel previousPanel, String sectionTitle) {
        super(parentFrame);
        setBackground(BG_COLOR);

        navbar = new Navbar(parentFrame, sectionTitle, this, previousPanel);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(navbar, gbc);
    }

    public void modifyNavbar(int gridX, int gridY, int gridWidth, Insets insets) {
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.gridwidth = gridWidth;
        gbc.insets = insets;
        this.remove(navbar);
        this.add(navbar, gbc);

        revalidate();
        repaint();
    }



}
