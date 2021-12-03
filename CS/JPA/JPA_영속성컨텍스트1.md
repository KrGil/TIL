# [jpa] 영속성컨텍스트

> JPA의 개념에 대해 익숙지 않아 인강을 들으면서 정리를 진행하고 있습니다. 하지만 낯선 개념들이 많아 개인적으로 정리하고 이해하려고 하지만 잘못 이해하고 정리한 부분들이 존재할 수 있다고 생각됩니다. 만약 잘못된 부분이 있다면 언제든지 댓글 남겨 주시면 바로 반영하도록 하겠습니다.



### Words

- 영속성: "entity"를 연구저장하는 환경
- EntityManager.persist(entity)

> 앞에 이야기한 persist는 사실 db에 insert를 직접 시키는 쿼리문이 아니라고 합니다.
>
> persist를 통해 특정한 중간 공간에 저장하고 commit 시에 실제 insert가 이루어 집니다.

### 준영속, 삭제

```java
// 회원 엔터티를 영속성 컨텍스트에서 분리, 준영속 상태
em.detach(user);

// 객체를 삭제한 상태(삭제)
em.remove(user);
```



### persist

```\
// 비영 속
User user = new User();
user.setId(100L);
user.setName("HelloJPA");

// 영 속
System.out.println("=== BEFORE ===");
em.persist(user);
System.out.println("=== AFTER ===");

transaction.commit();
```



```
=== BEFORE ===
// 사이에 아무일도 일어나지 않는다.
=== AFTER ===
Hibernate: 
    /* insert hellojpa.User
        */ insert 
        into
            USER
            (name, id) 
        values
            (?, ?)
```

