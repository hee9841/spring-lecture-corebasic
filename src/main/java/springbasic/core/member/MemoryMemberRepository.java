package springbasic.core.member;

import java.util.HashMap;
import java.util.Map;

/**
 * 구현체
 */
public class MemoryMemberRepository implements MemberRepository{

    //동시성 이슈때문에 concurrent hashMap을 사용함(실무에서) -> 따로 공부
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
