package springbasic.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;
import springbasic.core.member.MemberService;


public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",
            MemberService.class);

        Member member1 = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);

        System.out.println("findMember.getName() = " + findMember.getName());
        System.out.println("member1.getName() = " + member1.getName());

    }
}
