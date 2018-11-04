package hoon;

import hoon.sevice.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

//NOTE #5-1 @RunWith @SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class BeanIdentityTest {

    @Autowired
    ApplicationContext applicationContext;

    private MemberService memberService;
    private MemberService memberService1;

    @Before
    public void initBean() {
        memberService = applicationContext.getBean(MemberService.class);
        memberService1 = applicationContext.getBean(MemberService.class);
    }

    @Test
    public void te1st() {
        log.info("memberService : {}", String.valueOf(memberService));
        log.info("memberService1 : {}", String.valueOf(memberService1));

        //NOTE #5-2 Bean은 기본적으로 싱글톤으로 동작하며 동일성을 보장한다.
        assertEquals(memberService, memberService1);
    }
}