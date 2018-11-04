### 1주차
1. 기초 공부
    1. Spring Framework 란?
        * Ioc/DI
        * AOP
        * PSA
        * POJO
    2. @SpringBootApplication
        * @SpringBootConfiguration
        * @EnableAutoConfiguration
        * @ComponentScan
    3. Spring-mvc 의 @Component 
        * @Controller, @Service, @Repository
        * @Autowired
    4. SpringApplication 과 ApplicationContext
2. application.yml 과 8080 포트

###### 참고
* [Using spring boot - spring docs](https://docs.spring.io/spring-boot/docs/1.5.13.BUILD-SNAPSHOT/reference/htmlsingle/#using-boot)

- - -

### 2주차
1. logging.level: debug
2. Create table
    1. schema.sql 
    2. data.sql
    3. spring.jpa.hibernate.ddl-auto
        * @Entity
        * @Id
        * @GeneratedValue
        * @Column
    4. H2 web-console
3. Setting mybatis
    1. MVC 모델 각자의 역할과 Mapper 인터페이스
    2. @Mapper 와 @Repository
    3. Mapping mapper.xml
    4. @Alias
4. DataSource 빈 생성하기

###### 함께 공부해볼만 한 내용들
* AbstractRoutingDataSource 을 이용한 dataSources(master, slave...) Routing 
* HikariCP 속성
* SQL 튜닝
* DataSources Transaction
* Rest API 

###### 참고
* [HikariCP git](https://github.com/brettwooldridge/HikariCP)
* [Mybatis spring boot autoconfigure](http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [MyBatis @Mapper 인터페이스는 어떻게 스프링 빈으로 와이어될 수 있을까?](http://wiki.sys4u.co.kr/pages/viewpage.action?pageId=7767258)
* [Spring Docs](https://docs.spring.io/spring-boot/docs/1.5.13.BUILD-SNAPSHOT/reference/htmlsingle/)

- - -

### 3주차

1. Spring JPA
    1. 왜 JPA?
        * DB CRUD를 위해 반복적인 SQL과 매핑 작업이 필요
        * SQL에 의존적인 개발 (등록, 조회, 수정, 연관된 객체)
        * 엔티티만 보고는 신뢰할 수 없음. (호출하는 SQL과 매핑 로직을 함께 봐야 함)
        * SQL의 Join 문으로 객체의 그래프 탐색 깊이가 고정되어 있음
        > 객체 모델과 관계형 DB 모델은 패러다임이 다르다.
    2. 특징
        * 쓰기 지연 SQL
        * 자동 변경 감지
        * 1차 캐시
        * 엔티티 동일성
        * 지연 로딩
    3. 데이터를 가져오는 다양한 방법들
        * 기본 메소드들(findOne, getOne, save ...)
        * Query Method
        * JPQL, SQL
        * QueryDSL

###### 참고
[Plugin for generating QueryDSL model files.](https://plugins.gradle.org/plugin/com.ewerk.gradle.plugins.querydsl)

- - -

### 4주차

1. Member 수정, 저장
    영속과 Transaction
1. Spring JPA 심화
    * 매핑관계
        * manytoone
        * onetomany
        * manytomany
    * 상속관계 매핑
        * MappedSuperclass
    * N + 1 이슈
        * fetchJoin
    * 기타    
        * @EnableJpaAuditing
        * @Type("yes_no)
        * projections

###### 참고
[spring-docs 3. Auditing](https://docs.spring.io/spring-data/jpa/docs/1.7.0.DATAJPA-580-SNAPSHOT/reference/html/auditing.html)
     
- - -

### 5주차
1. Junit
    * @RunWith
    * @SpringBootTest
2. bean
    * 동일성, 동등성 (BeanIdentityTest.class)
    * Bean 은 기본적으로 Singleton
        * Garbage collection 
    * Singleton 예제 - Calculator (ThreadSafeTest.class)
        * Thread 의 stack, heap 영역(각각 지역변수, 전역변수)
    
###### 공부해야할 것
* JVM 메모리 영역
* Garbage Collection
* Lambda
* Thread

- - -

### 6주차

1. 중간 점검
2. Swagger
    
###### 참고
[Springfox Reference Documentation](https://springfox.github.io/springfox/docs/snapshot/)
[Setting Up Swagger 2 with a Spring REST API](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

- - -

### 7주차
1. Swagger
    1. Redirect swagger-ui: SwaggerController.class
    2. getHeader "api-key" : MemberGroupRestController.class
2. Understanding proxy usage in Spring: posting
3. CGLIB vs JDK Dynamic proxy
4. EncryptAspect 와 EncryptType
5. Proxy 와 @Transactional
6. Async: AsyncTest.class

###### 추가로 공부해야 할 것
* transaction
    * isolation level
    * propagation
* Thread Pool
* Java Future

###### 참고

* [Transactions, Caching and AOP: understanding proxy usage in Spring](https://spring.io/blog/2012/05/23/transactions-caching-and-aop-understanding-proxy-usage-in-spring)
* [How To Do @Async in Spring](https://www.baeldung.com/spring-async) 
* [Caching Data with Spring](https://spring.io/guides/gs/caching/)
* [Creating Asynchronous Methods](https://spring.io/guides/gs/async-method/)
* [11장 트랜잭션 관리 #2](https://blog.outsider.ne.kr/870)

- - -

### 8주차
1. CustomTransactionManager
    * TransactionTemplate 사용
    * PlatformTransactionManager: CustomTransactionManager.class
    
2. Thymeleaf

3. Spring security
    1. WebSecurityConfigurer interface
    2. HttpSecurity, WebSecurity, AuthenticationManagerBuilder 를 받는 configure() 
    3. antMatchers 로 url 단위로 권한 authenticate
    4. login, logout
    5. AuthenticationManager
    6. UserDetailService
    7. passwordEncoder
    
###### 참고
* DaoAuthenticationProvider.class (기본으로 구현되는 provider)

###### 추가로 공부해야할 것
* CSRF
* Thymeleaf


- - -

### 9주차
1. AuthenticationProvider 의 역할 CustomAuthenticationProvider.class
2. EnableOAuth2Client 로 Oauth2 개발하기
    1. @EnableOAuth2Client
    2. @ConfigurationProperties
    3. ssoFilter
    4. Principal
    5. AuthenticationSuccessHandler : OAuthSuccessHandler.class
    
###### 참고
* [Spring security docs - 3. What’s New in Spring Security 5.0](https://docs.spring.io/spring-security/site/docs/5.0.5.RELEASE/reference/htmlsingle/#new)
* [Spring docs - Hello Spring Security with Boot](https://docs.spring.io/spring-security/site/docs/5.0.5.RELEASE/guides/html5/helloworld-boot.html)
* [Spring blog - Spring Security Architecture](https://spring.io/guides/topicals/spring-security-architecture/)
* [oauth 로그인 세션 관리](https://jojoldu.tistory.com/170?category=635883)
* [Spring Security OAuth 통합 로그인 : 1. OAuth 소개](https://gs.saro.me/dev?tn=518)

- - -

### 10주차
1. Spring Security
    1. remember me 세팅하기
2. validate
    1. @Valid, bindingResult
    2. Validator.class
    3. MemberException, ErrorCode 와의 관계 - 인터페이스
    4. MemberException, CustomMessageHandler 와의 관계 - bean 과 util class
    5. MessageSource
3. LocaleConfig
   1. CookieLocaleResolver
   2. LocaleChangeInterceptor

###### 공부할 것
* Web 서버와 WAS
* Reverse proxy

###### 참고
* [OAuth 2 Explained](https://www.youtube.com/watch?v=L1PDqJkedZ0)

- - -

### 11주차
1. JPA
2. Remember me 이슈
    1. Remember me와 세션
    2. getTokenForSeries() 시 빌드 시 휘발되는 h2로 인해 유저 정보가 없는 경우
3. Cache
    1. Cache hit
    2. 로컬 캐시와 분산 캐시
    3. MemberGroupCacheTest.class
4. Profile
    1. Profile
    2. @Value
5. Spring actuator
    1. beans 
    2. autoconfig
    3. metrics: heap, gc, thread 정보
    4. health
6. Error Handling
    1. error.html
    2. @ResponseStatus
    3. @ControllerAdvice
    
###### 공부해야할 것
* Scouter
* BooleanExpression
* gc(stw!)
* memory leak
* OOM
* preparedStatement와 statement
* health check
  
###### 참고
* [Spring Boot – Profile based properties and yaml example](https://www.mkyong.com/spring-boot/spring-boot-profile-based-properties-and-yaml-example/)
* [Spring-RememberMe 구현](https://minwan1.github.io/2017/08/06/2017-08-06-spring-remember-me/)

### 12주차
1. DispatcherServlet 의 구조와 요청 처리 프로세스
    1. GenericServlet.class
        * init()
    2. HttpServlet.class
        * doGet(), doPost()
    3. HttpServletBean.class
        * overriding init()
        * initServletBean()
    4. FrameworkServlet.class
        * overriding initServletBean()
            * initWebApplicationContext() 에서 root ApplicationContext
        * overriding doGet(), doPost() ...
            * 모든 요청은 processRequest(req, rep)로 doService(req, rep)을 실행 - frontController(DispatcherServlet) 에게 위임 
    5. DispatcherServlet.class
        * overriding doService() -> doDispatch(req, rep)
            1. mappedHandler = getHandler(processedRequest);
                * HandlerMapping: 들어온 요청을 매핑할 handler 를 결정
                * HandlerExecutionChain = controller + interceptor
            2. HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
                * HandlerAdapter: dispatcher 에게 실 구현 Handler 를 연결
            3. Process last-modified header 
            4. Apply preHandle methods of registered interceptors(mappedHandler.applyPreHandle(processedRequest, response))
            5. Actually invoke the handler. (.handle(processedRequest, response, mappedHandler.getHandler()))
            6. Apply postHandle methods of registered interceptors. (mappedHandler.applyPostHandle(processedRequest, response, mv);)
            7. processDispatchResult(req, rep, ...):  핸들러 결과 처리, render(mv, request, response)
    6. FrameworkServlet 의 publishRequestHandledEvent(req, rep, ...)
2. 마무리

###### 공부할 것 
* 정규화와 역정규화
* inner, left join

###### 참고
* [SPRING MVC REQUEST LIFE CYCLE](https://justforchangesake.wordpress.com/2014/05/07/spring-mvc-request-life-cycle/)