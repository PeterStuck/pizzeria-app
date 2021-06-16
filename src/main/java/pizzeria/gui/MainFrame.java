package pizzeria.gui;

import pizzeria.gui.panels.StartPanel;
import pizzeria.order_system.order.models.Order;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Runnable {

    private final GridBagConstraints gbc = new GridBagConstraints();

    private final Order order;

    public MainFrame() {
        order = new Order();

        setTitle("Buon Giorno");
        setLayout(new GridBagLayout());
        setSize(new Dimension(1000, 500));

        gbc.gridy = 0;
        gbc.gridx = 0;
        add(new StartPanel(this), gbc);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void run() {

    }

    public Order getOrder() {
        return order;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new MainFrame());
    }
}
