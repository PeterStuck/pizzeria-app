package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;
import pizzeria.gui.panels.Observer;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;

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

        var panelDim = new Dimension(500, 300);
        var ingredientsPanelDim = new Dimension(460, 120);
        var labDim = new Dimension(200, 50);

        setMinimumSize(panelDim);
        setBackground(ACCENT_COLOR);

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
        priceLab.setMinimumSize(labDim);
        gbc.gridx = 0;
        gbc.gridy = nextGridY++;
        gbc.gridwidth = 1;
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
        confirmBtn.setMinimumSize(labDim);
        gbc.gridy = nextGridY++;
        gbc.insets = new Insets(20, 30, 0, 0);
        add(confirmBtn, gbc);
    }

    @Override
    public void update() {
        int quantity = quantityController.getQuantityCount();
        priceLab.setText(String.format("%.2f", menuItem.getPrice() * quantity));
    }
}
