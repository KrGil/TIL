# [JPA] 양방향 연관관계의 주인



> 연관관계의 주인
>
> @mappedBy
>
> FK를 가지고 있는 테이블



### Table

- User

```java
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "TEAM_ID")
 private Team team;
```

- Team

```java
 @OneToMany(mappedBy = "team")
 private List<User> users =  new ArrayList<>();   
```

1(Team): N(User)의 관계일 경우 jpa 설정을 위와 같이 설정합니다.



### 연관관계의 주인

User와 Team과 같은 객체에 양방향 연관관계 설정 시 어느 객체의 값을 변경해 주었을 때 실제 DB에 반영을 하느냐를 결정합니다.

위의 경우 User가 연관관계의 주인으로 설정되어 있어 User 객체에서 값을 변경해 주어야 DB에 값이 들어갑니다.

그래서 아래와 같이 Team에서 User를 추가하는 등의 값을 변경해 주어도 DB에 값이 변경되지 않습니다.

```java
team.getUsers().add(member);
```



### mappedBy

mappyedBy는 양방향 관계 설정에서 중요한 부분을 차지합니다. 바로 연관관계의 주인을 정하기도 하기 때문이지요. 

이때 주의할 점은 mappedBy를 걸어둔 객체(Team)에서는 User 객체의 값을 변경해도 실제 DB에는 데이터가 들어가지 않습니다.

mappedBy를 줄 때 몇가지 규칙을 정하고 주어 변경할 수 있습니다.

1. 연관 관계가 1:N일 경우 "1"인 객체(```Team```)에 mappedBy를 줍니다.

   이 경우 연관관계의 주인은 "N"인 객체(```User```)입니다.

2. 테이블의 연관관계 중 FK를 가지고 있지 않은 객체에 mappedBy를 줍니다.

   이 경우 FK를 가지고 있는 객체가 "N"이며, 연관관계의 주인입니다.

####  1:N의 경우 "1"에게 mappedBy를 거는 이유

1. 프로젝트가 커지면서 테이블의 구조가 복잡해 집니다. 이때 해당 객체가 아닌 다른 객체의 값을 수정했을 시 쿼리문에서 다른 테이블의 값이 변경되었을 경우 알아보기 힘들게 됩니다.
2. 이 외에도 기능상의 이슈가 존재한다고 합니다.

