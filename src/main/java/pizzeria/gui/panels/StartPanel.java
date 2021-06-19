package pizzeria.gui.panels;

import pizzeria.gui.components.AbstractGridBagPanel;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.settings.ComponentProperties.ACCENT_LINE_BORDER;
import static pizzeria.gui.settings.ImagePaths.PIZZERIA_LOGO_IMG;
import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;
import static pizzeria.gui.settings.PizzeriaColors.ECRU_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H2_FONT;
import static pizzeria.gui.settings.PizzeriaTypography.H3_FONT;

public class StartPanel extends AbstractGridBagPanel {

    public StartPanel(JFrame parentFrame) {
        super(parentFrame);

        setBackground(BG_COLOR);
        JLabel label = new JLabel(new ImageIcon(PIZZERIA_LOGO_IMG));
        label.setFont(H2_FONT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 50;
        gbc.insets = new Insets(-50, 0, 0, 0);
        add(label, gbc);

        JButton startBtn = new JButton("Rozpocznij");
        startBtn.addActionListener(e -> {
            if (e.getSource() == startBtn) {
                parentFrame.remove(StartPanel.this);
                parentFrame.add(new CategorySelectPanel(parentFrame));

                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        startBtn.setBorder(ACCENT_LINE_BORDER);
        startBtn.setBackground(ECRU_COLOR);
        startBtn.setFont(H3_FONT);
        startBtn.setFocusPainted(false);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipady = 40;
        gbc.ipadx = 50;
        add(startBtn, gbc);


        revalidate();
        repaint();
    }
}
