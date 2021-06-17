package pizzeria.gui.panels;

import pizzeria.gui.components.ConfirmPanel;
import pizzeria.gui.components.OrderSubmitPanel;

import javax.swing.*;
import java.awt.*;

public class SubmitPanel extends AbstractPanelWithNavbar {

    public SubmitPanel(JFrame parentFrame, JPanel previousPanel) {
        super(parentFrame, previousPanel, "Podsumowanie");

        navbar.hideSubmitButton();

        var submitScrollPane = new JScrollPane(new OrderSubmitPanel(parentFrame), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        submitScrollPane.setPreferredSize(new Dimension(460, 200));
        submitScrollPane.setMinimumSize(new Dimension(460, 200));
        var cp = new ConfirmPanel(parentFrame, submitScrollPane);
        cp.setConfirmActionListener((e) -> {
            System.out.println("SUBMIT CONFIRMED!");
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cp, gbc);

    }

}
