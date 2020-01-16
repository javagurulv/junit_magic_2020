package lv.javaguru.junit.workshop.lesson_3.validation;

import lv.javaguru.junit.workshop.lesson_3.User;

public class LengthValidationRule implements ValidationRule {

    @Override
    public boolean isValid(User user, String password) {
        return password.length() >= 5;
    }

    @Override
    public String getErrorMessage() {
        return "Less than 5";
    }
}
