package springbasic.core.discount;

import springbasic.core.member.Grade;
import springbasic.core.member.Member;

/**
 * packageName    : springbasic.core.discount fileName       : FixDiscountPolicy author         : asdfz date           :
 * 2023-12-28 description    : =============================================== DATE              AUTHOR             NOTE
 * ----------------------------------------------- 2023-12-28        asdfz       최초 생성
 */
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
