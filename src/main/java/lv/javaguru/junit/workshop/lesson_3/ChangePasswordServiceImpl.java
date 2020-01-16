package lv.javaguru.junit.workshop.lesson_3;

import java.util.List;

public class ChangePasswordServiceImpl implements ChangePasswordService {

    private UserPasswordRepository userPasswordRepository;

    public ChangePasswordServiceImpl(UserPasswordRepository userPasswordRepository) {
        this.userPasswordRepository = userPasswordRepository;
    }

    @Override
    public ChangePasswordResponse changePassword(User user,
                                                 String newPassword) {
        if (newPassword.length() < 5) {
           return new ChangePasswordResponse(false, "Less than 5");
        }
        if (!containsLetters(newPassword)) {
            return new ChangePasswordResponse(false, "Not contain letters");
        }
        if (!containsNumbers(newPassword)) {
            return new ChangePasswordResponse(false, "Not contain numbers");
        }

        List<String> oldPasswords = userPasswordRepository.getLastThreePasswords(user);
        if (oldPasswords.contains(newPassword)) {
            return new ChangePasswordResponse(false, "Old password not allowed");
        }

        return new ChangePasswordResponse(true,null);
    }

    private boolean containsLetters(String password) {
        return password.matches(".*[A-Za-z].*");
    }

    private boolean containsNumbers(String password) {
        return password.matches(".*[0-9].*");
    }

}
