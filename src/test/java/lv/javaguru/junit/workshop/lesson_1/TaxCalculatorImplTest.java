package lv.javaguru.junit.workshop.lesson_1;

import lv.javaguru.junit.workshop.lesson_2.RateNotFoundException;
import lv.javaguru.junit.workshop.lesson_2.TaxRate;
import lv.javaguru.junit.workshop.lesson_2.TaxRateProvider;
import lv.javaguru.junit.workshop.lesson_2.TaxRateProviderStub;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaxCalculatorImplTest {

    @Mock
    private TaxRateProvider taxRateProvider;

    @InjectMocks
    private TaxCalculator calculator = new TaxCalculatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /*@Before
    public void setup() {
        taxRateProvider = Mockito.mock(TaxRateProvider.class);
        calculator = new TaxCalculatorImpl(taxRateProvider);
    }*/

    @Test
    public void shouldThrowException() {
        thrown.expect(RateNotFoundException.class);

        Mockito.when(taxRateProvider.getTaxRate(2000))
                .thenThrow(new RateNotFoundException(2000));

        calculator.calculateTax(0, 2000);
    }

    @Test
    public void income20000() {
        TaxRate taxRate = new TaxRate();
        taxRate.setBorder(20000.0);
        taxRate.setLowerRate(0.25);
        taxRate.setUpperRate(0.4);

        Mockito.when(taxRateProvider.getTaxRate(2000))
                .thenReturn(taxRate);

        checkResult(20000.0, 2000, 5000.0);

        Mockito.verify(taxRateProvider).getTaxRate(2000);
    }

    @Test
    public void income0() {
        checkResult(0.0, 2000, 0.0);
    }

    @Test(expected = RuntimeException.class)
    public void throwException() {
        Mockito.when(taxRateProvider.getTaxRate(2000))
                .thenThrow(new RuntimeException());

        calculator.calculateTax(200000, 2000);
    }

    private void checkResult(double income,
                             int year,
                             double expectedTax) {
        //double realTax = calculator.calculateTax(income, year);
        //assertEquals(expectedTax, realTax, 0.000001);
    }

}