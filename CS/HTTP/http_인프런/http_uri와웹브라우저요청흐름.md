# [HTTP] URI와 웹 브라우저 요청 흐름



### URI (Uniform Resource Idenfier)

> Unifor: 리소스를 식별하는 통일한 박식
>
> Resource: 지원, URI로 식별할 수 있는 모든 것(제한 없음)
>
> Identifier: 다른 항목과 구분하는데 필요한 정보

#### URL

- Locator: 리소스가 있는 위치를 지정
-    foo  :/  /xxx.xxx:8080 /over/there ? name=jason # nose ...
- scheme / authority        / path             / query       / fragment

scheme - 주로 프로토콜 사용.

protocol - 어떤 방식으로 자원에 접근할 것인가 하는 약속 및 규칙

​	ex) http, https, ftp 등

http는 80, https 443 포트를 주로 사용.

- scheme://[userInfo@] host [:port] [/path] [?query] [#fragment]

fragment - page 내부의 북마크에 사용.



#### URN

- Name: 리소스에 이름을 부여
- ​    urn    : example : animal : json : nose
- scheme / / path    





### 웹 브라우저 요청 흐름

![image-20211214082957833](/home/eisen/Documents/GitHub/TIL/CS/HTTP/http_인프런/http_uri와웹브라우저요청흐름.assets/image-20211214082957833.png)



#### http 요청 메시지

```
GET /search?q=hello&hl=ko HTTP/1.1
Host: www.google.com
```



요청 메시지 -> socket 라이브러리를 통해 연결(가상연결 syn, ack) -> 패킷 생성 -> 전달





### References

https://www.ietf.org/rfc/rfc3985.txt