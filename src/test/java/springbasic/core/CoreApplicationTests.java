package springbasic.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

    //spring이 자동으로 컨테이너 뜨어서 함
    // 스프링 빈이 컨포넌트 스캔으로 등록이 되어있는데
    //AutoAppConfig에서 memoryMemberRepository로 수동으로 등록되엉 있어서 충돌남


    @Test
    void contextLoads() {

    }

}
