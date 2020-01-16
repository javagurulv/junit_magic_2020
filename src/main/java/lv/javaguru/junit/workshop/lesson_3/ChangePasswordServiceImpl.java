package lv.javaguru.junit.workshop.lesson_3;

import lv.javaguru.junit.workshop.lesson_3.validation.ValidationRule;

import java.util.List;
import java.util.Optional;

public class ChangePasswordServiceImpl implements ChangePasswordService {

    private List<ValidationRule> validationRules;

    public ChangePasswordServiceImpl(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    @Override
    public ChangePasswordResponse changePassword(User user,
                                                 String newPassword) {
        return validationRules.stream()
            .filter(validationRule -> !validationRule.isValid(user, newPassword))
                .findFirst()
                .map(ValidationRule::getErrorMessage)
                .map(errorMessage -> new ChangePasswordResponse(false, errorMessage))
                .orElseGet(() -> new ChangePasswordResponse(true, null));
    }

}
