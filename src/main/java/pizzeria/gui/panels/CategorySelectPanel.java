package pizzeria.gui.panels;

import javax.swing.*;

public class CategorySelectPanel extends AbstractGridBagPanel {

    public CategorySelectPanel(JFrame parentFrame) {
        super(parentFrame);

        JLabel label = new JLabel("KATEGORIE HERE!");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label, gbc);

        revalidate();
        repaint();
    }
}
