package pizzeria.ui;

import pizzeria.ui.printers.ConsoleMenuPrinter;
import pizzeria.ui.printers.MenuPrinter;

public class MenuService {
    private MenuPrinter printer;
    private UserInteractor userInteractor;

    public MenuService(){
        this.printer = new ConsoleMenuPrinter();
        this.userInteractor = new ConsoleUserInteractor();
        this.showStartScreen();
    }
    public void setPrinter(MenuPrinter printer){
        this.printer = printer;
    }
    public void setUserInteractor(UserInteractor userInteractor){
        this.userInteractor = userInteractor;
    }
    private void showStartScreen(){
        printer.showLogo();
        printer.greetMessage();
    }
    private boolean menuItemConfimed(String userReply){
        return userReply.equals("tak") || userReply.equals("ta") || userReply.equals("t");
    }
    public int pizzaItemNumber(){
        String pizzaChosen = this.userInteractor.askForPizza();
        int pizzaChosenNumber = 0;
        if (this.menuItemConfimed(pizzaChosen)){
            printer.showPizzas();
            pizzaChosenNumber = this.userInteractor.askWhatPizza();
        }
        return pizzaChosenNumber;
    }
    public int drinkItemNumber(){
        String drinkChosen = this.userInteractor.askForDrink();
        int drinkChosenNumber = 0;
        if (this.menuItemConfimed(drinkChosen)){
            printer.showDrinks();
            drinkChosenNumber = this.userInteractor.askWhatDrink();
        }
        return drinkChosenNumber;
    }

}
