package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;
import pizzeria.order_system.menu.models.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ItemSelectorPanel extends AbstractGridBagPanel {

    public ItemSelectorPanel(JFrame parentFrame, List<MenuItem> items) {
        super(parentFrame);
        var panelDim = new Dimension(700, (int) (Math.ceil((double)items.size() / 3) * 170) + 50);
        setPreferredSize(panelDim);
        setMinimumSize(panelDim);

        setBackground(Color.CYAN);

        int outerMargin = 75;
        int innerMargin = 50;
        int topBottomMargin = 10;


        for (int i = 0, y = 0, k = 0; i < items.size(); i++) {
            if (k == 3) {
                k = 0;
                y++;
            }

            gbc.gridx = k;
            gbc.gridy = y;
            if (k == 0) {
                gbc.insets = new Insets(topBottomMargin, outerMargin, topBottomMargin, innerMargin);
            }
            else if (k == 1) {
                gbc.insets = new Insets(topBottomMargin, 0, topBottomMargin, 0);
            }
            else {
                gbc.insets = new Insets(topBottomMargin, innerMargin, topBottomMargin, outerMargin);
            }
            add(new ItemPanel(parentFrame, items.get(i).getName(), String.valueOf(items.get(i).getPrice()), "src\\main\\java\\assets\\placeholder.png"), gbc);

            k++;
        }

        revalidate();
        repaint();
    }

}
