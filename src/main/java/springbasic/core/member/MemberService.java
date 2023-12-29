package springbasic.core.member;

/**
 * packageName    : springbasic.core.member fileName       : MemberService author         : asdfz date           :
 * 2023-12-28 description    : =============================================== DATE              AUTHOR             NOTE
 * ----------------------------------------------- 2023-12-28        asdfz       최초 생성
 */
public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
