package pizzeria.order_system.menu.repositories.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryMenuRepositoryTest {

    private MenuRepository repository;

    @BeforeEach
    void setUp() {
        this.repository = new InMemoryMenuRepository();
    }

    @Test
    void shouldReturnListOfAllPizzasFromPizzaRepo() {
        assertThat(repository.findAllPizzas(), hasSize(greaterThan(1)));
    }

    @Test
    void shouldReturnPizzaObjectWhenIdExists() throws MenuItemNotFoundException {
        var pizza = repository.findPizzaById(1);

        assertThat(pizza, notNullValue());
        assertThat(pizza.getId(), equalTo(1));
    }

    @Test
    void shouldReturnListOfAllDrinksFromDrinkRepo() {
        assertThat(repository.findAllDrinks(), hasSize(greaterThan(1)));
    }

    @Test
    void shouldReturnDrinkObjectWhenIdExists() throws MenuItemNotFoundException {
        var drink = repository.findDrinkById(1);

        assertThat(drink, notNullValue());
        assertThat(drink.getId(), equalTo(1));
    }
}