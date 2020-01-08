package lv.javaguru.junit.workshop.lesson_1_home_work.fizzbuzzenterprise;

import java.util.Arrays;

public class FizzBuzzEnterprise {

    private FizzBuzzRule[] rules;

    public FizzBuzzEnterprise(FizzBuzzRule ... rules) {
        this.rules = rules;
    }

    public String getResult(int number) {
        return Arrays.stream(rules)
                .filter(r -> r.isSatisfied(number))
                .findFirst()
                .get().produceResult(number);
    }

}
