# [Kafka] 카프카란? 카프카의 기본지식

> 몇일 전 동료가 kafka 방식의 Subscriber를 구현하는데 어려움을 겪고 있어 잠깐 함께 관련된 것들을 검색하고 고민해 보있습니다. 
>
> 그러던 중 문득 든 생각이 무심코 kafka(카프카)를 사용은 하고 있는데 알고 있는 지식이 거의 없다는 것을 알았습니다.
>
> 그래서 카프카의 기본 지식에 대해서 정리해 보려고 합니다. 궁금하신 사항이나 잘못 기업된 사항이 있다면 댓글 달아주세요.

# KAFKA

> MSA(Micro Service Architecture)로 어플리케이션이 구성됨에 따라 각각의 서비스들이 통신하는 방법이 복잡해 졌습니다. 이로 인해 데이터 전송 및 배포에 어려움을 겪게 됩니다.
>
> Apache Kafaka는 이러한 문제를 해결하기 위해 Linked In에서 개발한 오픈소스입니다.

Kafka는 아래의 이미지와 같이 `cluster`로 설계되어 있고` topic`을 `Partition`으로 분할하여 메시지를 관리합니다. 한 개의 `topic`이 수십 개의 `partition`으로 나뉘어 병렬 스트리밍이 가능하게 됩니다.

각 토픽은 여러개의 파티션으로 분할 될 수 있으며 이 경우 클러스터의 각 노드는 하나의 토픽의 하나 이상의 파티션(토픽 전체가 아닌)의 리더가 됩니다.

...? 말이 참 어렵네요. 해당 관련해서 조금 더 자세히 아시고 싶으신 분들은 https://kafka.apache.org/documentation/  Apache Kafka Document를 참고해보시는게 좋을 듯 합니다.

![KafkaImg](/Users/eisen/Documents/Github/TIL/CS/MSA/Kafka_basic.assets/KafkaImg.jpeg)

위의 이미지와 같이 카프카는 `Producer`, `Consumer`, `Topic` 총 세가지로 구성되어 있습니다.

생성된 메시지는 `Key-value` 형태로 Kafak 서버에 저장되고 이 서버는 `Broker`라 합니다. 또 이 `Broker`들은 여러 개 생성될 수 있는데, 이 `Broker`들을 관리하는게 `zookeeper`입니다.

위와 같이  `Producer`가 메시지를 생성하면 `Broker`에 `key-value`로 저장됩니다.  그 후 `Consumer`가 `Topic`을 기준으로 메시지를 `Subscribe` 하게 됩니다.  

이렇게 Kafka에 대해 아주 간단하게 알아보았습니다. 다음에는 조금 더 시간을 들여 제대로 알아보아야 겠습니다.

감사합니다.



### References

https://kafka.apache.org/documentation/

https://ooeunz.tistory.com/112

https://yeon-kr.tistory.com/178

실전예제

https://wecandev.tistory.com/54