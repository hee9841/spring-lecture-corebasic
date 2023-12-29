package springbasic.core.discount;

import springbasic.core.member.Member;

/**
 * packageName    : springbasic.core.discount fileName       : DiscountPolicy author         : asdfz date           :
 * 2023-12-28 description    : =============================================== DATE              AUTHOR             NOTE
 * ----------------------------------------------- 2023-12-28        asdfz       최초 생성
 */
public interface DiscountPolicy {

    int discount(Member member, int price);
}
