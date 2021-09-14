# HTTP_2

# HTTP의 구조

### 요청과 응답(Requset / Response)

- 클라이언트와 서버의 모든 통신이 요청과 응답으로 이루어져 있습니다.

### Stateless / Connectionless

- 요청과 응답은 서로 연결되어 있지 않아 서로의 데이터들을 알지 못합니다.(서로 독립적)
- 즉, 요청을 보내고 잠시 후 다시 요청을 보낼 때 전에 보냈던 요청/응답에 대해 알지 못한다는 뜻입니다.
- 이로 인해 데이터를 공유하기 위해 쿠키나 세션 등을 사용합니다. 

https://victorydntmd.tistory.com/286

# Requset 구조

- Line
- Header
- Body

### Line

 ``` GET /search HTTP/1.1 ```

- Method(type) : GET, POST, PUT, DELETE 등
- Target(URL) : requset가 전송되는 url
- Version(HTTP) : 1.1, 2.0 등

### Header

 ```
 Accept: */*
 Accept-Encoding: gzip, deflate
 Connection: keep-alive
 Content-Type: application/json
 Content-Length: 257
 Host: google.com
 User-Agent: HTTPie/0.9.3
 ```

- request에 대한 추가 정보(metadata)를 담고 있습니다.
- Accept : 받을 수 있는 response 타입
- Connection :  요청이 끝난 후 클라이언트와 서버가 계속해서 네트워크 커넥션을 유지 할 것인지 아니면 끊을 것인지에 대한 정보를 담고 있습니다.
- Content-Type : 해당 요청이 보내는 메시지 타입에 대한 정보입니다. (application/json 혹은 text/plain)
- Host : 요청이 전송되는 target의 host url.
- User-Agent : 웹브라우저에 대한 정보

### Body

```
{
    "imp_uid": "imp_1234567890",
    "merchant_uid": "order_id_8237352",
    "status": "paid"
}
```

클라이언트가 해당 요청으로 보내고자 하는 데이터에 대한 정보가 담겨 있습니다.

Post 방식일 경우 넘겨주어야 하는 데이터가 존재하기 때문에 body가 있지만,

Get 방식의 경우 넘겨줄 데이터가 존재하지 않기 때문에 body가 대부분 없습니다.(쿼리 스트링으로 line 부분에 정보가 담겨 있습니다.)



# HTTPS

### Words

- SSL
- Google



서버에서부터 브라우저로 전송되는 정보가 암호화되지 않습니다.

ssl(보안 소켓 레이어) 인증서는 사용자가 사이트에 제공하는 정보를 암호화합니다.  

검색엔진 최적화에 혜택을 봅니다.(SEO)



# HTTP/1.0과 HTTP/1.1의 차이

### HTTP/1.0

``` GET uri HTTP/1.0 ```

### HTTP/1.1

- 1.1에서는 요청을 보낼 시 아래와 같이 HOST 주소를 함께 보내야 합니다.

``` 
$ GET uri HTTP/1.1
HOST: uri
```









# Reference

https://velog.io/@teddybearjung/HTTP-%EA%B5%AC%EC%A1%B0-%EB%B0%8F-%ED%95%B5%EC%8B%AC-%EC%9A%94%EC%86%8C





