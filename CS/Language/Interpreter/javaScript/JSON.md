# JSON이란?

### 정의

JSON(JavaScript Object Notation) 로 공식홈페이지에서는 아래와 같이 정의하고 있습니다.

> **JSON** (JavaScript Object Notation) is a lightweight data-interchange format. It is easy for humans to read and write. It is easy for machines to parse and generate. It is based on a subset of the JavaScript Programming Language Standard ECMA-262 3rd Edition - December 1999. JSON is a text format that is completely language independent but uses conventions that are familiar to programmers of the C-family of languages, including C, C++, C#, Java, JavaScript, Perl, Python, and many others. These properties make JSON an ideal data-interchange language.

간단하게 javascript object인 key:value 형식으로 된 가벼운 데이터 전송 format이라고 생각하면 되겠습니다.



### Why JSON?

왜 json을 사용하는지 알아보기 전에 데이터 전송이 필요한 format이 왜 필요한지 알아보도록 하겠습니다.

server에서 사용자가 가지고 있는 데이터에 접근하려면 사용자의 컴퓨터에 저장되어 있는 메모리에 접근하여 데이터를 가지고 와야 합니다. 이 경우 사용자의 입장에서는 해킹과 마찬가지이기 때문에 사용자가 가지고 있는 정보를 server에 보내는 것입니다. 그 중 javascript object를 string으로 data를 전송하는 방식을 JSON이라고 합니다.

위에 설명했듯 가벼운 데이터 전송 format이기 때문에 사용자의 데이터를 전송할 때 대부분 JSON 방식을 사용하고 있습니다. 

#### 데이터 format의 종류

1. 일반 text 데이터
2. CSV(Comma Separated Value)
3. XML(Extensible Markup Language)
4. JSON(JavaScript Object Notation) 등이 존재합니다.






### Object란?

간단하게 javascript에서의 object란 타입에 상관없이 여러가지 값들을 담을 수 있는 변수입니다.











### Reference

https://www.json.org/json-en.html