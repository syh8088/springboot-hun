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

### 앞으로의 대략적인 컨텐츠

프로파일과 @Value

* Template engine - Thymeleaf 세팅
* Spring valid 와 BindingResult 로 유효성 검증

* Swagger 로 RestAPI view 만들기
* war 와 jar 차이점
* Junit 과 Mockito 로 테스팅하기


* AOP 와 응용 모듈들
    * transactional
    * async
    * cache

* MessageSources
    * internationalization
    * interceptor
        
* Exception 처리하기
    * 어디서 처리해야하나?
    * ControllerAdvice, ExceptionHandler

* Spring Security
    * login
    * architecture
    * Authentication and AccessController
    * Filter
    
* spring batch