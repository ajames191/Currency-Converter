package com.company.Services;

import com.company.Models.Currency;

import java.util.Scanner;

public class CurrencyConverter {
    private Currency firstCurrency;
    private Currency secondCurrency;

    public void startConverter() {
        boolean runApplication = true;

        while (runApplication) {
            getCurrenciesToConvert();

            // convertChosenCurrencies();
            // displayConvertedValue();
        }

        System.out.println("Thanks for using ajames191 currency converter!");
    }

    private void getCurrenciesToConvert() {
        for (int i = 0; i < 2; i++) {
            boolean validUserChoice = false;
            int userChoice = 0;
            Currency chosenCurrency;

            while (!validUserChoice) {
                System.out.println("Select the currency you are converting from:");
                listAvailableCurrencies();

                Scanner scan = new Scanner(System.in);
                userChoice = scan.nextInt();

                if (checkUserInputIsValid(userChoice)) {
                    validUserChoice = true;
                }
            }

            chosenCurrency = selectCurrency(userChoice);
            assignCurrency(i, chosenCurrency);
        }
    }

    private void listAvailableCurrencies() {
        System.out.println("Available Currencies:");
        System.out.println("1. USD - US Dollar");
        System.out.println("2. EUR - Euro");
        System.out.println("3. GBP - British Pound");
        System.out.println("4. AUD - Australian Dollar");
    }

    private boolean checkUserInputIsValid(int userInput) {
        if (userInput > 0 && userInput < 5) {
            return true;
        }
        System.out.println("Invalid choice, select options 1 - 4");
        return false;
    }

    private Currency selectCurrency(int userChoice) {
        Currency selectedCurrency = Currency.USD;

        switch (userChoice) {
            case 1:
                selectedCurrency = Currency.USD;
                break;
            case 2:
                selectedCurrency = Currency.EUR;
                break;
            case 3:
                selectedCurrency = Currency.GBP;
                break;
            case 4:
                selectedCurrency = Currency.AUD;
                break;
        }
        System.out.println("Selected currency: " + selectedCurrency);
        return selectedCurrency;
    }

    private void assignCurrency(int iteration, Currency chosenCurrency) {
        if (iteration == 0) {
            firstCurrency = chosenCurrency;
        } else {
            secondCurrency = chosenCurrency;
        }
    }
}
