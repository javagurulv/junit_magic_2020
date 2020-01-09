package lv.javaguru.junit.workshop.lesson_1;

import lv.javaguru.junit.workshop.lesson_2.RateNotFoundException;
import lv.javaguru.junit.workshop.lesson_2.TaxCalculationResponse;
import lv.javaguru.junit.workshop.lesson_2.TaxRate;
import lv.javaguru.junit.workshop.lesson_2.TaxRateProvider;

public class TaxCalculatorImpl implements TaxCalculator {

    private TaxRateProvider taxRateProvider;

    public TaxCalculatorImpl(TaxRateProvider taxRateProvider) {
        this.taxRateProvider = taxRateProvider;
    }

    @Override
    public TaxCalculationResponse calculateTax(double income, int year) {
        try {
            TaxRate taxRate = taxRateProvider.getTaxRate(year);
            if (income <= taxRate.getBorder()) {
                return new TaxCalculationResponse(income * taxRate.getLowerRate());
            }
            return new TaxCalculationResponse(taxRate.getBorder() * taxRate.getLowerRate()
                    + (income - taxRate.getBorder()) * taxRate.getUpperRate());
        } catch (RateNotFoundException e) {
            return new TaxCalculationResponse("Year not valid!");
        }
    }

}
