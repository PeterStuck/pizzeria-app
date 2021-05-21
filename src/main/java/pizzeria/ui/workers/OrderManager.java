package pizzeria.ui.workers;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.repositories.menu.InMemoryMenuRepository;
import pizzeria.order_system.menu.repositories.menu.MenuRepository;
import pizzeria.order_system.order.models.Order;

public class OrderManager {
    private MenuService service;
    private Order order;
    private MenuRepository repo;

    public OrderManager() {
        service = new MenuService();
        order = new Order();
        repo = new InMemoryMenuRepository();
    }

    public void makeAnOrder() {
        this.addPizzaToOrder();
        this.addDrinkToOrder();

        if (this.isAnotherItemsRequested()) {
            this.makeAnOrder();
        }
    }

    private void addPizzaToOrder() {
        boolean isPizzaChosen = service.askForPizza();
        if(isPizzaChosen){
            this.addPizzaToOrderIfSelected();
        }
    }

    private void addPizzaToOrderIfSelected() {
        try {
            int chosenPizzaNumber = service.pizzaItemNumber();
            MenuItem chosenPizza = repo.findPizzaById(chosenPizzaNumber);
            this.askForQuantityAndComputeQuantityOfItem(chosenPizza);
        } catch (MenuItemNotFoundException e){
            System.out.println("Nie znaleziono pizzy o takim numerze");
            addPizzaToOrderIfSelected();
        } catch (Exception ex){
            System.out.println("Ups, coś poszło nie tak, spróbuj jeszcze raz");
            addPizzaToOrderIfSelected();
        }
    }

    private void addDrinkToOrder() {
        boolean isDrinkChosen = service.askForDrink();
        if(isDrinkChosen){
            this.addDrinkToOrderIfSelected();
        }
    }

    private void addDrinkToOrderIfSelected() {
        try {
            int chosenDrinkNumber = service.drinkItemNumber();
            MenuItem chosenDrink = repo.findDrinkById(chosenDrinkNumber);
            this.askForQuantityAndComputeQuantityOfItem(chosenDrink);
        } catch (MenuItemNotFoundException e){
            System.out.println("Nie znaleziono napoju o takim numerze");
            addDrinkToOrderIfSelected();
        } catch (Exception ex){
            System.out.println("Ups, coś poszło nie tak, spróbuj jeszcze raz");
            addDrinkToOrderIfSelected();
        }
    }

    private void askForQuantityAndComputeQuantityOfItem(MenuItem item) {
        int desiredQuantity = service.howManyItems();
        for(int i = 0; i < desiredQuantity; i++){
            order.addItemToOrder(item);
        }
    }

    public boolean isAnotherItemsRequested() {
        return this.service.askForOtherItems();
    }

    public boolean confirmOrder() {
        return this.service.confirmOrder();
    }

    public void setService(MenuService service) {
        this.service = service;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setRepo(MenuRepository repo) {
        this.repo = repo;
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

