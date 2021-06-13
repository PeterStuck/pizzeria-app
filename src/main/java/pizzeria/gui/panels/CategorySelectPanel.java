package pizzeria.gui.panels;

import pizzeria.gui.CategorySelector;
import pizzeria.gui.TopHeader;

import javax.swing.*;
import java.awt.*;

public class CategorySelectPanel extends AbstractGridBagPanel {

    public CategorySelectPanel(JFrame parentFrame) {
        super(parentFrame);

        setBackground(BG_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(new TopHeader("Kategorie"), gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 25);
        add(new CategorySelector(parentFrame,"Pizza", "src\\main\\java\\assets\\pizza-slice.png"), gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0, 25, 0, 0);
        add(new CategorySelector(parentFrame,"Napoje", "src\\main\\java\\assets\\drink.png"), gbc);

        revalidate();
        repaint();
    }
}
