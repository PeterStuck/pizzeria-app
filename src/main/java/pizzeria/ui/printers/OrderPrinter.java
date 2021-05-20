package pizzeria.ui.printers;

import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;

public interface OrderPrinter {

    void showOrderSummary() throws MenuItemNotFoundException;

    void confirmOrder();

}
