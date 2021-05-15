package pizzeria.order_system.menu.repositories.menu_item;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.Drink;
import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DrinkRepository implements MenuItemRepository {

    private List<Drink> allDrinks = Arrays.asList(
            new Drink(1, "Coca-Cola", 2.99F, ItemCategory.DRINK),
            new Drink(2, "Fanta", 2.99F, ItemCategory.DRINK),
            new Drink(3, "Woda Mineralna", 0.99F, ItemCategory.DRINK),
            new Drink(4, "Lemoniada", 4.99F, ItemCategory.DRINK)
    );

    @Override
    public List<? extends MenuItem> findAll() {
        return allDrinks;
    }

    @Override
    public MenuItem findById(int id) throws MenuItemNotFoundException {
        Optional<Drink> optionalDrink = allDrinks.stream()
                .filter(drink -> drink.getId() == id)
                .findFirst();

        if (optionalDrink.isPresent()) {
            return optionalDrink.get();
        }
        throw new MenuItemNotFoundException("Drink with id: " + id + " not found.");
    }

}
