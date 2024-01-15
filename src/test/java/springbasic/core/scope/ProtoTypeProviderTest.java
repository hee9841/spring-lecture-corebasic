package springbasic.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class ProtoTypeProviderTest {


    @Test
    void prototypeBeanProviderTest() {
        AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(PrototypeBean.class, ClientBean.class);

        ClientBean clientBeanA = ac.getBean(ClientBean.class);
        int count1 = clientBeanA.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBeanB = ac.getBean(ClientBean.class);
        int count2 = clientBeanB.logic();
        assertThat(count2).isEqualTo(1);


    }

    @Scope("singleton")
    static class ClientBean {

//        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        //ObjectProvider의 부모클래스임
        //ObjectProvider는 ObjectFactory의 getObject + 그외 추가 기능이 있음
//        private ObjectFactory<PrototypeBean> prototypeBeanProvider;

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;



        public int logic() {
            //여기서 getObject를 호출하면 이때 스프링에서 프로토타입 빈을 찾아서 반환
            //애플리케이션 컨택스트한테 직접 차즌게 아니라 아래 코드가 찾아주는 기능만 제공
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }


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
