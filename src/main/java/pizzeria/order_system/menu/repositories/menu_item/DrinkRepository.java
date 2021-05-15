package pizzeria.order_system.menu.repositories.menu_item;

import pizzeria.order_system.menu.models.Drink;
import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;

import java.util.Arrays;
import java.util.List;

public class DrinkRepository extends MenuItemRepository {

    private List<MenuItem> allDrinks = Arrays.asList(
            new Drink(1, "Coca-Cola", 2.99F, ItemCategory.DRINK),
            new Drink(2, "Fanta", 2.99F, ItemCategory.DRINK),
            new Drink(3, "Woda Mineralna", 0.99F, ItemCategory.DRINK),
            new Drink(4, "Lemoniada", 4.99F, ItemCategory.DRINK)
    );

    public DrinkRepository() {
        this.menuItems = allDrinks;
    }
}
