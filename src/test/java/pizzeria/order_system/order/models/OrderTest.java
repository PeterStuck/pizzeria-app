package pizzeria.order_system.order.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pizzeria.order_system.menu.models.Drink;
import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OrderTest {

    private Order order;
    private MenuItem menuItem;

    @BeforeEach
    void setUp() {
        order = new Order();
        menuItem = new Pizza(1, "TEST", 0F, ItemCategory.PIZZA, null);
    }

    @Test
    void shouldBeAbleToAddOrderItemToOrder() {
        order.addItemToOrder(menuItem);

        assertThat(order.getOrderList(), hasSize(1));
        assertThat(order.getOrderList().get(0).getMenuItem(), equalTo(menuItem));
        assertThat(order.getOrderList().get(0).getQuantity(), equalTo(1));
    }

    @Test
    void shouldBeAbleToRemoveOrderItemFromOrder() {
        order.addItemToOrder(menuItem);
        order.removeItemFromOrder(this.order.getOrderList().get(0));

        assertThat(order.getOrderList(), hasSize(0));
    }

    @Test
    void shouldIncreaseQuantityOfOrderItemWhenAlreadyExistsInOrder() {
        order.addItemToOrder(menuItem);
        order.addItemToOrder(menuItem);

        assertThat(order.getOrderList(), hasSize(1));
        assertThat(order.getOrderList().get(0).getQuantity(), equalTo(2));
    }

    @Test
    void shouldBeAbleToStoreDifferentItemsInOneOrder() {
        order.addItemToOrder(menuItem);
        order.addItemToOrder(new Drink(1, "TEST", 1.0F, ItemCategory.DRINK));

        assertThat(order.getOrderList(), hasSize(2));
    }
}