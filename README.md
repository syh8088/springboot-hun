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

### 앞으로의 대략적인 컨텐츠

* Mybatis + H2 로 간단한 테스트 DB 만들기

* Template engine - Thymeleaf 세팅
* Swagger 로 RestAPI view 만들기
* Spring valid 와 BindingResult 로 유효성 검증
* war 와 jar 차이점
* Junit 과 Mockito 로 테스팅하기

* Spring data(JPA)
    * Entity
    * 쿼리메소드
    * 한계
* QueryDSL

* Spring Security
    * login
    * architecture
    * Authentication and AccessController
    * Filter

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

