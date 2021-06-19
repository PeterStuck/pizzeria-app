package pizzeria.gui.panels;

import pizzeria.files_management.FileOrderLogWriter;
import pizzeria.gui.MainFrame;
import pizzeria.gui.components.ConfirmPanel;
import pizzeria.gui.components.OrderSubmitPanel;
import pizzeria.order_system.order.models.Order;

import javax.swing.*;
import java.awt.*;

public class SubmitPanel extends AbstractPanelWithNavbar {

    private FileOrderLogWriter orderLogWriter;

    public SubmitPanel(JFrame parentFrame, JPanel previousPanel) {
        super(parentFrame, previousPanel, "Podsumowanie");

        navbar.hideSubmitButton();

        var submitScrollPane = new JScrollPane(new OrderSubmitPanel(parentFrame), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        submitScrollPane.setPreferredSize(new Dimension(460, 200));
        submitScrollPane.setMinimumSize(new Dimension(460, 200));
        submitScrollPane.setBorder(null);
        var cp = new ConfirmPanel(parentFrame, submitScrollPane);
        cp.setConfirmActionListener((e) -> {
            Order order = ((MainFrame) parentFrame).getOrder();

            if (order.getOrderList().size() > 0) {
                orderLogWriter = new FileOrderLogWriter(order);
                orderLogWriter.registerOrder();
                order.getOrderList().clear();

                JOptionPane.showMessageDialog(null, "Zamówienie zostało złożone!", "Informacja", JOptionPane.INFORMATION_MESSAGE);

                parentFrame.remove(SubmitPanel.this);
                parentFrame.add(new CategorySelectPanel(parentFrame));

                parentFrame.revalidate();
                parentFrame.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Dodaj coś do swojego zamówienia zanim je podsumujesz!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cp, gbc);
    }
}
