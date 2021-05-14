package pizzeria.order_system.menu.models;

import pizzeria.order_system.menu.exceptions.IngredientAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    private Pizza pizza;

    @BeforeEach
    void setUp() {
        pizza = new Pizza(1, "TEST", 19.0F, ItemCategory.PIZZA, null);
    }

    @Test
    void shouldInitializeListWhenIsNullAndAddIngredientCalled() throws IngredientAlreadyExistsException {
        this.pizza.addIngredient("TEST");
        assertThat(this.pizza.getIngredients(), notNullValue());
    }

    @Test
    void shouldBeAbleToAddSingleIngredientToPizzaObject() throws IngredientAlreadyExistsException {
        this.pizza.addIngredient("TEST");
        assertThat(this.pizza.getIngredients(), hasSize(1));
        assertThat(this.pizza.getIngredients(), contains("TEST"));
    }

    @Test
    void shouldThrowExceptionWhenIngredientAlreadyExistsInPizza() {
        pizza = new Pizza(1, "TEST", 19.0F, ItemCategory.PIZZA, Arrays.asList("TEST", "TEST2"));

        assertThrows(IngredientAlreadyExistsException.class, () -> {
            pizza.addIngredient("TEST");
        });

    }
}