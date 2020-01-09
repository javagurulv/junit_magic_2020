package lv.javaguru.junit.workshop.lesson_1;

import lv.javaguru.junit.workshop.lesson_2.TaxRateProvider;
import lv.javaguru.junit.workshop.lesson_2.TaxRateProviderStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorImplTest {

    private TaxCalculator calculator;

    @Before
    public void setup() {
        TaxRateProvider taxRateProvider = new TaxRateProviderStub();
        calculator = new TaxCalculatorImpl(taxRateProvider);
    }

    @Test
    public void income20000() {
        checkResult(20000.0, 2000, 5000.0);
    }

    @Test
    public void income0() {
        checkResult(0.0, 2000, 0.0);
    }

    private void checkResult(double income,
                             int year,
                             double expectedTax) {
        double realTax = calculator.calculateTax(income, year);
        assertEquals(expectedTax, realTax, 0.000001);
    }

}