package springbasic.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void vip_0() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }


    @Test
    void grade_x() {
        Member member = new Member(1L, "memberA", Grade.BASIC);
        int discount = discountPolicy.discount(member, 20000);

        assertThat(discount).isEqualTo(0);
    }
}
