package lv.javaguru.junit.workshop.lesson_2_home_work;

import lv.javaguru.junit.workshop.lesson_1.TaxCalculator;
import lv.javaguru.junit.workshop.lesson_2.TaxCalculationResponse;

public class StukStukTaxCalculator implements TaxCalculator {

    private EmailSender emailSender;

    public StukStukTaxCalculator(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public TaxCalculationResponse calculateTax(double income, int year) {
        if (income > 20000) {
            try {
                emailSender.sendEmail(income);
            } catch (EmailNotSendException e) {
                // print to log file
            }
        }
        return new TaxCalculationResponse(0.25 * income);
    }


}
