package pizzeria;

import pizzeria.files_management.FileOrderLogWriter;
import pizzeria.order_system.order.models.Order;
import pizzeria.ui.printers.ConsoleOrderPrinter;
import pizzeria.ui.workers.OrderManager;

public class System {
    private OrderManager orderManager = new OrderManager();
    private ConsoleOrderPrinter orderPrinter;
    private FileOrderLogWriter orderLog;

    public void makeAnOrder() {
        orderManager.makeAnOrder();

        Order order = orderManager.getOrder();

        if (order.getOrderList().size() > 0) {
            orderPrinter = new ConsoleOrderPrinter(order);
            orderPrinter.showOrderSummary();

            if(orderManager.confirmOrder()){
                orderLog = new FileOrderLogWriter(order);
                orderLog.registerOrder();
            }
        }
    }

    public static void main(String[] args){
        System system = new System();
        system.makeAnOrder();
    }
}
