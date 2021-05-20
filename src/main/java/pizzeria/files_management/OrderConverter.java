package pizzeria.files_management;

import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.order.models.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class OrderConverter {

    public String convertOrderedFoodToString(List<OrderItem> orderedFoodList) {
        List<MenuItem> foodOnlyList = this.getOrderedFoodOnly(orderedFoodList);

        return convertOrderedItemsToStringFormat(foodOnlyList);
    }

    private List<MenuItem> getOrderedFoodOnly(List<OrderItem> orderedFoodList) {
        return orderedFoodList.stream()
                .map(orderItem -> orderItem.getMenuItem())
                .filter(orderedItem -> orderedItem.getCategory() != ItemCategory.DRINK)
                .collect(Collectors.toList());
    }

    public String convertOrderedDrinksToString(List<OrderItem> orderedFoodList) {
        List<MenuItem> drinksOnlyList = this.getOrderedDrinksOnly(orderedFoodList);

        return convertOrderedItemsToStringFormat(drinksOnlyList);
    }

    private List<MenuItem> getOrderedDrinksOnly(List<OrderItem> orderedFoodList) {
        return orderedFoodList.stream()
                .map(orderItem -> orderItem.getMenuItem())
                .filter(orderedItem -> orderedItem.getCategory() == ItemCategory.DRINK)
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
