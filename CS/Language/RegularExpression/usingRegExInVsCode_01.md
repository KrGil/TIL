# vsCode를 활용한 정규식 사용
> 프로젝트를 진행함에 있어 기존의 코드들을 형태는 비슷하지만 조금 수정해야할 일이 종종 있습니다. 이럴 때 하나씩 수정을 하다 보면 회의감이 강하게 들더군요. 이때 제 선임분 중 한분이 terminal에서의 sed 사용과 vsCode에서의 regularExpression을 사용하여 손쉽게 변경하는 방벙을 알려 주셨습니다. sed는 추후에 따로 다뤄보고 이번에는 vsCode를 활용하여 제가 실제 사용했던 방법들을 작성해 보도록 하겠습니다.

# 정규식(Regular Expression)
> 정규 표현식(正規表現式, 영어: regular expression, 간단히 regexp[1] 또는 regex, rational expression)[2][3] 또는 정규식(正規式)은 특정한 규칙을 가진 문자열의 집합을 표현하는 데 사용하는 형식 언어이다. - 위키백과
> 
>정규 표현식, 또는 정규식은 문자열에서 특정 문자 조합을 찾기 위한 패턴입니다. -MDN

저는 개인적으로 mdn의 설명이 조금 더 와닿는 듯 합니다. 조금 더 쉽게 제 식대로 말하자면 찾고 싶은 문자열을 찾게 해 주는 패턴입니다.

아래 사이트에서 조금 더 많은 정보들을 얻을 수 있습니다. 

> https://regexr.com/ 

# 사용하기
> 정규식은 대부분의 툴, 언어에서 지원을 하고 있습니다. java, javascript, eclipse, vsCode, intelliJ... 어디서든 사용할 수 있습니다. 저는 손에 익은 vsCode를 사용했습니다만 다른 툴 혹은 ide에서 직접적으로 사용하여도 무방합니다.

![img1](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/RegularExpression/usingRegExInVsCode_01.assets/Screen%20Shot%202022-07-26%20at%2011.50.26%20AM.png)

사용할 때 반드시 사진의 use Regular Expression을 클릭해 주셔야 합니다.

## 수정하기
### 예시코드
```java
participant1.put("mem_no", mem_nos.get("mem_no1"));
participant1.put("chatroom_no", roomInfo.getChatroom_no());
participant2.put("mem_no", mem_nos.get("mem_no2"));
participant2.put("chatroom_no", roomInfo.getChatroom_no());
```

### 결과코드

```java
participant.setMemNo(memNos.get("memNo1")));
participant.setChatroomNo(roomInfo.getChatroomNo()));

participant.setMemNo(memNos.get("memNo2")));
participant.setChatroomNo(roomInfo.getChatroomNo()));	
```

위의 예시코드를 가지고 정규식을 사용하여 결과 코드를 변환시켜 보겠습니다.



### 과정

vsCode와 아래의 정규식을 활용하여 다음과 같이 코드를 한번에 변환시킬 수 있습니다.

```
([a-z]*)[1-2].put\("([a-z])([a-zA-Z]*)",\s([a-zA-Z0-9.(")]*)

$1.set\U$2$3($4)
```

![image-20220726121844863](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/RegularExpression/usingRegExInVsCode_01.assets/image-20220726121844863.png)



### 설명

위에 사용된 정규식을 간략하게 풀어보겠습니다. 특정 문구 앞에는 `\`를 사용합니다. 

> (): 해당 구문 내의 문자들을 그룹처리 해 줍니다.(첫번째부터 $1, $2... 순차적으로 증가합니다.) 
>
> []: 해당 구문 내에 찾아낼 문자들을 작성합니다
>
>  - a-z: a부터 z까지 모두 찾습니다.
>  - 1-2: 1부터 2까지 모두 찾습니다.
>
> *: 앞에 나오는 조건의 문자가 0개 이상일 경우입니다.
>
> s: 화이트스페이스를 찾습니다.
>
> U: 대문자로 치환합니다.

예를 들어 `([a-z]*)`의 경우

- [a-z] : 문자열 중 a-z가 

- *: 0개 이상 포함되는 
- (  ): `grouping` 하겠다는 뜻입니다.

따라서 위의 정규식에 따르면 `example123isEasy` 중 `example`만을 조건에 만족하게 됩니다. 

그 후 그룹지정으로 찾은 문자들을 사용($1, $2)해 문자열을 수정할 수 있습니다.

$1isSimple : 그룹1번의 문자열을 앞쪽에 사용하겠다는 뜻입니다.

결국 `exampleisSimple` 이라는 문자로 변경되게 됩니다.

### Result

위의 예시는 몇줄 되지 않아 크게 와닿지 않을 듯 하지만 생각보다 상당히 활용성이 높은 정규식입니다. 원하는 문자열을 검색할 수도 있고(terminal에서 프로젝트 내부에서 찾고자 하는 문자를 정규식을 사용하여 검색할 수도 있습니다.) 수정할 수 있습니다.

익숙해 진다면 활용도 뿐만 아니라  작업 속도도 훨씬 빨라질 것입니다.

긴 글 읽느라 고생하셨습니다. 감사합니다.





### References

- lookaround(전후방탐색)

https://junstar92.tistory.com/373

https://regexr.com/

