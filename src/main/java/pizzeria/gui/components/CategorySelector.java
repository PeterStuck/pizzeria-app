package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.settings.PizzeriaColors.ACCENT_COLOR;
import static pizzeria.gui.settings.PizzeriaColors.BTN_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H2_FONT;

public class CategorySelector extends AbstractGridBagPanel {

    public CategorySelector(JFrame parentFrame, String desc, String path) {
        super(parentFrame);

        Dimension labelDim = new Dimension(200, 300);

        setPreferredSize(labelDim);
        setMaximumSize(labelDim);
        setMinimumSize(labelDim);
        setBackground(BTN_COLOR);
        setBorder(BorderFactory.createMatteBorder(0,0,3,3,ACCENT_COLOR));

        JLabel icon = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        icon.setIcon(new ImageIcon(path));
        this.add(icon, gbc);

        JLabel description = new JLabel(desc);
        description.setFont(H2_FONT);
        gbc.gridy = 1;
        gbc.insets = new Insets(25, 0, 0, 0);
        this.add(description, gbc);

    }
}
