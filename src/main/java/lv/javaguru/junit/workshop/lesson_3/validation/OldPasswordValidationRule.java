package lv.javaguru.junit.workshop.lesson_3.validation;

import lv.javaguru.junit.workshop.lesson_3.ChangePasswordResponse;
import lv.javaguru.junit.workshop.lesson_3.User;
import lv.javaguru.junit.workshop.lesson_3.UserPasswordRepository;

import java.util.List;

public class OldPasswordValidationRule implements ValidationRule {

    private UserPasswordRepository userPasswordRepository;

    public OldPasswordValidationRule(UserPasswordRepository userPasswordRepository) {
        this.userPasswordRepository = userPasswordRepository;
    }

    @Override
    public boolean isValid(User user, String password) {
        List<String> oldPasswords = userPasswordRepository.getLastThreePasswords(user);
        return !oldPasswords.contains(password);
    }

    @Override
    public String getErrorMessage() {
        return "Old password not allowed";
    }
}
