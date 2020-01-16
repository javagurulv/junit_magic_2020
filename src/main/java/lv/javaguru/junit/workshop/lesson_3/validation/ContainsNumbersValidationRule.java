package lv.javaguru.junit.workshop.lesson_3.validation;

import lv.javaguru.junit.workshop.lesson_3.User;

public class ContainsNumbersValidationRule implements ValidationRule {
    @Override
    public boolean isValid(User user, String password) {
        return password.matches(".*[0-9].*");
    }

    @Override
    public String getErrorMessage() {
        return "Not contain numbers";
    }
}
