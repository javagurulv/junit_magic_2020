package lv.javaguru.junit.workshop.lesson_1;

import lv.javaguru.junit.workshop.lesson_2.TaxRate;
import lv.javaguru.junit.workshop.lesson_2.TaxRateProvider;

public class TaxCalculatorImpl implements TaxCalculator {

    private TaxRateProvider taxRateProvider;

    public TaxCalculatorImpl(TaxRateProvider taxRateProvider) {
        this.taxRateProvider = taxRateProvider;
    }

    @Override
    public double calculateTax(double income, int year) {
        TaxRate taxRate = taxRateProvider.getTaxRate(year);
        if (income <= taxRate.getBorder()) {
            return income * taxRate.getLowerRate();
        }
        return taxRate.getBorder() * taxRate.getLowerRate()
                + (income - taxRate.getBorder()) * taxRate.getUpperRate();
    }

}
