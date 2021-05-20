package pizzeria.ui.printers;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.repositories.menu.InMemoryMenuRepository;
import pizzeria.order_system.menu.repositories.menu.MenuRepository;
import pizzeria.ui.OrderManager;

public class ConsoleOrderPrinter implements OrderPrinter{
    private MenuRepository repo;
    private OrderManager orderManager = new OrderManager();
    public ConsoleOrderPrinter() {repo = new InMemoryMenuRepository(); }

    @Override
    public void showOrderSummary() throws MenuItemNotFoundException {
        orderManager.makeAnOrder();
    }

    @Override
    public void confirmOrder() {

    }
}
