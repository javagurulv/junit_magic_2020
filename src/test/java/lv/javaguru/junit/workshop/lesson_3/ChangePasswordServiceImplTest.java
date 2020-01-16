package lv.javaguru.junit.workshop.lesson_3;

import com.google.common.collect.Lists;
import lv.javaguru.junit.workshop.lesson_3.validation.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChangePasswordServiceImplTest {

    private UserPasswordRepository userPasswordRepository;
    private ChangePasswordService service;

    @Before
    public void setup() {
        userPasswordRepository = Mockito.mock(UserPasswordRepository.class);

        List<ValidationRule> validationRules = new ArrayList<>();
        validationRules.add(new LengthValidationRule());
        validationRules.add(new ContainsLettersValidationRule());
        validationRules.add(new ContainsNumbersValidationRule());
        validationRules.add(new OldPasswordValidationRule(userPasswordRepository));

        service = new ChangePasswordServiceImpl(validationRules);
    }

    @Test
    public void shouldFailWhenPasswordIsLessThan5Symbols() {
        ChangePasswordResponse response = service.changePassword(null, "1");
        assertEquals(response.isSuccess(), false);
        assertEquals(response.getErrorMessage(), "Less than 5");
    }

    @Test
    public void shouldFailWhenPasswordNotContainLetters() {
        ChangePasswordResponse response = service.changePassword(null, "123456");
        assertEquals(response.isSuccess(), false);
        assertEquals(response.getErrorMessage(), "Not contain letters");
    }

    @Test
    public void shouldFailWhenPasswordNotContainNumbers() {
        ChangePasswordResponse response = service.changePassword(null, "asdfddd");
        assertEquals(response.isSuccess(), false);
        assertEquals(response.getErrorMessage(), "Not contain numbers");
    }

    @Test
    public void shouldFailWhenNewPasswordIsEqualOldPassword() {
        //List<String> oldPasswords = new ArrayList<>();
        //oldPasswords.add("oldPassword123");

        User user = new User("login");

        List<String> oldPasswords = Lists.newArrayList("oldPassword123");
        Mockito.when(userPasswordRepository.getLastThreePasswords(user))
                .thenReturn(oldPasswords);

        ChangePasswordResponse response = service.changePassword(user, "oldPassword123");
        assertEquals(response.isSuccess(), false);
        assertEquals(response.getErrorMessage(), "Old password not allowed");
    }

    @Test
    public void shouldSucceed() {
        User user = new User("login");

        List<String> oldPasswords = Lists.newArrayList("oldPassword123");
        Mockito.when(userPasswordRepository.getLastThreePasswords(user))
                .thenReturn(oldPasswords);

        ChangePasswordResponse response = service.changePassword(user, "ass123456ass");
        assertEquals(response.isSuccess(), true);
    }

}