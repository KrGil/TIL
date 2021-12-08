### 준영속 상태

> EntityManager(영속성 컨텍스트)에 올려져 있는 객체를 내리는 것
>
> 더이상 JPA가 관리하지 않겠다는 뜻입니다.

### Method

- EntityManager.detach()

- EntityManager.clear()

- EntityManager.close()

### Code

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

EntityManager em = emf.createEntityManager();

EntityTransaction tx = em.getTransaction();

tx.begin();
try {
	User user = em.find(User.class, 1L);
	user.setName("AAAA");

	em.detach(user);  // 영속성컨텍스트에서 객체 내리기(영속 -> 비영속 상태)
	User user2 = em.find(User.class, 1L);

	tx.commit();
} catch (Exception e) {
	tx.rollback();
} finally {
	em.close();
}
emf.close();
```

위와 같이 실행 시 commit을 실행시키면 아래의 결과와 같이 ```update```가 실행되지 않고 ```select``` 가 두번 실행되는 것을 알 수 있습니다.

#### Result

```sql
Hibernate: 
    select
        user0_.id as id1_0_0_,
        user0_.name as name2_0_0_ 
    from
        USER user0_ 
    where
        user0_.id=?
Hibernate: 
    select
        user0_.id as id1_0_0_,
        user0_.name as name2_0_0_ 
    from
        USER user0_ 
    where
        user0_.id=?
```



