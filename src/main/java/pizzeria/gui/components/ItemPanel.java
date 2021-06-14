package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.PizzeriaColors.ACCENT_COLOR;
import static pizzeria.gui.PizzeriaTypografy.BOLD_PARAGRAPH_FONT;
import static pizzeria.gui.PizzeriaTypografy.PLAIN_PARAGRAPH_FONT;

public class ItemPanel extends AbstractGridBagPanel {

    public ItemPanel(JFrame parentFrame, String name, String price, String imagePath) {
        super(parentFrame);

        Dimension panelDim = new Dimension(150, 150);
        setPreferredSize(panelDim);
        setMinimumSize(panelDim);
        setMaximumSize(panelDim);
        setBackground(ACCENT_COLOR);

        var imageLab = new JLabel(new ImageIcon(imagePath));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(imageLab, gbc);

        var itemNameLab = new JLabel(name);
        itemNameLab.setFont(BOLD_PARAGRAPH_FONT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 0, 10);
        add(itemNameLab, gbc);

        var itemPriceLab = new JLabel(price);
        itemPriceLab.setFont(PLAIN_PARAGRAPH_FONT);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(itemPriceLab, gbc);

        revalidate();
        repaint();
    }
}
