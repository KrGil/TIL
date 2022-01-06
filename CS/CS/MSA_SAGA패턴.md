# SAGA 패턴이란?

### Before go further

사실 제가 얼마 전에 이직을 하게 되었습니다. 그리고 바로 프로젝트에 투입할 수 있도록 절차를 밟고 있는 중입니다. 해당 프로젝트가 msa로 짜져 있어 관련 공부를 할 겸 다른 블로그들과 인강들을 듣고 있는 중입니다. 그 중 SAGA 패턴에 대해 잘 정리되어 있는 블로그를 발견하여 해당 블로그에서 글을 발췌하여 작성합니다. 출처는 본 글의 하단에 작성해 놓았습니다. SAGA 패턴에 대해 조금 더 상세한 글을 원하신다면 직접 방문해 보시는 것을 추천합니다.



### 트랜잭션 처리

- 기존의 Monolithic 환경에서는 DBMS가 기본적으로 제공해주는 트랜잭션 기능을 통해서 데이터 commit이나 rollback을 통해서 일관성있게 관리하였습니다만 Application과 DB가 분산되면서 해당 트랜잭션 처리를 단일 DBMS에서 제공하는 기능으로 해결할 수 없게 되었습니다.

#### 	트렌젝션이란?

	- 데이터베이스의 상태를 변화시키기 위해서 수행하는 작업의 단위를 의미합니다. 트랜잭션은 4가지 특성(원자성, 일관성, 독립성, 지속성)을 지켜야 합니다.



### SAGA 패턴

마이크로서비스들끼리 이벤트를 주고 받아 특정 마이크로서비스에서의 작업이 실패하면 이전까지의 작업이 완료된 마이크로서비스들에게 보상(complemetary) 이벤트를 제공함으로 분산 환경에서 원자성(atomicity)을 보장하는 패턴입니다.

![image-20220106141900336](https://raw.githubusercontent.com/KrGil/TIL/main/CS/CS/MSA_SAGA%ED%8C%A8%ED%84%B4.assets/image-20220106141900336.png)

그리고 SAGA 패턴의 이벤트 실패 시는 다음과 같이 실패 이벤트를 주어 처리합니다.

![image-20220106141919851](https://raw.githubusercontent.com/KrGil/TIL/main/CS/CS/MSA_SAGA%ED%8C%A8%ED%84%B4.assets/image-20220106141919851.png)

SAGA 패턴의 핵심은 트랜잭션의 관리주체가 DBMS에 있는 것이 아닌 Application에 있습니다. 따라서 각각의 Application의 트랜잭션 요청의 실패로 인한 Rollback 처리(보상)은 Application에서 구현합니다.(분산되어 있으니까요)

SAGA패턴에도 몇가지 종류가 있다고 합니다. 더욱 상세한 내용을 원하신다면 아래 출처 링크를 통해 글을 읽어보시길 바랍니다.





### 출처

https://azderica.github.io/01-architecture-msa/