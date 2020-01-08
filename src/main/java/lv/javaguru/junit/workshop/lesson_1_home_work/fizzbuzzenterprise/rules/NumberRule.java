package lv.javaguru.junit.workshop.lesson_1_home_work.fizzbuzzenterprise.rules;

import lv.javaguru.junit.workshop.lesson_1_home_work.fizzbuzzenterprise.FizzBuzzRule;

public class NumberRule implements FizzBuzzRule {

    @Override
    public boolean isSatisfied(int number) {
        return true;
    }

    @Override
    public String produceResult(int number) {
        return "" + number;
    }
}
