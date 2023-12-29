# spring-lecture-corebasic
김영한 스프링 강의 - 핵심원리 기본편
***
1. [세션1](#(세션1)-객체-지향-설계와-스프링)
2. ㅇㄹㅇ
3. ㅇㅇㅇ
4. ㄹㄹ
5. ㄹㄹ
6. ㄹㄹ
7. ㄹㄹ
8. ㄹㄹ
9. ㄹㄹ
10. ㄹㄹ
11. fff
12. ff
13. ff
14. ff
15. ff
16. ff
17. ff
18. ff
19. ff
20. ff
21. ff
22. 
***

# (세션1) 객체 지향 설계와 스프링

# 1. 스프링의 탄생

## 지옥의 EBJ(Enterprise Java Beans)

- 2000년대 초반에는 EJB를 사용했음
- EJB는 여러 좋은 구성들이 있었으나 비싸고 어렵고 복잡하고 느렸음
- 위의 이유로 POJO로 돌아가자!! 같은 이야기들이 나옴

## 스프링의 시작

두 사람에 이해 시작됨

### 로드 존슨이 문제점을 지적하는 책을 발표

- EJB의 문제점을 지적하는 3만 라인 이상의 기술 예제 코드를 선보임
- 이 코드가 바로 스프링의 핵심 코드가 됨(BEANFACTORY, ApplicationContext, POJO, 제어의 역전, 의존관계 주입 등)
- 이는 EJB의 컨테이너를 대체하고
- 단순함
- 책 출간 이후 유겐 휠러, 얀 카프로가 로드 존슨에게 오픈소스 프로젝트 제안
    - 이게 바로 스프링이 됨

### 개빙 킹의 하이버네이트

- EJB 엔티티빈 기술을 대체함
- JPA(Java Persistence API) 새로운 표준 정의 됨
    - java 표준을 정의하고 논의 하는 곳에서
      EJB 버림 → 개빙 깅의 하이버네이트를 가지고 JPA를 만듬
    - JPA는 표준 인터페이스
    - 구현체로는 `하이버네이트`, EclipseLink 등이 있음

# 2. 스프링이란?

## 스프링 생태계

- 필수 : 스프링 프레임워크, 스프링 부트
- 선택 : 스프링 데이터, 세션, 시큐리티, docs, 배치 ,클라우드 등

### 스프링 프레임워크

- 핵심 기술 : DI 컨테이너, AOP, 이벤트 ,기타
- 웹기술 : 스프링 MVC, 스프링 WebFlux
- 그 외 여거 기술들을 사용

### 스프링 부트

- 스프링 프레임워크의 기술들을 편리하게 사용하게 지원
- 단독 실행할 수 있는 스프링 애플리케이션 쉽게 생성
- Tomcat과 같은 웹서버를 내장해 별도 웹 서버 설치 안해도 됨
- 손 쉬운 빌드 구성을 위한 starter 종속성 제공
- 스프링과 서드파트(외부)라이브러리 자동 구성
- 메트릭, 상테확인, 외부 구성 같은 프로덕션 준비 기능 제공
- 간결한 설정

### 스프링의 핵심 기술

- java언어 기반의 프레임워크
- **좋은 객체 지향 애플리케이션을 개발 할 수 있게 도와주는 프레임워크**
    - EJB로 하면 종속되어서 개발이 되었음
      → 스프링이 나오면서 DI 컨테이너가 이(객체지향 프로그래밍)를 가능하게 해줌

---

# 3. 좋은 객체 지향 프로그래밍이란?

## 1. 좋은 객체 지향의 특징

- 객체들의 모임, 객체들은 메시지를 주고 받고 협력할 수 있다.

- 유연, 변경 용이

  → **다형성**

## 1-1. 다형성

- 실 세계와 비유하기 힘들긴 하지만
- 실 세계를 `역할`과 `구현`으로 구분한다고 하면

### 운전자 -자동차

![0](/img/image.png)

자동차가 바꿔도 운전자에게는 영향을 안 줌

- 자동차는 역할의 인터페이스에 따라서 구현해 함
- 운전자는 자동차의 인터페이스만 알면 됨
- 자동차 인터페이스를 구현한 이유는 운전자를 위해
- 자동차 세상을 무한히 확장할 수 있음  
  → 클라이언트에 영향을 안 주고 기능을 추가 구현할 수 있음
- 이 이유는 역할과 구현으로 나누었기 때문

### 공연 무대

![1](/img/image1.png)

- 배우는 대체 가능함
- 역할에 영향을 주면 안됨

## 역할과 구현으로 구분하면

- 단순, 유연 해지고 변경 편리
- 장점
    - 클라이언트는 대상의 인터페이스(역할)만 알면 됨
    - 클라이언트는 내부 구조를 몰라도 됨
    - 클라이언트는 내부 구조가 변경되어도 영향을 받지 않음
    - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않음

## 역할과 구현을 분리

- 자바에서 다형성을 활용
    - 역할 == 인터페이스
    - 구현 == 인터페이스를 구현한 클래스, 구현 객체
- 구현보다 인터페이스가 더 중요

## 객체는 협력이라는 관계

- 혼자 있는 객체는 없음
- 클라이언트: 요청, 서버 : 응답

![2](/img/image2.png)

## 자바 언어의 다형성

- 오버라이딩을 떠올리자
- 다형성으로 인터페이스를 구현한 객체를 실행 시점에 유현하게 변경할 수 있음
- 클래스 상속 관계도 다형성, 오버라이딩 적용 가능

![3](/img/image3.png)

## 다형성의 본질

- 인터페이스를 구현한 객체 인스턴스를 실행 시점에서 유연하게 변경
- 다형성 본질은 객체 사이의 협력
- 클라이언트를 변경하지 않고, 서버 구현 기능을 유연하게 변경할 수 있다.

## 역할과 구현을 분리하는 것의 한계

- 역할(인터페이스) 자체가 변하면 클라이언트, 서버 모두 큰 변경이 발생

  → **인터페이스를 안정적으로 잘 설계하는 것이 중요**

## 스프링과 객체 지향

- 다형성이 가장 중요하고 스프링은 이를 극대화할 수 있게 도와줌
- IoC, DI 등을 통해 편리하게 구현하게 도와줌

---

# 4. SOLD 원칙

## 1. SRP (Single Responsibility Principle;단일 책임 원칙)

- 한 클래스는 하나의 책임만 가져야 함
  → 모호함
    - 클 수도, 작을 수도 문맥에 따라 다를 수도 있음
- 중요한 기준은 변경
  → 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것

## `2. OCP (Open/Closed Principle; 개방-폐쇄 원칙)`

- 소프트웨어 요소는 확장에는 열려 있으나, 변경에는 닫혀있어야 한다.

  → 다형성을 활용

- 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능 구현
  (기존 코드를 변경하는 것이 아님)
- 역할과 구현의 분리에 대해 생각

### 문제점

- 구현 객체를 변경하려면 클라이언트 코드를 변경해야함

![4](/img/image4.png)

- 분명 다형성을 사용했지만 OCP원칙을 지킬 수 없음
- 해결 방법?
    - 객체를 생성하고 연관 관계를 맺어주는 별도의 조립해주는 설정자가 필요 → **스프링 컨테이너**
    - OCP를 지키기 위해 IoC, DI가 필요함

## 3. LSP (Liskov Subsitiution Principle; 리스코프 치환 원칙)

- 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야함
- 다형성에서 하위 클래스는 인터페이스 **규약을 다 지켜야함**
- 다형성을 지원하기 위한 원칙임
- 인터페이스를 구현한 구현체를 믿고 사용하기 위해서는 이 원칙이 필요함

## 4. ISP (Interface Segregation Principle; 인터페이스 분리 원칙)

- 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
    - 덩어리가 크면 구현하기 힘듬
    - 예)와 같이 분리하면 정비 인터페이스가 변해도 운전자 클라이언트에게 영향을 주지 않음
        - 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스
        - 사용자 인터페이스 -> 운전자 인터페이스, 정비사 인터페이스
    - 인터페이스가 명확해지고 대체 가능성이 높아짐

## `5.DIP (Dependency Inversion Principle; 의존관계 역전 원칙)`

- 프로그래머는 추상화에 의존해야지 구체화에 의존하면 안된다. -> 이 원칙을 따르는 방법 중에 하나
- 구현 클래스에 의존하지 말고, 인터페이스에 의존하라
- 역할에 의존해야 한다.
- OCP에서 설명한 코드에서 MemberService는 인터페이스에 의존하지만 구현 클래스도 동시에 의존
    - → MemberRepository m = new MemoryMemberRepository();

      → **`DIP 위반`**


## 6. 정리

- 객체 지향 핵심은 다형성
- 다형성만으로는 구현 객체를 변경할 때 클라이언트 코드도 변경됨

  (다형성만으로는 쉽게 부품을 갈아 끼우듯 개발 할 수 없음) -> 입문 강의 코드 보면

- 다형성만으로는 OCP, DIP를 지킬 수 없음
- 뭔가 더 필요하다 -> 앞으로의 강의 내용
