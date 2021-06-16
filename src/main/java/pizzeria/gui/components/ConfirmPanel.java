package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static pizzeria.gui.settings.ImagePaths.CONFIRM_MARK_IMG;
import static pizzeria.gui.settings.PizzeriaColors.ACCENT_COLOR;
import static pizzeria.gui.settings.PizzeriaColors.CONFIRM_COLOR;

public class ConfirmPanel extends AbstractGridBagPanel {

    public ConfirmPanel(JFrame parentFrame, JPanel contentPanel, ActionListener confirmListener) {
        super(parentFrame);

        var panelDim = new Dimension(500, 300);
        var labDim = new Dimension(200, 50);

        setMinimumSize(panelDim);
        setBackground(ACCENT_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(contentPanel, gbc);

        var confirmBtn = new JButton(new ImageIcon(CONFIRM_MARK_IMG));
        confirmBtn.setBackground(CONFIRM_COLOR);
        confirmBtn.setFocusPainted(false);
        confirmBtn.setBorder(null);
        confirmBtn.setPreferredSize(labDim);
        confirmBtn.addActionListener(confirmListener);
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(confirmBtn, gbc);
    }

}
