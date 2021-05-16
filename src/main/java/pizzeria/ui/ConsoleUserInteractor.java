package pizzeria.ui;

import java.util.Scanner;

public class ConsoleUserInteractor implements UserInteractor{


    @Override
    public String askForPizza() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Czy chciałbyś/-abyś zamówić pizzę?");
        String userReply = scan.nextLine();
        if (userReply.toLowerCase() == "tak" || userReply.toLowerCase() == "ta" || userReply.toLowerCase() == "t"){
            return "yes";
        }
        else {
            return "no";
        }
    }

    @Override
    public int askWhatPizza() {
        return 0;
    }

    @Override
    public String askForDrink() {
        return null;
    }

    @Override
    public int askWhatDrink() {
        return 0;
    }

    @Override
    public int askHowMany() {
        return 0;
    }

    @Override
    public String askForConfirmation() {
        return null;
    }
}
