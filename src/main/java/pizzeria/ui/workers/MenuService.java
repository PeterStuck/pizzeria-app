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

    private void showStartScreen() {
        printer.showLogo();
        printer.greetMessage();
    }

    public boolean askForPizza() {
        return this.userReplyConfimed(this.userInteractor.askForPizza());
    }

    public int pizzaItemNumber() {
        printer.showPizzas();

        return this.userInteractor.askWhatPizza();
    }

    public boolean askForDrink() {
        return this.userReplyConfimed(this.userInteractor.askForDrink());
    }

    public int drinkItemNumber() {
        printer.showDrinks();

        return this.userInteractor.askWhatDrink();
    }

    public int howManyItems() {
        return this.userInteractor.askHowMany();
    }

    public boolean askForOtherItems() {
        return this.userReplyConfimed(userInteractor.askForAnotherItems());
    }

    public boolean confirmOrder() {
        return userReplyConfimed(userInteractor.askForConfirmation());
    }

    private boolean userReplyConfimed(String userReply) {
        return userReply.equals("tak") || userReply.equals("ta") || userReply.equals("t");
    }

    public void setPrinter(MenuPrinter printer){
        this.printer = printer;
    }

    public void setUserInteractor(UserInteractor userInteractor){
        this.userInteractor = userInteractor;
    }

}
