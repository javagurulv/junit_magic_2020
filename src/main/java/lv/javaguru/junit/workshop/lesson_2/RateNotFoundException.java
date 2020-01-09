package lv.javaguru.junit.workshop.lesson_2;

public class RateNotFoundException extends RuntimeException {

    private int year;

    public RateNotFoundException(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
