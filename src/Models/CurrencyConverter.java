package Models;

import Services.ConversionService;
import Services.SelectionService;

import java.util.ArrayList;

public class CurrencyConverter {
    private ArrayList<Currency> currencies = new ArrayList<Currency>();
    private double exchangeRate;
    private SelectionService selector  = new SelectionService();
    private ConversionService converter = new ConversionService();

    public CurrencyConverter() {

    }

    public void setCurrencies() {
        Currency selectedCurrency;
        for (int iterator = 0; iterator < 2; iterator++) {
            selectedCurrency = selector.selectCurrency(iterator);
            this.currencies.add(selectedCurrency);
        }
    }
}
