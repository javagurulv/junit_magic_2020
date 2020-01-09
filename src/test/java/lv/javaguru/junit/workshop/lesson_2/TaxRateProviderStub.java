package lv.javaguru.junit.workshop.lesson_2;

public class TaxRateProviderStub implements TaxRateProvider {

    @Override
    public TaxRate getTaxRate(int year) {
        if (year == 2000) {
            TaxRate taxRate = new TaxRate();
            taxRate.setBorder(20000.0);
            taxRate.setLowerRate(0.25);
            taxRate.setUpperRate(0.4);
            return taxRate;
        }
        return null;
    }

}
