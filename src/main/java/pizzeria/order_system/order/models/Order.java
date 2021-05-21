package pizzeria.order_system.order.models;

import pizzeria.order_system.menu.models.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order {

    private List<OrderItem> orderList;

    public Order() {
        orderList = new ArrayList<>();
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItem> orderList) {
        this.orderList = orderList;
    }

    public void addItemToOrder(MenuItem orderedItem) {
        this.addNewItemToOrderOrIncreaseQuantity(orderedItem);
    }

    private void addNewItemToOrderOrIncreaseQuantity(MenuItem orderedItem) {
        Optional<OrderItem> orderItemOptional = this.orderList.stream()
                .filter(oi -> oi.getMenuItem().getCategory() == orderedItem.getCategory())
                .filter(oi -> oi.getMenuItem().getId() == orderedItem.getId())
                .findFirst();

        if (orderItemOptional.isPresent()) {
            increaseItemQuantity(orderItemOptional.get());
        } else {
            this.orderList.add(new OrderItem(orderedItem, 1));
        }
    }

    private void increaseItemQuantity(OrderItem orderItem) {
        int indexToReplace = this.orderList.indexOf(orderItem);
        orderItem.setQuantity(orderItem.getQuantity() + 1);
        this.orderList.set(indexToReplace, orderItem);
    }

    public void removeItemFromOrder(OrderItem orderItem) {
        this.orderList.remove(orderItem);
    }
}
