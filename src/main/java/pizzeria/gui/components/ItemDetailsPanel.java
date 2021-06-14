package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;
import pizzeria.order_system.menu.models.MenuItem;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.settings.PizzeriaColors.ACCENT_COLOR;
import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H2_FONT;

public class ItemDetailsPanel extends AbstractGridBagPanel {

    public ItemDetailsPanel(JFrame parentFrame, MenuItem menuItem) {
        super(parentFrame);
        setMinimumSize(new Dimension(500, 300));
        setBackground(ACCENT_COLOR);

        var priceLab = new JLabel(String.valueOf(menuItem.getPrice()));
        priceLab.setFont(H2_FONT);
        priceLab.setOpaque(true);
        priceLab.setBackground(BG_COLOR);
        priceLab.setHorizontalAlignment(JLabel.CENTER);
        priceLab.setMinimumSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 30);
        add(priceLab, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0, 30, 0, 0);
        add(new QuantityController(parentFrame));
    }
}
