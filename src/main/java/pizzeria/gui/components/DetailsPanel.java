package pizzeria.gui.components;

import pizzeria.gui.MainFrame;
import pizzeria.gui.panels.Observer;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.order.models.Order;

import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends ConfirmPanel implements Observer {

    private MenuItem menuItem;

    public DetailsPanel(JFrame parentFrame, MenuItem menuItem) {
        super(parentFrame, new ItemDetailsPanel(parentFrame, menuItem));
        this.menuItem = menuItem;
        var itemDetailsPanel = (ItemDetailsPanel) contentPanel;
        itemDetailsPanel.mountObserverListener();

        this.setConfirmActionListener(e -> {
            addItemToOrderWithQuantity(menuItem, itemDetailsPanel.getQuantityController().getQuantityCount());
            JOptionPane.showMessageDialog(null, "Dodano do zamówienia!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        });

        this.modifyConfirmButton(0, 1, 1, new Insets(20, 0, 0, 0));
    }

    @Override
    public void update() {
        ItemDetailsPanel detailsPanel = (ItemDetailsPanel) contentPanel;
        int quantity = detailsPanel.getQuantityController().getQuantityCount();
        detailsPanel.getPriceLab().setText(String.format("%.2f", menuItem.getPrice() * quantity));
    }

    private void addItemToOrderWithQuantity(MenuItem item, int quantity) {
        Order order = ((MainFrame) parentFrame).getOrder();
        for (int i = 0; i < quantity; i++) {
            order.addItemToOrder(item);
        }
    }
}
