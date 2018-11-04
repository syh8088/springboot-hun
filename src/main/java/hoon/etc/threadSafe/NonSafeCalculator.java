package hoon.etc.threadSafe;

import lombok.extern.log4j.Log4j;

@Log4j
public class NonSafeCalculator {

    private int num;

    private final static NonSafeCalculator calculator = new NonSafeCalculator();

    private NonSafeCalculator() {
    }

    public static NonSafeCalculator getInstance() {
        return calculator;
    }

    public int add() {
        log.info(num);
        return ++num;
    }
}
