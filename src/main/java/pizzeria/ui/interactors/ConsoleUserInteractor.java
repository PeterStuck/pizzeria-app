package pizzeria.ui.interactors;

import java.util.Scanner;

public class ConsoleUserInteractor implements UserInteractor{

    private Scanner scan;

    public ConsoleUserInteractor() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public String askForPizza() {
        System.out.println("Czy chciałbyś/-abyś zamówić pizzę? (Tak/Nie): ");
        return scan.nextLine().toLowerCase();
    }

    @Override
    public int askWhatPizza() {
        System.out.println("Jaką pizzę sobie życzysz? (Wpisz numer z menu: )");
        return Integer.parseInt(scan.nextLine());
    }

    @Override
    public String askForDrink() {
        System.out.println("Czy chciałbyś/-abyś zamówić napój? (Tak/Nie): ");
        return scan.nextLine().toLowerCase();
    }

    @Override
    public int askWhatDrink() {
        System.out.println("Jaki napój sobie życzysz? (Wpisz numer z menu): ");
        return Integer.parseInt(scan.nextLine());
    }

    @Override
    public int askHowMany() {
        System.out.println("W jakiej ilości?: ");
        return Integer.parseInt(scan.nextLine());
    }

    @Override
    public String askForConfirmation() {
        System.out.println("Czy chciałbyś zakończyć składanie zamówienia i przejść do podsumowania (Tak/Nie): ");
        return scan.nextLine().toLowerCase();
    }

}
