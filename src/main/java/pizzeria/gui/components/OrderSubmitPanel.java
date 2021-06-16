package pizzeria.gui.components;

import pizzeria.gui.panels.AbstractGridBagPanel;

import javax.swing.*;

import java.awt.*;

import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;

public class OrderSubmitPanel extends AbstractGridBagPanel {

    public OrderSubmitPanel(JFrame parentFrame) {
        super(parentFrame);

        var panelDim = new Dimension(460, 200);

        setBackground(BG_COLOR);
        setMinimumSize(panelDim);
        setPreferredSize(panelDim);

    }
}
