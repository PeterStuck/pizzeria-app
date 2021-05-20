package pizzeria.files_management;

import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.order.models.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class OrderConverter {

    public String convertOrderedFoodToString(List<OrderItem> orderedFoodList) {
        List<MenuItem> foodOnlyList = this.getOrderedItems(orderedFoodList, false);

        return convertOrderedItemsToStringFormat(foodOnlyList);
    }

    public String convertOrderedDrinksToString(List<OrderItem> orderedFoodList) {
        List<MenuItem> drinksOnlyList = this.getOrderedItems(orderedFoodList, true);

        return convertOrderedItemsToStringFormat(drinksOnlyList);
    }

    private List<MenuItem> getOrderedItems(List<OrderItem> orderedFoodList, boolean isDrink) {
        return orderedFoodList.stream()
                .map(orderItem -> orderItem.getMenuItem())
                .filter(orderedItem -> isDrink == (orderedItem.getCategory() == ItemCategory.DRINK))
                .collect(Collectors.toList());
    }

    private String convertOrderedItemsToStringFormat(List<MenuItem> orderedItems) {
        StringBuilder convertedOrderedFoodNames = new StringBuilder();
        convertedOrderedFoodNames.append("[");

        for (MenuItem food : orderedItems) {
            convertedOrderedFoodNames.append(food.getName() + ";");
        }
        convertedOrderedFoodNames.append("]");

        return convertedOrderedFoodNames.toString();
    }

}
