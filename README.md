# Servlet_JSP_Spring
Servelt JSP을 통한 Spring 구현
![Dispacher](https://user-images.githubusercontent.com/65889898/97840047-b0605c80-1d26-11eb-8afc-22516ba25ad8.jpg)

## 각각의 역할

##### Dispatcher-Servlet
Servlet Container에서 HTTP프로토콜을 통해 들어오는 모든 요청을 프레젠테이션 계층의 제일앞에 둬서 중앙집중식으로 처리해주는 프론트 컨트롤러(Front Controller)

##### HandlerMapping
클라이언트의 요청을 처리할 Controller를 매핑

##### Controller
실질적인 클라이언트의 요청 처리

##### ViewResolver
Controller가 리턴한 View 이름으로 실행될 경로 완성

## 동작 순서
1. 사용자의 모든 요청을 제일앞에 DispatcherServlet이 받는다.
2. URI를 Parsing해서 Path를 HandlerMapping에게 넘긴다.
3. HandlerMapping은 사용자 요청을 처리할 수 있는 올바른 Controller를 리턴한다.
4. Controller는 내부의 HandlerRequest를 통해서 요청을 처리한다.
5. 요청을 처리한 뒤 이동할 화면을 ViewResolver를 통해 JSP(혹은 View)파일의 이름과 경로를 리턴받는다.
6. 사용자에게 올바른 뷰를 보여준다.

## 정리
스프링 MVC를 간단한 코드로 직접 구현 했다.
하지만 위의 코드처럼 Dispacher Servlet를 직접 구현할 필요는 없다.
왜냐하면 스프링 MVC가 다 지원을 해주기 때문이다.
