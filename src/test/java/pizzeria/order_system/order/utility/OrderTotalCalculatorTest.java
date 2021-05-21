package pizzeria.order_system.order.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;
import pizzeria.order_system.order.models.Order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OrderTotalCalculatorTest {

    private Order order;
    private MenuItem menuItem;

    @BeforeEach
    void setUp() {
        order = new Order();
        menuItem = new Pizza(1, "TEST", 1F, ItemCategory.PIZZA, null);
    }

    @Test
    void orderWithNoItemsShouldReturnZeroAsTotal() {
        assertThat(OrderTotalCalculator.calculateOrderTotal(order), equalTo(0F));
    }

    @Test
    void shouldReturnTotalOfOrderWithMoreItemsWithOneQuantity() {
        MenuItem menuItem2 = new Pizza(2, "TEST", 1F, ItemCategory.PIZZA, null);
        MenuItem menuItem3 = new Pizza(3, "TEST", 1F, ItemCategory.PIZZA, null);
        order.addItemToOrder(menuItem);
        order.addItemToOrder(menuItem2);
        order.addItemToOrder(menuItem3);

        assertThat(OrderTotalCalculator.calculateOrderTotal(order), equalTo(3F));
    }

    @Test
    void shouldReturnValidTotalWithMoreItemsWithMoreQuantity() {
        MenuItem menuItem2 = new Pizza(2, "TEST", 1F, ItemCategory.PIZZA, null);
        MenuItem menuItem3 = new Pizza(3, "TEST", 1F, ItemCategory.PIZZA, null);
        order.addItemToOrder(menuItem);
        order.addItemToOrder(menuItem);
        order.addItemToOrder(menuItem2);
        order.addItemToOrder(menuItem2);
        order.addItemToOrder(menuItem3);
        order.addItemToOrder(menuItem3);

        assertThat(OrderTotalCalculator.calculateOrderTotal(order), equalTo(6F));
    }
}