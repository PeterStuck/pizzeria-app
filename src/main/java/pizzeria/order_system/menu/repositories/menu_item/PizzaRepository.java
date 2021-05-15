package pizzeria.order_system.menu.repositories.menu_item;

import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;

import java.util.Arrays;
import java.util.List;

public class PizzaRepository extends MenuItemRepository {

    private List<MenuItem> allPizzas = Arrays.asList(
            new Pizza(1, "Margherita", 19.99F, ItemCategory.PIZZA, null),
            new Pizza(2, "Hawajska", 10.99F, ItemCategory.PIZZA, null)
    );

    public PizzaRepository() {
        this.menuItems = allPizzas;
    }
}
