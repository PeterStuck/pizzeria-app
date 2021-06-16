package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;
import pizzeria.gui.panels.SubmitPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pizzeria.gui.settings.ImagePaths.GO_BACK_IMG;
import static pizzeria.gui.settings.PizzeriaColors.*;
import static pizzeria.gui.settings.PizzeriaTypography.*;

public class Navbar extends AbstractGridBagPanel {

    private final JButton submitBtn;

    public Navbar(JFrame parentFrame, String sectionTitle, JPanel panelToRemove, JPanel panelToAdd) {
        super(parentFrame);
        setBackground(BG_COLOR);

        setMinimumSize(new Dimension(1000, 50));

        JButton backButton = new JButton(new ImageIcon(GO_BACK_IMG));
        backButton.setBackground(BTN_COLOR);
        backButton.setBorder(null);
        backButton.setFocusPainted(false);
        backButton.setMinimumSize(new Dimension(50, 50));
        backButton.addActionListener(e -> {
            if (e.getSource() == backButton) {
                parentFrame.remove(panelToRemove);
                parentFrame.add(panelToAdd);

                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(0, 30, 0, 0);
        add(backButton, gbc);

        var sectionHeader = new SectionHeader(sectionTitle);
        sectionHeader.setMinimumSize(new Dimension(350, 50));
        gbc.gridx = 1;
        gbc.weightx = 10;
        gbc.insets = new Insets(0, 100, 0, 0);
        add(sectionHeader, gbc);

        submitBtn = new JButton("Podsumowanie");
        submitBtn.setMinimumSize(new Dimension(150, 50));
        submitBtn.setBackground(CONFIRM_COLOR);
        submitBtn.setFont(H5_FONT);
        submitBtn.setFocusPainted(false);
        submitBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var parent = Navbar.this.getParent();
                parentFrame.remove(parent);
                parentFrame.add(new SubmitPanel(parentFrame, (JPanel) parent));

                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 30);
        add(submitBtn, gbc);

        revalidate();
        repaint();
    }

    public void hideSubmitButton() {
        submitBtn.setVisible(false);
    }

}
