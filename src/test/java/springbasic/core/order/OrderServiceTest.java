package springbasic.core.order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springbasic.core.AppConfig;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;
import springbasic.core.member.MemberService;
import springbasic.core.member.MemberServiceImpl;


class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());

        Order itmeA = orderService.createOrder(findMember.getId(), "itmeA", 10000);
        Assertions.assertEquals(itmeA.getDiscountPrice(), 1000);
    }

}
