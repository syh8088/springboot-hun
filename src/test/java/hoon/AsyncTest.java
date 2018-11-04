package hoon;

import hoon.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class AsyncTest {

    @Autowired
    LogUtil logUtil;

    @Test
    public void tes1t() {
        log.info("start");
        logUtil.loggingByAsync();
        log.info("end");
    }
}