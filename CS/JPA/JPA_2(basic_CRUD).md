# JPA_2

### JPA 기초와 매핑

@Entity : JPA가 관리할 객체

@Id : DB PK와 매핑 할 필드



### EntityManager

EntityManagerFactory: application 로딩 시점에 딱 하나만 존재해야합니다.

EntityManger: transaction 마다 생성해 주어야 합니다.



### persistence.xml 

#### hibernate option 설정

> ```xml
> <property name="hibernate.show_sql" value="true"/>
> <property name="hibernate.format_sql" value="true"/>
> <property name="hibernate.use_sql_comments" value="true"/>
> ```
>
> 

```<property name="hibernate.show_sql" value="true"/>```은 아래와 같이 sql을 보여주게 하는 설정입니다.

```ㅉ
Hibernate: 
    /* insert hellojpa.User
        */ insert 
        into
            User
            (name, id) 
        values
            (?, ?)
```

```<property name="hibernate.format_sql" value="true"/>``` 은 가독성을 위해 들여쓰기 및 줄바꿈 등을 해서 보여주게 하는 옵션입니다.

```<property name="hibernate.use_sql_comments" value="true"/>``` 은 아래와 같이 무엇을 실행했는지 주석처리로 알려주는 역할을 하는 옵션입니다.

```
    /* insert hellojpa.User
        */ insert 
```



### 간단한 jpa 사용법(insert, select, update,  delete)

> em.persist(); // INSERT
>
> em.find();	// SELECT
>
> em.find().set<COLUMN>();	// UPDATE
>
> em.remove();	// DELETE

#### EntityManagerFactory 및 EntityManager 설정

```
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistense.xml 설정 파일의 name
 EntityManager em = emf.createEntityManager();
 EntityTransaction tx = em.getTransaction();
 ...
```

#### insert

```
		  // insert
//            User user = new User();
//            user.setId(2L);
//            user.setName("helloB");
//
//            em.persist(user);
```

insert의 경우 위와 같이 객체를 선언하고 pk(ID)와 함께 insert할 값을 설정해 주면 됩니다.

#### select

```
			// select
//            User findUser = em.find(User.class, 1L);
//            System.out.println("findUser: "+findUser.getId());
//            System.out.println("findUser: "+findUser.getName());

```

select의 경우 위와 같이 em.find로 해당하는 pk(id = 1L)의 값을 찾습니다.

#### delete, update

```
			// delete
//            em.remove(findUser);

            // update
//            findUser.setName("HelloJPA");

```

```delete```의 경우 위에서 찾은 객체를 ```em.remove()```를 사용하여 해당 값을 삭제 할 수 있습니다.

```update``` 의 경우 ```em.find()```로 찾은 객체에 ```.set<COLUMN>()을 사용하여 UPDATE를 실행 할 수 있습니다.

jpa의 entity에 등록된 객체들은 commit 전에 jpa가 확인을 합니다. 그리고 값이 변경 되어 있다면 자동으로 ```update```를 실행시킵니다.


