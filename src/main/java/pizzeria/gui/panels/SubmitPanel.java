package pizzeria.gui.panels;

import pizzeria.gui.components.ConfirmPanel;
import pizzeria.gui.components.OrderSubmitPanel;

import javax.swing.*;

public class SubmitPanel extends AbstractPanelWithNavbar {

    public SubmitPanel(JFrame parentFrame, JPanel previousPanel) {
        super(parentFrame, previousPanel, "Podsumowanie");

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new ConfirmPanel(parentFrame, new OrderSubmitPanel(parentFrame), (e) -> {
            System.out.println("SUBMIT CONFIRMED!");
        }), gbc);

    }

}
