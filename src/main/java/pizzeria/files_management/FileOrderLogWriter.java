package pizzeria.files_management;

import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.Pizza;
import pizzeria.order_system.order.models.Order;
import pizzeria.order_system.order.models.OrderItem;
import pizzeria.order_system.order.utils.OrderTotalCalculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileOrderLogWriter {

    private String dataSeparator;
    private final String LOG_FILE_PATH = "src/order_log.dat";
    private final OrderConverter converter;

    public FileOrderLogWriter() {
        this.dataSeparator = " - ";
        this.converter = new OrderConverter();
    }

    public void registerOrder(Order order) {
        try {
            FileWriter writer = new FileWriter(LOG_FILE_PATH, true);
            BufferedWriter bw = new BufferedWriter(writer);

            List<OrderItem> orderedItems = order.getOrderList();
            bw.write(
                    this.getCurrentDate() + this.dataSeparator +
                        this.converter.convertOrderedFoodToString(orderedItems) + ", " +
                        this.converter.convertOrderedDrinksToString(orderedItems) + this.dataSeparator +
                        convertFloatToPriceFormat(OrderTotalCalculator.calculateOrderTotal(order)) + " PLN"
            );
            bw.newLine();

            bw.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Napotkano problem związany z zapisem zamówienia do pliku.");
        }
    }

    private String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss"+ this.dataSeparator +"dd/MM/yyyy");

        return dt1.format(date);
    }

    private String convertFloatToPriceFormat(float price) {
        return String.format("%.2f", price);
    }

    public void setDataSeparator(String dataSeparator) {
        this.dataSeparator = dataSeparator;
    }

    public static void main(String[] args) throws ParseException {
        Pizza pizza = new Pizza(1, "TEST", 11.0F, ItemCategory.PIZZA, null);
        Pizza pizza2 = new Pizza(2, "TEST2", 11.0F, ItemCategory.PIZZA, null);

        Order order = new Order();
        order.addItemToOrder(pizza);
        order.addItemToOrder(pizza2);

        var orderLog = new FileOrderLogWriter();
        orderLog.registerOrder(order);
    }
}
