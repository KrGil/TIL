# [Language] 기본형(Primitive Type)과 참조형(Reference Type)

> 프로그래밍 언어의 가장 기본적인 개념 중 하나인 변수의 기본형(Primitive type)과 참조형(Reference type)입니다. 
>
> 개발경력 2년차(1년 반)인데 이것도 모르냐? 라고 할 수 있습니다만... 몇일 전 `기본형과 참조형의 차이`에 대한 질문을 받고 버벅거리던 제 자신을 되돌아보고 뭔가 알긴 아는데 제대로 알지 못하니 메끄럽게 설명을 못하는구나 싶더군요. 그래서 질문을 받았을 때 간략하게 차근차근 순서대로 설명할 수 있도록 기본기를 다시 다지기 위한 용도로 글을 정리해 보았습니다.

# 기본형 타입(Primitive Type)

## 1. 종류

java에서는 총 8가지의 primitive  type이 존재합니다.

|        | type    | memory | default value | data expression range                                        |
| ------ | ------- | ------ | ------------- | ------------------------------------------------------------ |
| 논리형 | boolean | 1byte  | false         | true, false                                                  |
| 정수형 | byte    | 1byte  | 0             | -128 ~ 127                                                   |
|        | short   | 2byte  | 0             | -32,678 ~ 32,767                                             |
|        | int     | 4byte  | 0             | -2,147,483,648 ~ 2,147,483,647(-21억 ~ 21억)                 |
|        | long    | 8byte  | 0L            | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807(-100경 ~ 100경) |
| 실수형 | float   | 4byte  | 0.0F          | 1.4E-45 ~ 3.4028235E38                                       |
|        | double  | 8byte  | 0.0           | 4.9E-324 ~ 1.7976931348623157E308                            |
| 문자형 | char    | 2byte  | '\u0000'      | 0 ~ 65,535                                                   |



## 2. 특징

1. Null이 없습니다.(위의 표에서 볼 수 있듯 `Null` 대신 기본값이 존재 합니다.)
2. Stack 메모리에 저장됩니다.(메모리에 대해 글 하단에 간략하게 작성했습니다.)

# 참조형 타입(Reference Type)

## 1. 종류

기본형 타입을 제외한 타입들이 모두 참조형입니다. (주로 New로 선언하는 Type들)

자료구조들이 모두 여기에 속합니다.(`배열, 리스트, 맵, 트리, 그래프, 스택 ...` 등등)



## 2. 특징

1. Null이 존재합니다.
2. Heap 메모리에 저장됩니다.
3. NPE(NullPointException)을 발생시키는 원인이 됩니다.



### 참고

Stack - OS에서 직접 할당, 속도 빠름. - 컴파일 시 할당.

Heap - 사용자가 관리(java의 경우 GC가 관리. 속도가 느림.) - 런타임 시 할당.

Stack overflow - Stack이 Heap 영역을 침범했을 경우.

Heap overflow - Heap이 Stack 영역을 침범했을 경우 



### Reference

https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

https://velog.io/@gillog/%EC%9B%90%EC%8B%9C%ED%83%80%EC%9E%85-%EC%B0%B8%EC%A1%B0%ED%83%80%EC%9E%85Primitive-Type-Reference-Type

https://gbsb.tistory.com/6