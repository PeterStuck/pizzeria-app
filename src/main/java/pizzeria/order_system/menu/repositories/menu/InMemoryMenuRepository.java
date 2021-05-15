package pizzeria.order_system.menu.repositories.menu;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.repositories.menu_item.DrinkRepository;
import pizzeria.order_system.menu.repositories.menu_item.MenuItemRepository;
import pizzeria.order_system.menu.repositories.menu_item.PizzaRepository;

import java.util.List;

public class InMemoryMenuRepository implements MenuRepository {

    private MenuItemRepository drinkRepo;
    private MenuItemRepository pizzaRepo;

    public InMemoryMenuRepository() {
        this.drinkRepo = new DrinkRepository();
        this.pizzaRepo = new PizzaRepository();
    }

    @Override
    public List<? extends MenuItem> findAllPizzas() {
        return this.pizzaRepo.findAll();
    }

    @Override
    public MenuItem findPizzaById(int id) throws MenuItemNotFoundException {
        return this.pizzaRepo.findById(id);
    }

    @Override
    public List<? extends MenuItem> findAllDrinks() {
        return this.drinkRepo.findAll();
    }

    @Override
    public MenuItem findDrinkById(int id) throws MenuItemNotFoundException {
        return this.drinkRepo.findById(id);
    }
}
