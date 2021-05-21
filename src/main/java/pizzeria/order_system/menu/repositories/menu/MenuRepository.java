package pizzeria.order_system.menu.repositories.menu;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.MenuItem;
import java.util.List;

public interface MenuRepository {

    List<MenuItem> findAllPizzas();

    MenuItem findPizzaById(int id) throws MenuItemNotFoundException;

    List<MenuItem> findAllDrinks();

    MenuItem findDrinkById(int id) throws MenuItemNotFoundException;

}
