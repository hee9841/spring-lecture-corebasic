package springbasic.core.discount;

import org.springframework.stereotype.Component;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;


@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
