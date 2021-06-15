package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;
import pizzeria.gui.panels.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static pizzeria.gui.settings.ImagePaths.MINUS_MARK_IMG;
import static pizzeria.gui.settings.ImagePaths.PLUS_MARK_IMG;
import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H2_FONT;

public class QuantityController extends AbstractGridBagPanel {

    private final Dimension btnDim = new Dimension(50, 50);
    private final Dimension quantityDim = new Dimension(80, 50);

    private JLabel quantityLab;
    private int quantityCount = 1;

    private JButton decreaseBtn;
    private final JButton increaseBtn;

    public QuantityController(JFrame parentFrame) {
        super(parentFrame);
        setMinimumSize(new Dimension(200, 50));
        setBackground(BG_COLOR);

        decreaseBtn = createButton(MINUS_MARK_IMG, e -> {
            if (quantityCount > 1) {
                quantityCount--;
                quantityLab.setText(String.valueOf(quantityCount));
            } else {
                decreaseBtn.setEnabled(false);
            }
        });
        decreaseBtn.setEnabled(false);
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

        increaseBtn = createButton(PLUS_MARK_IMG, e -> {
            decreaseBtn.setEnabled(true);
            quantityCount++;
            quantityLab.setText(String.valueOf(quantityCount));
        });
        gbc.gridx = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(increaseBtn, gbc);

    }

    private JButton createButton(String imagePath, ActionListener listener) {
        var button = new JButton(new ImageIcon(imagePath));
        button.setMinimumSize(btnDim);
        button.setBackground(BG_COLOR);
        button.setFocusPainted(false);
        button.addActionListener(listener);

        return button;
    }

    public void mountObserverListener() {
        MouseClickObserver mco = new MouseClickObserver();
        decreaseBtn.addMouseListener(mco);
        increaseBtn.addMouseListener(mco);
    }


    public int getQuantityCount() {
        return this.quantityCount;
    }

    private class MouseClickObserver extends MouseAdapter {

        private final List<Observer> registeredObservers;

        public MouseClickObserver() {
            registeredObservers = new ArrayList<>();
            this.addObserver((Observer) QuantityController.this.getParent());
        }

        public void addObserver(Observer observer) {
            this.registeredObservers.add(observer);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for (Observer registeredObserver : registeredObservers) {
                registeredObserver.update();
            }
        }
    }
}
