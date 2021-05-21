package pizzeria.ui.printers;

import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.order.models.Order;
import pizzeria.order_system.order.models.OrderItem;
import pizzeria.order_system.order.utility.OrderTotalCalculator;

import java.util.List;

public class ConsoleOrderPrinter implements OrderPrinter{
    private String horizontalLine = "_______________________";
    private Order order;

    public ConsoleOrderPrinter(Order order) {
        this.order = order;
    }

    @Override
    public void showOrderSummary() {
        List<OrderItem> orderList = order.getOrderList();
        int itemIdInOrder = 1;
        System.out.println(horizontalLine+"\n\tPODSUMOWANIE\n"+horizontalLine);

        for (OrderItem orderItem : orderList){
            MenuItem tmpItem = orderItem.getMenuItem();
            System.out.println(
                    itemIdInOrder+"\t"+
                    tmpItem.getName()+" "+
                    tmpItem.getPrice()+" x"+
                    orderItem.getQuantity()
            );

            itemIdInOrder++;
        }

        String convertedOrderTotal = convertFloatToPriceFormat(OrderTotalCalculator.calculateOrderTotal(order));
        System.out.println(horizontalLine+"\nSUMA\t\t\t"+ convertedOrderTotal);
    }

    private String convertFloatToPriceFormat(float price) {
        return String.format("%.2f", price);
    }

}

