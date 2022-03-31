# [Cookie]SameSite=lax ? 

> 지인 중 한분이 cookie에 관하여 글을 작성했습니다. 해당 글을 읽다 보니 모르는 부분이 많이 나오더군요.
>
> 그래서 그 부분에 관해 간략하게 정리해 보도록 하겠습니다.

# Cookie

쿠키란 브라우저에 데이터를 저장하기 위한 수단 중 하나로서 브라우저 -> 서버로 요청을 전송할 때 해당 요청에 대한 응답에 `Set-Cookie` 헤더가 포함되어 있으면 브라우저는 이 `Set-Cookie`에 있는 데이터를 저장하는데 이것을 cookie라고 합니다.

```
Set-Cookie: ...
```

위와 같은 형태로 Response Header에 표시되게 됩니다.

아래는 실제 개발자도구에서 확인한 모습 입니다.

![image-20220403145612628](/Users/eisen/Documents/Github/TIL/CS/HTTP/sameSite_lax.assets/image-20220403145612628.png)

쿠키는 보통 서버에서 사용자를 식별하기 위한 수단으로 사용되어지며, 이후 브라우저에서 서버로 요청을 보낼 때 Cookie 헤더의 세션 ID를 읽어 누가 보낸 요청인지 식별하는 식으로 사용됩니다.

```
				request
client ---------> server
			 <--------- (Set-Cookie : CMID ...)
				response

```

쿠키에는 여러가지 설정을 할 수 있습니다.

## 퍼스트파티, 서드파티 쿠키

쿠키에는 퍼스트파티(First-party cookies)와 서드파티(Third-party cookies)가 있습니다. 이 쿠키들은 `Set-Cookie: ... ; domain=someSite` 와 같은 `domain` 설정에 따라 나뉘어집니다.

따로 Set-Cookie에 domain 설정이 없다면 쿠키를 보낸 서버의 도메인으로 설정됩니다. 

퍼스트파티 쿠키는 현재 접속해 있는 페이지와 `같은 도메인`으로 전송되는 쿠키이며 서드파티 쿠키는 현재 접속하고있는 페이지에서 타 사이트 링크를 클릭했을 경우, 즉 `다른 도메인`으로 전송되는 쿠키들을 의미합니다.

## SameSite 쿠키

SameSite 쿠키는 보안상의 문제로 만들어 졌습니다.(CSRF-Cross Site Request Forgery을 방어하기 위한 용도)

### 정책

![image-20220403152748397](/Users/eisen/Documents/Github/TIL/CS/HTTP/sameSite_lax.assets/image-20220403152748397.png)

`None`, `Lax`, `Strict` 세가지 종류가 있습니다.

`None` : 기존의 방식과 동일힙니다. 서드 파티 쿠키가 전송됩니다.

`Lax` : 몇가지 예외적인 요청을 제외하고는 서트 파티쿠키가 전송되지 않습니다.

`Strict` : 항상 서드파티 쿠키는 전송되지 않고 퍼스트파티 쿠키만 전송됩니다.



### Lax의 예외적인 요청

위 이미지에 나와 있듯이 `"안전한" HTTP 방법을 사용하는 사이트간 최상위탐색(top-level navigation)`에서만 쿠키를 전송한다고 합니다.

"안전한" HTTP method는 `GET`을 의미하며, 사용자가 직접 주소창에 입력하는 top-level navigation에서만 서드파티 쿠키를 허용합니다.(`<iframe>` 안에서의 페이지 이동일 경우 전송되지 않습니다.)

아래는 어떨 때 쿠키들이 전송되는지 보여줍니다.(Normal은 `SameSite=None`입니다)

![image-20220403153257334](/Users/eisen/Documents/Github/TIL/CS/HTTP/sameSite_lax.assets/image-20220403153257334.png)

https://imjuno.com/2019/08/

### Reference

https://www.chromium.org/administrators/policy-list-3/cookie-legacy-samesite-policies/



# 브라우저의 SameSite

크롬의 경우 2020년 2월 4일 chrome 80 버전이 배포되면서 `SameSite`의 default 값이 `Lax`로 변경되었습니다.(기존에는 `None`으로 동작) 따라서 `SameSite`를 따로 지정해 주지 않으면 `SameSite=Lax`로 쿠키가 지정됩니다. 다른 브라우저 역시 크롬의 경우를 따라갈 듯 합니다.

### Secure

`SameSite=None`으로 사용하기 위해선 `Secure`가 지정된 쿠키여야 합니다. `Secure`쿠키는 HTTPS가 적용된 요청에만 전송되는 쿠키이며 이 말은 `SameSite=None` 으로 지정 시 `HTTP`로의 쿠키 전송은 실행되지 않는다는 뜻입니다.(현재는 chrome에서만 이렇게 사용되고 있습니다.)

> 지인 역시 chrome에서 `Secure` 쿠키로 인해 문제를 겪었습니다.
>
> 이때 신기한 것 중 하나는 쿠키의 `Domain`이 `localhost`인 경우 `Secure`쿠키여도 `HTTP` 로 쿠키 전송이 가능하다는 것이었습니다.



## Result

- Cookie에 `SameSite` 속성이 추가됨.
- `SameSite`에는 여러 종류의 정책이 있는데 기본으로 chrome에서는 기본이 `Lax`임.
- `Lax`는 "안전한" HTTP 방법을 사용하는 사이트간 최상위탐색(top-level navigation)`에서만 쿠키를 전송함.
- `GET`과 `<a>`등의 직접적인 이동 방식에서만 쿠키 전송됨.
- chrome에서 `SameSite=None`쿠키를 전송하려면 꼭 `Secure` 속성도 추가해야함.
- `localhost`에서 테스트한다면 chrome이 알아서 `HTTP`에서 테스트 되게 허용해줌.

긴 글 읽느라 고생 많으셨습니다. `References`에 작성된 글들을 읽고 개인적으로 정리해 보았습니다.

즐거운 코딩 되시길 바랍니다👍



### References

https://shanepark.tistory.com/349

https://seob.dev/posts/%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80-%EC%BF%A0%ED%82%A4%EC%99%80-SameSite-%EC%86%8D%EC%84%B1/

