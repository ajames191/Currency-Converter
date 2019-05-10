package Services;

import Models.Currency;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectionService {
    private ArrayList<Currency> availableCurrencies = new ArrayList<>();

    public SelectionService() {
        availableCurrencies.add(Currency.USD);
        availableCurrencies.add(Currency.GBP);
        availableCurrencies.add(Currency.EUR);
        availableCurrencies.add(Currency.AUD);
    }

    public Currency selectCurrency(int iterator) {
        promptUserInput(iterator);
        displayCurrencies();
        Currency chosenCurrency = makeSelection(iterator);
        return chosenCurrency;
    }

    private void promptUserInput(int iterator) {
        if (iterator == 0) {
            System.out.println("Select starting currency:");
        }
        else {
            System.out.println("Select desired currency:");
        }
    }

    private void displayCurrencies() {
        int iterator = 1;
        for (Currency currency : availableCurrencies) {
            System.out.println(iterator + ". " + currency);
            iterator++;
        }
    }

    private Currency makeSelection(int iterator) {
        Scanner userInput = new Scanner(System.in);
        Currency chosenCurrency = Currency.USD;
        boolean validUserChoice = false;
        int choice = 0;

        while (!validUserChoice) {
            System.out.print("Selection: ");
            choice = userInput.nextInt();

            if (checkUserInputIsValid(choice, iterator)) {
                validUserChoice = true;
            }
        }

        switch (choice) {
            case 1:
                chosenCurrency = Currency.USD;
                break;
            case 2:
                chosenCurrency = Currency.GBP;
                break;
            case 3:
                chosenCurrency = Currency.EUR;
                break;
            case 4:
                chosenCurrency = Currency.AUD;
                break;
        }

        System.out.println(chosenCurrency);
        return chosenCurrency;
    }

    private boolean checkUserInputIsValid(int choice, int iterator) {
        if (choice > 0 && choice < 5) {
            return true;
        }
        System.out.println("Invalid choice, please select options 1 - 4.");
        promptUserInput(iterator);
        return false;
    }
}
