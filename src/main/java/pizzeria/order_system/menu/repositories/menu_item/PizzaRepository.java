package pizzeria.order_system.menu.repositories.menu_item;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PizzaRepository implements MenuItemRepository {

    private List<Pizza> allPizzas = Arrays.asList(
            new Pizza(1, "Margherita", 19.99F, ItemCategory.PIZZA, null),
            new Pizza(2, "Hawajska", 10.99F, ItemCategory.PIZZA, null)
    );

    @Override
    public List<? extends MenuItem> findAll() {
        return allPizzas;
    }

    @Override
    public MenuItem findById(int id) throws MenuItemNotFoundException {
        Optional<Pizza> optionalDrink = allPizzas.stream()
                .filter(drink -> drink.getId() == id)
                .findFirst();

        if (optionalDrink.isPresent()) {
            return optionalDrink.get();
        }
        throw new MenuItemNotFoundException("Pizza with id: " + id + " not found.");
    }

}
