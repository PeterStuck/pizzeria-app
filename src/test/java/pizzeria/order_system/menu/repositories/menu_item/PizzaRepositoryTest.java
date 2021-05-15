package pizzeria.order_system.menu.repositories.menu_item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pizzeria.order_system.menu.exceptions.MenuItemNotFoundException;
import pizzeria.order_system.menu.repositories.menu_item.MenuItemRepository;
import pizzeria.order_system.menu.repositories.menu_item.PizzaRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class PizzaRepositoryTest {

    private MenuItemRepository repository;

    @BeforeEach
    void setUp() {
        repository = new PizzaRepository();
    }

    @Test
    void shouldReturnListOfAvailableDrinks() {
        assertThat(repository.findAll(), hasSize(greaterThan(1)));
    }

    @Test
    void shouldFindDrinkWhenDrinkWithPassedIdExists() throws MenuItemNotFoundException {
        assertThat(repository.findById(1), notNullValue());
    }

    @Test
    void shouldThrowExceptionWhenDrinkWithPassedIdNotExists() {
        assertThrows(MenuItemNotFoundException.class, () -> {
            repository.findById(999);
        });
    }
}