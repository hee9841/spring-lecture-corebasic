package springbasic.core.scan;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic.core.AutoAppConfig;
import springbasic.core.member.MemberService;

/**
 * packageName    : springbasic.core.scan
 * fileName       : AutoAppConfigTest
 * date           : 2024-01-03
 * description    :
 * ===============================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------
 * 2024-01-03                      최초 생성
 */
public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
