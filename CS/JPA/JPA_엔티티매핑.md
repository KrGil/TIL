# JPA_엔티티매핑



### 엔티티매핑

> 객체와 테이블 매핑: ```@Entity```, ```@Table```
>
> 필드와 컬럼 매핑: ```@Column```
>
> 기본 키 매핑: ```@id```
>
> 연관관계 매핑: ```@ManyToOne```, ```@JoinColumn```



### @Entity

- @Entity가 붙은 클래스는 JPA가 관리하는 Entity라 지칭합니다.
- JPA를 사용하여 테이블과 매핑할 클래스는 @Entity가 필수적으로 붙습니다.

- **기본생성자 필수** 적으로 생성되어야 합니다.
- final, enum, interface, inner 클래스는 @Entity가 적용되지 않습니다.



### Table

> name
>
> catalog
>
> schema
>
> uniqueConstrains(DDL) ...

```
@Entity   // @Entity 사용방법
@Table(name = "USER")   // @Table(name) 사용방법
public class User {

    @Id
    private long id;

    @Column(name = "name")   
    private String name;
    public User(){};
    public User(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

위와 같이 @Table을 사용하게 되면 class의 명에 상관없이 table명을 따로 매핑 시켜줄 수 있습니다.

다만 이렇게 생성할 시 클래스가 많아짐에 따라 헷갈릴 수 있으니 프로젝트 시 특별한 일이 없다면 ```@Table(name)```을 따로 설정하지 않는것을 추천드립니다.



