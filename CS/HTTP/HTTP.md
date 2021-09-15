# HTTP 란?

HTTP(HyperText Transfer Protocol)은 웹에서 클라이언트(웹 브라우저)가 웹 서버(apache, nginx ...)와 통신하기 위한 프로토콜 중 하나입니다.

###### *현재 HTTP는 신뢰할 수 있는 연결 기반인 TCP 표준에 의존합니다.*

###### *구글의 경우*  자체적으로 개발한 QUIC(HTTP3)을 사용하며 UDP를 기반으로 합니다. 
![image-20210820095135118](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP.assets/image-20210820095135118.png)


# HTTP 1.1이란?

> 출시 이후 지금까지 가장 많이 사용되고 있는 통신 프로토콜입니다.
>
> 연결(Connection) <span style="color:orange">**하나 당 하나**</span>의 요청을 처리하도록 설계되어 있습니다.(요청과 응답이 순차적으로 처리)
>
> 이런 설계 방식으로 다수의 리소스(image, css, script)를 처리하기 위해선 요청할 리소스 개수에 비례해서 [Latency](http://www.terms.co.kr/latency.htm)가 길어지게 됩니다.(동시전송, 속도, 성능문제)

## 단점

### HOL(Head Of Line) Blocking 발생

- '연결(Connection) 하나 당 하나의 요청' 방식의 개선 방법으로 ''연결(connection) 하나 당 여려개의 요청/응답''할 수 있는 기법인 <span style="color:orange">*pipelining*</span> 시 발생합니다.

  ``` 
  | a.png |
  		  | b.png |
  		  			 | c.png |
  ```

  

- 위와 같이 순서대로 처리하지만 첫 번째 이미지의 응답 처리가 완료되기 전까지 b, c에 대한 요청은 대기하게 되는 현상입니다.(<span style="color:orange">**특정응답지연**</span>)

- <span class="red">aa</span>


### RTT(Round Trip Time) 증가

- '연결(Connection) 하나 당 하나의 요청'으로 매번 요청 별로 '연결(Connection)을 만들게 되고 TCP 상에서 동작하는 HTTP의 특성상 <span style="color:orange">*3-way Handshake*</span>가 반복적으로 일어나며, 불필요한 RTT증가와 네트워크 지연을 초래하여 성능을 지연시킵니다.

*TCP의 3-way Handshaking*


![image-20210820095918173](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP.assets/image-20210820095918173.png)



### Heavy Header

- HTTP 1.1에는 많은 메타 정보들이 저장되어 있습니다. 그리고 클라이언트가 서버로 보내는 HTTP 요청은 매 요청 때마다 <span style="color:red">**중복된 헤더 값**</span>을 전송하게 되며 서버 도메인에 관련된 쿠키 정보도 헤더에 함께 포함되어 전송됩니다. 이러한 반복 및 중복적인 헤더 전송, 쿠키 정보로 인한 무거운 헤더가 단점입니다.



# HTTP 2

HTTP1.1의 성능에 초점을 맞추어 수정한 버전입니다. latency, 네트워크, 서버 리소스 사용량 등과 같은 성능 위조로 개선했습니다.

### Multiplexed Streams

- Connection <u>*한 개로 동시에 여러 개*</u>의 메시지를 주고 받을 수 있으며 응답은 **순서에 상관없이** Stream으로 주고 받습니다. 위에 언급한 Pipelining의 개선 버전이라 보시면 될 듯 합니다.

![image-20210820105636492](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP.assets/image-20210820105633626.png)

### Stream Prioritization

- 리소스 간의 의존관계에 따른 우선 순위를 설정하여 리소스 문제를 해결합니다. (이미지파일보다 css파일이 더욱 빠르게 도착할 수 있게끔 합니다.)

### Server Push

- server는 client가 요청하지 않은 리소스들을 사전에 push를 통해 전송할 수 있습니다. 이럴 경우 client가 HTML문서를 최소한으로 요청할 수 있습니다.

![image-20210820160033779](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP.assets/image-20210820160014732.png)

### Header Compression

- Header Table과 Huffman Encoding이라는 기법을 사용하는 HPACK 압축 방식을 사용합니다.

![image-20210820160154555](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP.assets/image-20210820160154555.png)

- HTTP 1.1의 경우 클라이언트가 요청을 두번 보내면 해더 중복에 대한 처리가 전혀 업는 반면, HTTP 2의 경우 위의 이미지와 같이 중복을 처리한 후 데이터를 전송합니다.



### HTTP 1.1과 HTTP 2의 속도 차이

https://www.youtube.com/watch?v=jhqrRT4fvOA



### NAVER와 GOOGLE의 HTTP

###### *NAVER의 프로토콜(HTTP2)* 

![image-20210820160859777](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP.assets/image-20210820160859777.png)

###### *Google의 프로토콜(HTTP3/QUIC)*

![image-20210820160952321](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP.assets/image-20210820160951101.png)

# References

https://jwdeveloper.tistory.com/218

https://seokbeomkim.github.io/posts/http1-http2/

https://medium.com/@shlee1353/http1-1-vs-http2-0-%EC%B0%A8%EC%9D%B4%EC%A0%90-%EA%B0%84%EB%8B%A8%ED%9E%88-%EC%82%B4%ED%8E%B4%EB%B3%B4%EA%B8%B0-5727b7499b78

https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview

https://seokbeomkim.github.io/posts/http1-http2/
