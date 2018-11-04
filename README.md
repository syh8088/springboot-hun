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
     

### 앞으로의 대략적인 컨텐츠

빈과 스레드 세이프

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

