package springbasic.core.member;

/**
 * packageName    : springbasic.core.member fileName       : MemberServiceImpl author         : asdfz date           :
 * 2023-12-28 description    : =============================================== DATE              AUTHOR             NOTE
 * ----------------------------------------------- 2023-12-28        asdfz       최초 생성
 */
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
