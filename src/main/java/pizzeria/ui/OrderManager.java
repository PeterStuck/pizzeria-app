package pizzeria.ui;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.repositories.menu.InMemoryMenuRepository;
import pizzeria.order_system.menu.repositories.menu.MenuRepository;
import pizzeria.order_system.order.models.Order;

public class OrderManager {
    private MenuService service = new MenuService();
    private Order order = new Order();
    private MenuRepository repo = new InMemoryMenuRepository();

    public void addPizzaToOrder() throws MenuItemNotFoundException {
        int chosenPizzaNumber = service.pizzaItemNumber();
        if (chosenPizzaNumber != 0){
            MenuItem chosenPizza = repo.findPizzaById(chosenPizzaNumber);
            order.addItemToOrder(chosenPizza);
        }
    }
    public void addDrinkToOrder() throws MenuItemNotFoundException {
        int chosenDrinkNumber = service.drinkItemNumber();
        if (chosenDrinkNumber != 0){
            MenuItem chosenDrink = repo.findDrinkById(chosenDrinkNumber);
            order.addItemToOrder(chosenDrink);
        }
    }
    public void makeAnOrder() throws MenuItemNotFoundException {
        OrderManager orderManager = new OrderManager();
        orderManager.addPizzaToOrder();
        orderManager.addDrinkToOrder();
    }
    public MenuService getService() {
        return service;
    }

    public Order getOrder() {
        return order;
    }

    public MenuRepository getRepo() {
        return repo;
    }
}

