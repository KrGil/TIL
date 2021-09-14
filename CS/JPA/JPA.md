# JPA

### Words

> - ORM
>     - Mybatis
>     - Hibernate
>     - JPA
>         - EJB
>         - Hibernate
> - Spring Framework



### ORM(Object-relational mapping) 객체 관계 매핑

- 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해 주는 것.
- ORM을 통해 객체 간의 관계를 바탕으로 SQL을 자동으로 생성하여 불일치를 해결.
- 객체를 통해 간접적으로 데이터베이스 데이터를 다루는 것.



### JPA(Java Persistence API)

#### EJB

- Entity Java Bean. (과거 자바 표준 ORM)
- 코드가 깔끔하지 못하다.
- 구현이 어렵고 실행속도가 매우 느리다.
- 위의 이유로 더이상 사용하지 않습니다.



#### Hibernate

- Open Source
- Gavin King이 EJB를 대체하기 위해 개발.
- JPA의 구현체



#### JPA(Java Persistence API)

- 현재 자바 표준 ORM
- 인터페이스들의 모음(JPA를 구현한 것이 Hibernate)
- Hibernate 이후 java에서 Gavin King을 데려와 만든 것.



#### Spring Framework

- Application famework.
- Open source.
- EJB에 격분한 Rod Johnson이 개발.







### JPA의 작동

- 어플리케이션과 JDBC 사이에서 작동
- JPA 내부에서 JDBC API를 사용, SQL을 생성 및 호출하여 DB와 통신.

![image-20210824161243257](https://raw.githubusercontent.com/KrGil/TIL/main/documents_typora/JPA.assets/image-20210824161243257.png)





## 왜 JPA인가?

1. SQL 중심적인 개발에서 객체 중심의 개발

    - 객체 지향과 관계형 데이터베이스 간의 패러다임 불일치
    - 객체지향적으로 짜면 짤 수록 쿼리의 양은 기하급수적으로 늘어납니다.

2. 생산성

    - Java Collection에서 데이터를 넣었다 뺐다 하는 것처럼 사용 가능.

    ```
    list.add(member)
    ```

    - 간단한 crud
        - *저장* : ```jpa.persiste(member)```
        - *조회* : ```Member member = jpa.find(memberId)```
        - *수정* : ```member.setName("변경할 이름")```
        - *삭제* : ```jpa.remove(member)```

    - 직접 query를 짤 필요가 없습니다.

3. 유지보수

    - JPA를 사용하지 않을 경우 필드, 쿼리 등의 변경 시 모든 SQL을 수정해야 합니다.
    - java쪽만 신경 쓰면 됩니다. SQL의 경우 JPA가 모두 처리합니다.

### 객체와 RDB 간의 페러다임 불일치

- 객체간의 상속과 RDB간의 상속 차이

![image-20210824162329136](https://raw.githubusercontent.com/KrGil/TIL/main/documents_typora/JPA.assets/image-20210824162329136.png)



- 연관관계 설정

    - ```
        member.setTeam(team);
        jpa.persist(member);
        ```

    - JPA가 member와 team의 연관관계를 알아서 설정합니다.

- 데이터 저장 시

    - 개발자가 아래 명령어를 짜면

        ```java
        jpa.persist(album);
        ```

    - JPA가 쿼리를 짜서 RDB에 넘겨줍니다.

        ```sql
        INSERT INTO ITEM ...
        INSERT INTO ALBUM ...
        ```

- 조회

    - 개발자가 아래 명령어를 짜면

        ```java
        Album album = jpa.find(Album.class, albumId);
        ```

    - JPA가 나머지를 알아서 처리합니다.

        ```sql
        SELECT I.*, A.* FROM ITEM I JOIN ALBUM A ON I.ITEM_ID = A.ITEM_ID
        ```



### 신뢰성

```java
class MemberService { 
      ...
      public void process() { 
          /* 직접 구현한 DAO에서 객체를 가져온 경우 */
          Member member1 = memberDAO.find(memberId); 
          member1.getTeam(); // 엔티티를 신뢰할 수 없음 
          member1.getOrder().getDelivery(); 
          /* JPA를 통해서 객체를 가져온 경우 */
          Member member2 = jpa.find(Member.class, memberId); 
          member2.getTeam(); // Lazy Loading
          member2.getOrder().getDelivery(); 
      } 
}
```

- DAO
    - DAO에서 직접 어떤 쿼리를 날렸는지 확인하지 않는 이상, 관련된 객체들을 모두 잘 가지고 왔는지 알 수 없습니다.

- JPA
    - 지연 로딩 전략(Lazy Loading)을 사용합니다.
        - 객체 사용 시점(member2.getTeam()에 해당 쿼리를 실행, 데이터를 가지고옵니다.)

### JPA의 성능

- 캐싱
- lazy 로딩
- 버퍼링

#### 1. 같은 트랜잭션 안에서 같은 엔터티를 반환- *캐싱*

```java
String memberId = "100"; 
Member m1 = jpa.find(Member.class, memberId); // SQL 
Member m2 = jpa.find(Member.class, memberId); // 캐시 (SQL 1번만 실행, 캐시에서 값을 가져옴)
println(m1 == m2) // true
```

#### 2. 객체가 사용될 때 해당 쿼리문 실행- *lazy 로딩*

```java
Member member = memberDAO.find(memberId);		// ---> SELECT * FROM MEMBER 
Team team = member.getTeam();
String teamName = team.getName(); 		// --->  SELECT * FROM TEAM
```

- 값이 실제로 필요한 시점에 JPA가 Team에 대한 SELECT 문을 생성 및 보냅니다.
- 두번의 SELECT 문을 조회하게 됩니다.
- Member와 Team 객체가 대부분 함께 사용하는 경우 즉시 로딩을 설정할 수 있습니다.

```java
Member member = memberDAO.find(memberId);		// ---> SELECT M.*, T.* FROM MEMBER JOIN TEAM ...
Team team = member.getTeam();
String teamName = team.getName(); 
```

- 최초의 연결 때 member와 team을 조회하는 쿼리를 보낼 수 있습니다.

#### 3. 트랜잭션을 지원하는 쓰기 지연 기능- *버퍼링*

```java
/** 1. 트랜잭션을 커밋할 때까지 INSERT SQL을 모음 */
transaction.begin();  // [트랜잭션] 시작
em.persist(memberA); 
em.persist(memberB); 
em.persist(memberC); 
// -- 여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.
// 커밋하는 순간 데이터베이스에 INSERT SQL을 모아서 보낸다. --
/** 2. JDBC BATCH SQL 기능을 사용해서 한번에 SQL 전송 */
transaction.commit();
```

위와 같이 하나의  트랜잭션으로  JDBC Batch 기능을 알아서 수행해 줍니다.



### 객체와 테이블의 페러다임 차이

### 연관관계. 

##### - 객체

Member.getTeam - 가능 Team.getMember - 불가능

##### - 테이블

Member -> Team - 가능

Team -> member - 가능

---

mybatis와 JPA의 차이

mybatis -> 변환시키지만 쿼리는 직접 짜야함.

jpa -> mybatis역할 + 쿼리까지 자동으로 짜줌.





# References



https://www.youtube.com/watch?v=WfrSN9Z7MiA&list=PL9mhQYIlKEhfpMVndI23RwWTL9-VL-B7U

https://gmlwjd9405.github.io/2019/08/04/what-is-jpa.html

https://gmlwjd9405.github.io/2019/02/01/orm.html

