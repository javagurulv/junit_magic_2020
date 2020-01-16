package lv.javaguru.junit.workshop.lesson_3.validation;

import lv.javaguru.junit.workshop.lesson_3.User;

public class ContainsLettersValidationRule implements ValidationRule {
    @Override
    public boolean isValid(User user, String password) {
        return password.matches(".*[A-Za-z].*");
    }

    @Override
    public String getErrorMessage() {
        return "Not contain letters";
    }
}
