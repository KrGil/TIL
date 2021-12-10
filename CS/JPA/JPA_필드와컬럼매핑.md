# [JPA] 필드와 컬림매핑

# 매핑 어노테이션

- ```@Column```		: 컬럼 매핑
- ```@Temporal``    : 날짜 타입 매핑
- ```@Enumerated```  : Enum 타입 매핑
- ```@Lob```  : BLOB, CLOB 매핑
- ```@Transient```  : 특정 필드를 컬럼에 매핑하지 않을 시(매핑 무시)



#### @Enumerated 사용 시 주의할 점

> EnumType.ORDINAL: enum 순서를 데이터베이스에 저장
>
> EnumType.STRING: enum 이름을 데이터베이스에 저장

Enum의 기본 설정은 EnumType.ORDINAL 입니다. 위의 설명처럼 ORDINAL은 DB에 순서만 저장되기 때문에 만약 enum에 다른 값을 추가할 경우 ORDINAL의 번호가 변경될 수 있습니다. 따라서 enumType을 ORDINAL이 아닌 STRING으로 설정하여 사용하시면 위와 같은 경우를 피할 수 있습니다.

```
//@Enumerated(EnumType.ORDINAL) Ordinal보다 Strin으로 사용하는것을 추천합니다.
@Enumerated(EnumType.STRING)
private RoleType roleType;

```



#### @Temporal

> 날짜 타입(java.util.Date, java.util.Calendar)을 매핑할 때 사용.
>
> 최신 Hibernate에서는 LocalDate, LocalDateTime을 지원해서 생략 가능합니다.

```java
@Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
```



#### @Lob

> 매핑하는 필드 타입이 
>
> String -> CLOB
>
> 나머지 -> BLOB
>
> 으로 매핑됩니다.

