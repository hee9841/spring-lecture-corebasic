package springbasic.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean protoTypeBean1 = ac.getBean(PrototypeBean.class);
        protoTypeBean1.addCount();
        assertThat(protoTypeBean1.getCount()).isEqualTo(1);

        PrototypeBean protoTypeBean2 = ac.getBean(PrototypeBean.class);
        protoTypeBean2.addCount();
        assertThat(protoTypeBean2.getCount()).isEqualTo(1);


    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(PrototypeBean.class, ClientBean.class);

        ClientBean clientBeanA = ac.getBean(ClientBean.class);
        int count1 = clientBeanA.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBeanB = ac.getBean(ClientBean.class);
        int count2 = clientBeanB.logic();
        assertThat(count2).isEqualTo(2);


    }

    @Scope("singleton")
    static class ClientBean {

        private final PrototypeBean prototypeBean;  //생서시점에 주입됨 X01 -> 계속 같은 것을 사용

        @Autowired  //생략가능
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }


//    @Scope("singleton")
//    static class ClientBean2 {
//
//        private final PrototypeBean prototypeBean;  //생서시점에 주입됨 X 02
//
//        @Autowired
//        public ClientBean(PrototypeBean prototypeBean) {
//            this.prototypeBean = prototypeBean;
//        }
//
//        public int logic() {
//            prototypeBean.addCount();
//            return prototypeBean.getCount();
//        }
//    }


    @Scope("prototype")
    static class PrototypeBean {

        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
