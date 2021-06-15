package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H3_FONT;
import static pizzeria.gui.settings.PizzeriaTypography.H4_FONT;

public class IngredientsPanel extends AbstractGridBagPanel {

    public IngredientsPanel(JFrame parentFrame, MenuItem menuItem) {
        super(parentFrame);

        List<String> ingredients = ((Pizza) menuItem).getIngredients();
        var ingredientsDim = new Dimension(460, 30);
        var panelDim = new Dimension(460, (ingredients.size() * 30) + 50);

        setMinimumSize(panelDim);
        setPreferredSize(panelDim);
        setBackground(BG_COLOR);

        Border emptyBorder = BorderFactory.createEmptyBorder(0, 20, 0, 0);

        var ingredientsLab = this.createLabel("Składniki:", new Dimension(440, 40), H3_FONT, emptyBorder);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0;
        add(ingredientsLab, gbc);

        int nextGridY = 1;
        for (String ingredient : ingredients) {
            var tmpIngredient = this.createLabel("- " + ingredient, ingredientsDim, H4_FONT, emptyBorder);
            gbc.gridy = nextGridY;
            add(tmpIngredient, gbc);

            nextGridY++;
        }

    }

    private JLabel createLabel(String text, Dimension dim, Font font, Border border) {
        var label = new JLabel(text);
        label.setPreferredSize(dim);
        label.setFont(font);
        label.setBorder(border);

        return label;
    }
}
