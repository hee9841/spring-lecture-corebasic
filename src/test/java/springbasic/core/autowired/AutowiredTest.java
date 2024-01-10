package springbasic.core.autowired;

import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic.core.member.Member;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(
            TestBean.class);


    }

    static class TestBean {

        @Autowired(required = false)// required = false 가 없으면 UnsatisfiedDependencyException 터짐 
        //Member가 spring Bean으로 등록되는 게 아니라서
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        //1번 자체가 아애 호출이 안됨
        //Autowired required false면 -> if 의존 관계가 없으면 -> 해당 메서드 자체가 호출이 안됨

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
            //noBean2 = null
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
            //noBean3 = Optional.empty
        }

    }

}
