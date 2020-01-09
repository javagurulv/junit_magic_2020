package lv.javaguru.junit.workshop.lesson_2;

public class TaxCalculationResponse {

    private boolean isSuccess;
    private Double tax;
    private String errorMessage;

    public TaxCalculationResponse(Double tax) {
        this.isSuccess = true;
        this.tax = tax;
    }

    public TaxCalculationResponse(String errorMessage) {
        this.isSuccess = false;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
