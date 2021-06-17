package pizzeria.files_management;

import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.order.models.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

class OrderConverter {

    private List<OrderItem> orderedFoodList;

    public OrderConverter(List<OrderItem> orderedFoodList) {
        this.orderedFoodList = orderedFoodList;
    }

    public String convertOrderedFoodToString() {
        List<OrderItem> foodOnlyList = this.getOrderedItems(false);

        return convertOrderedItemsToStringFormat(foodOnlyList);
    }

    public String convertOrderedDrinksToString() {
        List<OrderItem> drinksOnlyList = this.getOrderedItems(true);

        return convertOrderedItemsToStringFormat(drinksOnlyList);
    }

    private List<OrderItem> getOrderedItems(boolean isDrink) {
        return orderedFoodList.stream()
                .filter(orderedItem -> isDrink == (orderedItem.getMenuItem().getCategory() == ItemCategory.DRINK))
                .collect(Collectors.toList());
    }

    private String convertOrderedItemsToStringFormat(List<OrderItem> orderedItems) {
        StringBuilder convertedOrderedFoodNames = new StringBuilder();
        convertedOrderedFoodNames.append("[");

        for (OrderItem orderItem : orderedItems) {
            MenuItem tmpItem = orderItem.getMenuItem();
            convertedOrderedFoodNames.append(tmpItem.getName() + " x" +  + orderItem.getQuantity() + ";");
        }
        convertedOrderedFoodNames.append("]");

        return convertedOrderedFoodNames.toString();
    }

    public void setOrderedFoodList(List<OrderItem> orderedFoodList) {
        this.orderedFoodList = orderedFoodList;
    }
}
