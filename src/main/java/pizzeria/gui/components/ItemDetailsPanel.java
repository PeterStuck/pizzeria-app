package pizzeria.gui.components;

import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.settings.PizzeriaColors.ACCENT_COLOR;
import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H2_FONT;

public class ItemDetailsPanel extends AbstractGridBagPanel {

    private final QuantityController quantityController;
    private final JLabel priceLab;

    public ItemDetailsPanel(JFrame parentFrame, MenuItem menuItem) {
        super(parentFrame);

        var panelDim = new Dimension(460, 200);
        var ingredientsPanelDim = new Dimension(460, 120);

        setBackground(ACCENT_COLOR);
        setMinimumSize(panelDim);
        setPreferredSize(panelDim);

        quantityController = new QuantityController(parentFrame);
        int nextGridY = 0;
        if (menuItem instanceof Pizza) {
            var ingredientsScroll = new JScrollPane(new IngredientsPanel(parentFrame, menuItem), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            gbc.gridx = 0;
            gbc.gridy = nextGridY;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(0, 0, 20, 0);
            ingredientsScroll.setMinimumSize(ingredientsPanelDim);
            ingredientsScroll.setPreferredSize(ingredientsPanelDim);
            ingredientsScroll.getVerticalScrollBar().setUnitIncrement(10);
            ingredientsScroll.setBorder(null);
            add(ingredientsScroll, gbc);

            nextGridY++;
        }

        priceLab = new JLabel(String.valueOf(menuItem.getPrice()));
        priceLab.setFont(H2_FONT);
        priceLab.setOpaque(true);
        priceLab.setBackground(BG_COLOR);
        priceLab.setHorizontalAlignment(JLabel.CENTER);
        priceLab.setMinimumSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = nextGridY++;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 30);
        add(priceLab, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0, 30, 0, 0);
        add(quantityController, gbc);
    }

    public void mountObserverListener() {
        quantityController.mountObserverListener();
    }

    public QuantityController getQuantityController() {
        return quantityController;
    }

    public JLabel getPriceLab() {
        return priceLab;
    }
}
