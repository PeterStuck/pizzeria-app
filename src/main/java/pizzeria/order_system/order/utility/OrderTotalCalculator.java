package pizzeria.order_system.order.utility;

import pizzeria.order_system.order.models.Order;
import pizzeria.order_system.order.models.OrderItem;

public class OrderTotalCalculator {

    public static Float calculateOrderTotal(Order order) {
        OrderItem[] orderedItems = order.getOrderList().toArray(OrderItem[]::new);

        return computeOrderTotal(orderedItems);
    }

    private static Float computeOrderTotal(OrderItem ... orderedItems) {
        float total = 0F;

        for (OrderItem orderItem : orderedItems) {
            total += orderItem.getMenuItem().getPrice() * orderItem.getQuantity();
        }

        return total;
    }

}
