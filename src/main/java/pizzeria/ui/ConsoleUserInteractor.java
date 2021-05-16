package pizzeria.ui;

import java.util.Scanner;

public class ConsoleUserInteractor implements UserInteractor{

    private Scanner scan;

    public ConsoleUserInteractor() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public String askForPizza() {
        System.out.println("Czy chciałbyś/-abyś zamówić pizzę? ([T]ak/[N]ie): ");
        return scan.nextLine().toLowerCase();
    }

    @Override
    public int askWhatPizza() {
        System.out.println("Jaką pizzę sobie życzysz? (Wpisz numer z menu: )");
        return scan.nextInt();
    }

    @Override
    public String askForDrink() {
        System.out.println("Czy chciałbyś/-abyś zamówić napój? ([T]ak/[N]ie): ");
        return scan.nextLine().toLowerCase();
    }

    @Override
    public int askWhatDrink() {
        System.out.println("Jaki napój sobie życzysz? (Wpisz numer z menu: )");
        return scan.nextInt();
    }

    @Override
    public int askHowMany() {
        System.out.println("W jakiej ilości?: )");
        return scan.nextInt();
    }

    @Override
    public String askForConfirmation() {
        System.out.println("Czy chciałbyś zakończyć składanie zamówienia i przejść do podsumowania: ");
        return scan.nextLine().toLowerCase();
    }
}
