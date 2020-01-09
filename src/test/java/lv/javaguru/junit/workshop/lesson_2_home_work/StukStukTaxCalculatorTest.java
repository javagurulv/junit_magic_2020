package lv.javaguru.junit.workshop.lesson_2_home_work;

import lv.javaguru.junit.workshop.lesson_1.TaxCalculatorImpl;
import lv.javaguru.junit.workshop.lesson_2.TaxCalculationResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class StukStukTaxCalculatorTest {

    private EmailSender emailSender;
    private StukStukTaxCalculator calculator;

    @Before
    public void setup() {
        emailSender = Mockito.mock(EmailSender.class);
        calculator = new StukStukTaxCalculator(emailSender);
    }

    @Test
    public void test() {
        TaxCalculationResponse response = calculator.calculateTax(10, 2000);
        assertEquals(response.getTax(), 2.5, 0.0001);
    }

    @Test
    public void test2() throws EmailNotSendException {
        TaxCalculationResponse response = calculator.calculateTax(30000, 2000);
        assertEquals(response.getTax(), 7500.0, 0.0001);
        Mockito.verify(emailSender).sendEmail(30000.0);
    }

    @Test
    public void test3() throws EmailNotSendException {
        Mockito.doThrow(new EmailNotSendException())
                .when(emailSender).sendEmail(30000);

        TaxCalculationResponse response = calculator.calculateTax(30000, 2000);
        assertEquals(response.getTax(), 7500.0, 0.0001);
        Mockito.verify(emailSender).sendEmail(30000);
    }


}