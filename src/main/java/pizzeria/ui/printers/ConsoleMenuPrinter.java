package pizzeria.ui.printers;

import pizzeria.order_system.menu.models.MenuItem;
import pizzeria.order_system.menu.models.Pizza;
import pizzeria.order_system.menu.repositories.menu.InMemoryMenuRepository;
import pizzeria.order_system.menu.repositories.menu.MenuRepository;

import java.util.List;

public class ConsoleMenuPrinter implements MenuPrinter {

    private MenuRepository repo;

    public ConsoleMenuPrinter() {
        repo = new InMemoryMenuRepository();
    }

    @Override
    public void showLogo() {
        System.out.print("  ____                       _____ _                        \n" +
                " |  _ \\                     / ____(_)                       \n" +
                " | |_) |_   _  ___  _ __   | |  __ _  ___  _ __ _ __   ___  \n" +
                " |  _ <| | | |/ _ \\| '_ \\  | | |_ | |/ _ \\| '__| '_ \\ / _ \\ \n" +
                " | |_) | |_| | (_) | | | | | |__| | | (_) | |  | | | | (_) |\n" +
                " |____/ \\__,_|\\___/|_| |_|  \\_____|_|\\___/|_|  |_| |_|\\___/ \n" +
                "                                                            ");
        System.out.println();
    }

    @Override
    public void showPizzas() {
        System.out.println("--+ Pizza +--");
        System.out.println("____________________");
        for (MenuItem pizza : repo.findAllPizzas()){
            List<String> ingredients = ((Pizza) pizza).getIngredients();
            System.out.println(pizza.getId() + ". |" + pizza.getName() + "\t" + pizza.getPrice());
            System.out.print("   |");
            for (String ingr : ingredients){
                System.out.print(ingr + ", ");
            }
            System.out.println("\n____________________");
        }
    }

    @Override
    public void showDrinks() {
        System.out.println("--+ Napoje +--");
        System.out.println("____________________");
        for (MenuItem drink : repo.findAllDrinks()){

            System.out.println(drink.getId() + ". |" + drink.getName() + "\t" + drink.getPrice());
            System.out.println("____________________");
        }
    }


    public static void main(String[] args) {
        var printer = new ConsoleMenuPrinter();
        printer.showLogo();

    }


}
