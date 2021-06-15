package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;
import pizzeria.gui.panels.Observer;
import pizzeria.order_system.menu.models.MenuItem;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.settings.ImagePaths.CONFIRM_MARK_IMG;
import static pizzeria.gui.settings.PizzeriaColors.*;
import static pizzeria.gui.settings.PizzeriaTypography.H2_FONT;

public class ItemDetailsPanel extends AbstractGridBagPanel implements Observer {

    private MenuItem menuItem;
    private final QuantityController quantityController;
    private final JLabel priceLab;

    public ItemDetailsPanel(JFrame parentFrame, MenuItem menuItem) {
        super(parentFrame);
        this.menuItem = menuItem;
        setMinimumSize(new Dimension(500, 300));
        setBackground(ACCENT_COLOR);

        priceLab = new JLabel(String.valueOf(menuItem.getPrice()));
        priceLab.setFont(H2_FONT);
        priceLab.setOpaque(true);
        priceLab.setBackground(BG_COLOR);
        priceLab.setHorizontalAlignment(JLabel.CENTER);
        priceLab.setMinimumSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 30);
        add(priceLab, gbc);

        quantityController = new QuantityController(parentFrame);
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 30, 0, 0);
        add(quantityController, gbc);
        quantityController.mountObserverListener();

        var confirmBtn = new JButton(new ImageIcon(CONFIRM_MARK_IMG));
        confirmBtn.setBackground(CONFIRM_COLOR);
        confirmBtn.setFocusPainted(false);
        confirmBtn.setBorder(null);
        confirmBtn.setMinimumSize(new Dimension(200, 50));
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 30, 0, 0);
        add(confirmBtn, gbc);
    }

    @Override
    public void update() {
        int quantity = quantityController.getQuantityCount();
        priceLab.setText(String.format("%.2f", menuItem.getPrice() * quantity));
    }
}
