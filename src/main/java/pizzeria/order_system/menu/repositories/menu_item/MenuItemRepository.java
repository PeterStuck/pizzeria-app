package pizzeria.order_system.menu.repositories.menu_item;

import java.util.List;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.MenuItem;

public interface MenuItemRepository {

    List<? extends MenuItem> findAll();

    MenuItem findById(int id) throws MenuItemNotFoundException;

}
