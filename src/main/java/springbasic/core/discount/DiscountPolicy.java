package springbasic.core.discount;

import springbasic.core.member.Member;


public interface DiscountPolicy {

    int discount(Member member, int price);
}
