package pizzeria.files_management;

import pizzeria.order_system.order.models.Order;
import pizzeria.order_system.order.utils.OrderTotalCalculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileOrderLogWriter {

    private final OrderConverter converter;
    private Order order;

    private String dataSeparator;
    private final String LOG_FILE_PATH = "src/order_log.dat";

    public FileOrderLogWriter(Order order) {
        this.dataSeparator = " - ";
        this.order = order;
        this.converter = new OrderConverter(order.getOrderList());
    }

    public void registerOrder() {
        try {
            FileWriter writer = new FileWriter(LOG_FILE_PATH, true);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write(
                    this.getCurrentDate() + this.dataSeparator +
                        this.converter.convertOrderedFoodToString() + ", " +
                        this.converter.convertOrderedDrinksToString() + this.dataSeparator +
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

    public void setOrder(Order order) {
        this.order = order;
    }
}
