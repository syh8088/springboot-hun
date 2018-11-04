package hoon.etc.threadSafe;

import lombok.extern.log4j.Log4j;

@Log4j
public class SafeCalculator {

    private final static SafeCalculator calculator = new SafeCalculator();

    private SafeCalculator() {
    }

    public static SafeCalculator getInstance() {
        return calculator;
    }

    public int add(int num) {
        log.info(num);
        return ++num;
    }
}
