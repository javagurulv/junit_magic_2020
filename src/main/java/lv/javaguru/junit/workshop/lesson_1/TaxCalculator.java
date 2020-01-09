package lv.javaguru.junit.workshop.lesson_1;

import lv.javaguru.junit.workshop.lesson_2.TaxCalculationResponse;

public interface TaxCalculator {

    TaxCalculationResponse calculateTax(double income, int year);

}
