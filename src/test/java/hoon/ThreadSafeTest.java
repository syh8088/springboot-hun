package hoon;

import hoon.etc.threadSafe.NonSafeCalculator;
import hoon.etc.threadSafe.SafeCalculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ThreadSafeTest {

    private NonSafeCalculator nonSafeCalculator;
    private SafeCalculator safeCalculator;

    private final static List<Integer> INTEGER_LIST = IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toList());
    // == Array.asList(1,2,3,4,5,6,7)

    @Before
    public void init() {
        nonSafeCalculator = NonSafeCalculator.getInstance();
        safeCalculator = SafeCalculator.getInstance();
    }

    //NOTE #5-3 각 test를 실행 후 로그를 살펴보세요!
    @Test
    public void safe() {
        INTEGER_LIST.forEach((integer) -> new Thread(() -> safeCalculator.add(integer)).start());
//        INTEGER_LIST.stream().map(item -> item).filter(item1 -> item1 > 1).collect(Collectors.toList());
    }

    @Test
    public void noneSafe() {
        INTEGER_LIST.forEach((integer) -> new Thread(() -> nonSafeCalculator.add()).start());
//        for (int i=0; i< INTEGER_LIST.size(); i++) {
//            Thread thread = new Thread() {
//                @Override
//                public void run() {
//                    nonSafeCalculator.add();
//                }
//            };
//            thread.start();
//        }
    }
}
