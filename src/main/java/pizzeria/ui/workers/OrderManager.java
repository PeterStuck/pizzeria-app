package pizzeria.ui.workers;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.repositories.menu.InMemoryMenuRepository;
import pizzeria.order_system.menu.repositories.menu.MenuRepository;
import pizzeria.order_system.order.models.Order;

public class OrderManager {
    private MenuService service = new MenuService();
    private Order order = new Order();
    private MenuRepository repo = new InMemoryMenuRepository();

    private void addPizzaToOrder() {
        boolean isPizzaChosen = service.askForPizza();
        if(isPizzaChosen){
            this.addPizzaToOrderIfSelected();
        }
    }
    private void addPizzaToOrderIfSelected() {
        try{
            int chosenPizzaNumber = service.pizzaItemNumber();
            if (chosenPizzaNumber != 0) {
                MenuItem chosenPizza = repo.findPizzaById(chosenPizzaNumber);
                this.askForQuantityAndComputeQuantityOfItem(chosenPizza);
            }
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
        try{
            int chosenDrinkNumber = service.drinkItemNumber();
            if (chosenDrinkNumber != 0){
                MenuItem chosenDrink = repo.findDrinkById(chosenDrinkNumber);
                this.askForQuantityAndComputeQuantityOfItem(chosenDrink);
            }
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

    public void makeAnOrder() {
        this.addPizzaToOrder();
        this.addDrinkToOrder();
    }
    public boolean confirmOrder() {
        return this.service.confirmOrder();
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

