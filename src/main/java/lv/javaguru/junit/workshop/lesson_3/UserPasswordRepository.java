package lv.javaguru.junit.workshop.lesson_3;

import java.util.List;

public interface UserPasswordRepository {

    List<String> getLastThreePasswords(User user);

}
