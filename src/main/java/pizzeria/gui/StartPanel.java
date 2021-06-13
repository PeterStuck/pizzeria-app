package pizzeria.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends AbstractGridBagPanel {

    public StartPanel(JFrame parentFrame) {
        super(parentFrame);

        setBackground(new Color(255, 231, 163));

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src\\main\\java\\assets\\logo.png"));
        label.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 50;
        gbc.insets = new Insets(-50, 0, 0, 0);
        add(label, gbc);

        JButton startBtn = new JButton("Rozpocznij");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == startBtn) {
                    parentFrame.remove(StartPanel.this);
                    parentFrame.add(new CategorySelectPanel(parentFrame));

                    parentFrame.revalidate();
                    parentFrame.repaint();
                }
            }
        });
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.ipady = 0;
        add(startBtn, gbc);

        revalidate();
        repaint();
    }
}
