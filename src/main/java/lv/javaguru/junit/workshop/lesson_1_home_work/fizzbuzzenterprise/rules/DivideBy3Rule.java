package lv.javaguru.junit.workshop.lesson_1_home_work.fizzbuzzenterprise.rules;

import lv.javaguru.junit.workshop.lesson_1_home_work.fizzbuzzenterprise.FizzBuzzRule;

public class DivideBy3Rule implements FizzBuzzRule {

    @Override
    public boolean isSatisfied(int number) {
        return number % 3 == 0;
    }

    @Override
    public String produceResult(int number) {
        return "Fizz";
    }
}
