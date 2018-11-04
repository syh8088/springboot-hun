package hoon;

import hoon.dao.group.MemberGroupRepository;
import hoon.sevice.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class AopProxyTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    MemberService memberService;

    @Autowired
    MemberGroupRepository memberGroupRepository;

    @Test
    public void tes1t() {
        log.info("applicationContext class : " + applicationContext.getClass());
        log.info("memberService class : " + memberService.getClass().toString());
        log.info("memberGroupRepository class : " + memberGroupRepository.getClass().toString());
    }
}