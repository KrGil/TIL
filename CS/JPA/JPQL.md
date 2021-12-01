# [JPA] JPQL란?

> 앞서 한 내용에서는 기본적인 crud에 대해 알게 되었습니다
>
> 하지만 JPA를 사용하여 조건을 붙여 사용할 경우 어떻게 진행할까요?
>
> 이때 JPA에서 제공하는 언어가 JPQL입니다.

### JPQL이란?

SQL을 추상화한 객체 지향 쿼리 언어로 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리 입니다.



### 왜?

JPA 를 사용하면 엔터티 객체를 중심으로 개발을 합니다. 이때 **검색 쿼리**가 문제가 됩니다.

모든 데이터를 객체로 변환해서 검색하는 것은 불가능하기 때문입니다.

따라서 application이 필요한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요합니다.



### 특징

- SQL을 추상화해서 특정 데이터베이스 SQL에 의존하지 않습니다.

- JPQL을 한마디로 정의하면 객체 지향 SQL 입니다.

- SQL과 문법이 유사하고 SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 등을 지원



### JPQL과 SQL의 차이점

- JPQL은 엔티티 객체를 대상으로 쿼리를 제공합니다만

- SQL은 데이터베이스 테이블을 대상으로 쿼리를 제공합니다.



### 사용법

**전체 코드**

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

EntityManager em = emf.createEntityManager();

EntityTransaction tx = em.getTransaction();
tx.begin();

try {
    List<User> result = em.createQuery("select m from User as m", User.class)
        .setFirstResult(4)
        .setMaxResults(8)
        .getResultList();
    for (User user : result){
        System.out.println("user.name = " + user.getName());
	}
	tx.commit();
} catch (Exception e) {
	tx.rollback();
} finally {
	em.close();
}
emf.close();

```

**JQPL**

```java
List<User> result = em.createQuery("select m from User as m", User.class)
                    .setFirstResult(4)
                    .setMaxResults(8)
                    .getResultList();
for (User user : result){
	System.out.println("user.name = " + user.getName());
}
```

위와 같이 entityManager를 이용하여 사용하면 됩니다. 

```select m from User as m``` 에 나와있는 user는 테이블이 아닌 entity 객체를 의미합니다.

**console 창**

```
    /* select
        m 
    from
        User as m */ select
            user0_.id as id1_0_,
            user0_.name as name2_0_ 
        from
            USER user0_ offset ? rows fetch next ? rows only
```

**persistence.xml**

방언 설정을 아래와 같이 해주었습니다.(offset과 limit는 oracle 12버전 이상에서만 쓰입니다.)

```<property name="hibernate.dialect" value="org.hibernate.dialect.Oracle12cDialect"/>```

