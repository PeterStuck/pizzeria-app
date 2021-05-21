package pizzeria.order_system.menu.repositories.menu_item;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class MenuItemRepository {

    protected List<MenuItem> menuItems;

    protected MenuItemRepository() {
        menuItems = new ArrayList<>();
    }

    public List<MenuItem> findAll() {
        return menuItems;
    }

    public MenuItem findById(int id) throws MenuItemNotFoundException {
        Optional<MenuItem> optionalMenuItem = this.menuItems.stream()
                .filter(menuItem -> menuItem.getId() == id)
                .findFirst();

        if (optionalMenuItem.isPresent()) {
            return optionalMenuItem.get();
        }
        throw new MenuItemNotFoundException("Item with id: " + id + " not found.");
    }
}
