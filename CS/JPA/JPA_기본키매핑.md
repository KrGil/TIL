# 기본 키 매핑

> @Id
>
> @GeneratedValue



### 방법

- 직접 할당 : @Id 만 사용
- 자동 생성 : @GeneratedValue



#### @Id

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private String id;
```

```java
User user = new User();
user.setId("Id_a")
user.setUsername("A");

```



###  IDENTITY 전략

##### GenerationType.IDENTITY

> 기본 키 생성을 데이터 베이스에 위임합니다.
>
> MYSQL, PostgreSQL, SQL Server, DB2에서 사용합니다.
> ex) MySQL의 AUTO_ INCREMENT

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private String id;

```



```java
User user = new User();
user.setUsername("A");
```

​	**result**

```

ID  	NAME  
1		A
2		A

```

#### IDENTITY의 특징

> 보통 트랜잭션의 COMMIT시점에 INSERT SQL을 실행하지만 
>
> AUTO_INCREMENT는 데이터베이스에 INSERT SQL을 실행 한 후에 값을 알 수 있기 때문에
>
> IDENTITY 전략은 ```em.persist()``` 시점에 INSERT SQL을 실행하고 JPA 내부에서 SELECT SQL을 사용하여 PK값을 가지고 옵니다.
>
> 따라서 INDENTITY 전략은 INSERT를 모아서 한번에 쿼리를 실행시키기 어렵습니다.



### SEQUENCE 전략

##### GeneratedType.SEQUENCE

> 데이터베이스 시퀸스 오브젝트를 사용합니다.
>
> ORACLE에서 사용합니다.
>
> Sequence는 type을 Long으로 하는 것을 추천합니다.

아래와 같이 sequence를 생성하여 

```
create sequence hibernate_sequence start with 1 increment by  1
```

sql 쿼리문이 실행되는 것을 볼 수 있습니다.

```
Hibernate: 
    call next value for hibernate_sequence
Hibernate: 
    /* insert hellojpa.User
        */ insert 
        into
            USER
            (name, id) 
        values
            (?, ?)
```



#### @SequenceGenerator()

> 자동으로 생성되는 SEQUENCE가 아닌 임의대로 사용하기 위한 SEQUENCE를 생성하고자 할 때 사용합니다.
>
> @SequenceGenerator()

```java
@Entity
@Table(name = "USER")
@SequenceGenerator(name="user_seq_generator", sequenceName = "user_seq")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    private Long id;
...
...    
```

### SEQUENCE의 특징

> 영속성 컨텍스트에 값을 저장하기 위해서는 항상 PK가 필요합니다.
>
> 하지만 PK값은 항상 DB에 존재하기 때문에 SEQUENCE 전략이 된다면 JPA가 em.persist() 시점에 
>
> db에 존재하는 해당 SEQUENCE를 조회하여 값을 가지고 옵니다.

```
call next value for USER_SEQ
```



### TABLE 전략

> auto_increment or sequence 둘 중 하나를 선택할 필요가 없습니다.
>
> 모든 데이터베이스에 적용이 가능합니다.
>
> 단점으로는 성능이 조금 떨어집니다.
>
> @TableGenerator()

```java
@Entity
@TableGenerator(name = "USER_SEQ_GENERATOR",
                table = "MY_SEQUENCES",
                pkColumnValue = “USER_SEQ", allocationSize = 1)
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,
	generator = "USER_SEQ_GENERATOR")
	private Long id;
...
...
```



### allocationSize 

> sequence 한 번 호출에 증가하는 수(성능 최적화에 사용됩니다.) - 50~100 설정이 적당합니다.

만약 allocationSeize=50으로 설정하였다면

최초 ```call next value for USER_SEQ``` 로 현재 SEQUENCE를 가지고 오고 다시 한번 더 실행하여 DB에서 50까지의 값을 가지고 옵니다.

그 후 SEQUENCE 값을 조회할 시에는 MEMORY에서 꺼내게 되어 DB에 호출을 따로 하지 않아 성능을 향상시킬 수 있습니다.

그러다 51이 되면 다시 한번 더 ```call next value for USER_SEQ```를 사용하여 51~100까지의 값을 확보합니다.



### 권장하는 식별자 전략

- 기본 키 제약조건: NOT NULL, UNIQUE, 불변

권장: Long + 대체키 + 키 생성 전략으로 랜덤키를 조합하거나 프로젝트 룰에 따라 생성.











TABLE: 키 생성용 테이블 사용, 모든 DB에서 사용
•
•
@SequenceGenerator 필요
@TableGenerator 필요
AUTO: 방언에 따라 자동 지정, 기본값