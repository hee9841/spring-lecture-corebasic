package springbasic.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class ProtoTypeTest {

    @Test
    void protoTypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            ProtoTypeBean.class);

        System.out.println("find prototypeBean1");  //프로토타입을 조회하기 직저에 생성해서 이를 보여줄려고
        ProtoTypeBean protoTypeBean1 = ac.getBean(ProtoTypeBean.class); //이때 새 객체가 생성되면서 init 호출

        System.out.println("find prototypeBean2");
        ProtoTypeBean protoTypeBean2 = ac.getBean(ProtoTypeBean.class);

        System.out.println("protoTypeBean1 = " + protoTypeBean1);
        System.out.println("protoTypeBean2 = " + protoTypeBean2);

        assertThat(protoTypeBean1).isNotSameAs(protoTypeBean2);

        // 종료해야하면 수동으로 직접 입력
        protoTypeBean1.close();
        protoTypeBean2.close();

        ac.close();         //Destroy 호출 안됨


    }


    @Scope("prototype")
    static class ProtoTypeBean {

        @PostConstruct
        public void init() {
            System.out.println("ProtoTypeBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("ProtoTypeBean.close");
        }
    }


}
