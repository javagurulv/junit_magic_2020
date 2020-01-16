package lv.javaguru.junit.workshop.lesson_3;

public class ChangePasswordResponse {

    private boolean success;
    private String errorMessage;

    public ChangePasswordResponse(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
