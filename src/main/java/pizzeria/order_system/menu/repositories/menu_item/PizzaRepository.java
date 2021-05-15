package pizzeria.order_system.menu.repositories.menu_item;

import pizzeria.order_system.menu.models.ItemCategory;
import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;

import java.util.Arrays;
import java.util.List;

public class PizzaRepository extends MenuItemRepository {

    private List<MenuItem> allPizzas = Arrays.asList(
            new Pizza(1, "Margherita", 14.99F, ItemCategory.PIZZA, Arrays.asList("ser","sos pomidorowy")),
            new Pizza(2, "Peperoni", 14.99F, ItemCategory.PIZZA, Arrays.asList("ser","sos pomidorowy", "salami")),
            new Pizza(3, "Capriciosa", 15.99F, ItemCategory.PIZZA, Arrays.asList("ser","sos pomidorowy","szynka","pieczarki")),
            new Pizza(4, "Pescatore", 16.99F, ItemCategory.PIZZA, Arrays.asList("ser","sos pomidorowy","tuńczyk")),
            new Pizza(5, "Paco", 17.99F, ItemCategory.PIZZA, Arrays.asList("ser","sos pomidorowy","salami","boczek","cebula")),
            new Pizza(6, "Diaboli", 20.99F, ItemCategory.PIZZA, Arrays.asList("ser","sos pomidorowy","salami","boczek","cebula","kabanos","tabasco","cebula")),
            new Pizza(7, "Camaro", 19.99F, ItemCategory.PIZZA, Arrays.asList("ser", "kurczak", "kukurydza", "cebula", "majonez", "sos słodko-pikantny", "sos pomidorowy")),
            new Pizza(8, "Hawajska", 12.99F, ItemCategory.PIZZA, Arrays.asList("ser","sos pomidorowy","ananas","szynka"))
    );

    public PizzaRepository() {
        this.menuItems = allPizzas;
    }
}
