package springbasic.core.singleton;


public class SingletonService {

    //자기 자신을 내부에 private static 으로 하나 가지고 있음 ->
    //todo
    // static 공부
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        //인스턴스를 꺼낼 수 있는 것 애뿐이 없음
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
