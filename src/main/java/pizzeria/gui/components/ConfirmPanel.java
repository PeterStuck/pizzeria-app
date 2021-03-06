package pizzeria.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static pizzeria.gui.settings.ComponentProperties.ACCENT_LINE_BORDER;
import static pizzeria.gui.settings.ImagePaths.CONFIRM_MARK_IMG;
import static pizzeria.gui.settings.PizzeriaColors.*;

public class ConfirmPanel extends AbstractGridBagPanel {

    private final JButton confirmBtn;

    protected JComponent contentPanel;
    protected Dimension labDim;

    public ConfirmPanel(JFrame parentFrame, JComponent contentPanel) {
        super(parentFrame);
        this.contentPanel = contentPanel;
        var panelDim = new Dimension(500, 300);
        labDim = new Dimension(200, 50);

        setMinimumSize(panelDim);
        setBackground(BTN_COLOR);
        setBorder(ACCENT_LINE_BORDER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(contentPanel, gbc);

        confirmBtn = new JButton(new ImageIcon(CONFIRM_MARK_IMG));
        confirmBtn.setBackground(CONFIRM_COLOR);
        confirmBtn.setFocusPainted(false);
        confirmBtn.setBorder(BorderFactory.createLineBorder(GREEN_ACCENT_COLOR, 1, true));
        confirmBtn.setPreferredSize(labDim);
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(confirmBtn, gbc);
    }

    public void setConfirmActionListener(ActionListener confirmListener) {
        confirmBtn.addActionListener(confirmListener);
    }

    public void modifyConfirmButton(int gridX, int gridY, int gridWidth, Insets insets) {
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.gridwidth = gridWidth;
        gbc.insets = insets;
        remove(confirmBtn);
        add(confirmBtn, gbc);
    }

}
