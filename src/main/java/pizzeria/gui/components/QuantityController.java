package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H2_FONT;

public class QuantityController extends AbstractGridBagPanel {

    private final Dimension btnDim = new Dimension(50, 50);
    private final Dimension quantityDim = new Dimension(80, 50);

    private JLabel quantityLab;
    private int quantityCount = 0;

    public QuantityController(JFrame parentFrame) {
        super(parentFrame);
        setMinimumSize(new Dimension(200, 50));
        setBackground(BG_COLOR);

        var decreaseBtn = new JButton("-");
        decreaseBtn.setFont(H2_FONT);
        decreaseBtn.setMinimumSize(btnDim);
        decreaseBtn.setFocusPainted(false);
        decreaseBtn.addActionListener(e -> {
            if (quantityCount != 0) {
                quantityCount--;
                quantityLab.setText(String.valueOf(quantityCount));
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        add(decreaseBtn, gbc);

        quantityLab = new JLabel(String.valueOf(quantityCount));
        quantityLab.setFont(H2_FONT);
        quantityLab.setHorizontalAlignment(JLabel.CENTER);
        quantityLab.setPreferredSize(quantityDim);
        quantityLab.setMinimumSize(quantityDim);
        gbc.gridx = 1;
        add(quantityLab, gbc);

        var increaseBtn = new JButton("+");
        increaseBtn.setMinimumSize(btnDim);
        increaseBtn.setFont(H2_FONT);
        increaseBtn.setFocusPainted(false);
        increaseBtn.addActionListener(e -> {
            quantityCount++;
            quantityLab.setText(String.valueOf(quantityCount));
        });
        gbc.gridx = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(increaseBtn, gbc);

    }
}
