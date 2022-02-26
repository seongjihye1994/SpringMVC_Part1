package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 는 리턴할 때 문자를 반환하면 문자 그대로 String 이 반환된다.
// http 응답 메세지 바디에 문자를 바로 넣어버림.
@RestController
@Slf4j // 롬복 사용
public class LogTestController {

    // private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        // 아래처럼 + 로 로그를 쓰면 안된다.
        // + 는 말 그대로 연산이다.
        // 만약 properties 에 로그 레벨이 debug로 찍혀있는데,
        // 정작 trace를 사용해서 이 클래스에서 로그를 찍고 있다.
        // 이 클래스는 trace로 연산을 한 후 trace 로그를 찍으려고 하지만,
        // properties 에 로그 레벨은 debug로 찍혀있으니, trace는 연산만 다 해놓고
        // 실제로 찍히지는 않는 것이다.
        // 이렇게 되면 메모리 낭비가 심하다.
        log.trace(" trace my log=" + name);

        log.trace(" trace log={}", name);
        log.debug(" debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error(" error log={}", name);

        return "ok";
    }
}
