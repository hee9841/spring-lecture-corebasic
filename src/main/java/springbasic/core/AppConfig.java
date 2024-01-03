package springbasic.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbasic.core.discount.DiscountPolicy;
import springbasic.core.discount.RateDiscountPolicy;
import springbasic.core.member.MemberRepository;
import springbasic.core.member.MemberService;
import springbasic.core.member.MemberServiceImpl;
import springbasic.core.member.MemoryMemberRepository;
import springbasic.core.order.OrderService;
import springbasic.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    //todo
    // static 으로 메서드 선언하면 싱글톤으로 생성ㅎ 안됨???
}
