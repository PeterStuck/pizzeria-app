package pizzeria.ui.workers;

import pizzeria.ui.interactors.ConsoleUserInteractor;
import pizzeria.ui.interactors.UserInteractor;
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
    private boolean userReplyConfimed(String userReply){
        return userReply.equals("tak") || userReply.equals("ta") || userReply.equals("t");
    }
    public boolean askForPizza(){
        String pizzaChosen = this.userInteractor.askForPizza();
        return this.userReplyConfimed(pizzaChosen);
    }
    public int pizzaItemNumber(){
        int pizzaChosenNumber = 0;
        printer.showPizzas();
        pizzaChosenNumber = this.userInteractor.askWhatPizza();

        return pizzaChosenNumber;
    }
    public boolean askForDrink(){
        String drinkChosen = this.userInteractor.askForDrink();
        return this.userReplyConfimed(drinkChosen);
    }
    public int drinkItemNumber(){
        int drinkChosenNumber = 0;
        printer.showDrinks();
        drinkChosenNumber = this.userInteractor.askWhatDrink();

        return drinkChosenNumber;
    }
    public int howManyItems(){
        return this.userInteractor.askHowMany();
    }
    public boolean confirmOrder() {
        return userReplyConfimed(userInteractor.askForConfirmation());
    }
}
