package lv.javaguru.junit.workshop.lesson_3.validation;

import lv.javaguru.junit.workshop.lesson_3.User;

public interface ValidationRule {

    boolean isValid(User user, String password);

    String getErrorMessage();

}
