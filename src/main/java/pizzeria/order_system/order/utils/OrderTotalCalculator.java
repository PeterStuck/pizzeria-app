package pizzeria.order_system.order.utils;

import pizzeria.order_system.order.models.Order;
import pizzeria.order_system.order.models.OrderItem;

public class OrderTotalCalculator {

    public static Float calculateOrderTotal(Order order) {
        float total = 0F;

        for (OrderItem orderItem : order.getOrderList()) {
            total += orderItem.getMenuItem().getPrice() * orderItem.getQuantity();
        }

        return total;
    }

}
