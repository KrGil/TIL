### Application을 민첩성 있게 만들기

#### 비즈니스적으로 관심사를 분리

DDD(Domain Driven Disign)

DDD로 짜기 위한 방법 EventStorming



#### 구조적 민첩성을 위한 역할별로 관심사 분리

database-centric architectures ->

Hexagonal architecture (biz를 내부 / 외부로 분리)

​	내부와 외부로

​	내부는 비즈니스에 집중.(entities, aggregates, rules)

​	외부 db, ui 등 비즈니스 외적인 것에 집중. 

​	ports /  adapter를 활용하여 외부가 내부에 영향을 주지 않게끔.

The Clean Architecture(biz와 application의 분리. 의존관계 역전)

​	UserCase: 어플리케이션 관련 비즈니스 규칙을 가지는 유즈케이스

​		ex) 사용자가 입력한 고객 정보르 받아서 entity에 전달 후 이상이 없으면 service의 db 저장 호출.

​	Entities: 핵심 비즈니스 규칙을 가지는 엔터티

​		고객정보 체크.





