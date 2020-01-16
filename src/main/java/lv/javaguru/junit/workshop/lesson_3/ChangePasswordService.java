package lv.javaguru.junit.workshop.lesson_3;

public interface ChangePasswordService {

    ChangePasswordResponse changePassword(User user, String newPassword);

}
