package springbasic.core.discount;


import org.springframework.stereotype.Component;
import springbasic.core.annotaion.MainDiscountPolicy;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;

@Component
//@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
