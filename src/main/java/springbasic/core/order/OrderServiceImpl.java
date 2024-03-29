package springbasic.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbasic.core.annotaion.MainDiscountPolicy;
import springbasic.core.discount.DiscountPolicy;
import springbasic.core.member.Member;
import springbasic.core.member.MemberRepository;


@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //변경 코드  OCP 위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    //@RequiredArgsConstructor 는 final이 붙은 걸 필수 값으로
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
        @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
