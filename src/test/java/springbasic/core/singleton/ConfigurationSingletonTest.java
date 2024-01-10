package springbasic.core.singleton;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic.core.AppConfig;
import springbasic.core.member.MemberRepository;
import springbasic.core.member.MemberServiceImpl;
import springbasic.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println(
            "memberService -> memberRepository = " + memberService.getMemberRepository());
        System.out.println(
            "orderService -> memberRepository = " + orderService.getMemberRepository());
        System.out.println("memberRepository -> memberRepository = " + memberRepository);
        //세번의 new가 호출되는게 맞는데 같은 인서튼스임
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);


    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean.getClass() = " + bean.getClass());
        //뒤에 $$SpringCGLIB$$0 문가 붙임
    }
}
