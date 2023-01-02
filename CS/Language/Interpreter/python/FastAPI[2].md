# [python] FastAPI 사용하여 구글 크롤링하기[2]_request사용해서 검색결과 가져오기

> fastAPI 시리즈 2부입니다. 이번 편에서는 python의 request를 사용하여 구글 검색 결과를 가져오는 코드를 작성해 보도록 하겠습니다.(~~python은 초보라 코드가 개판일 수 있어요 ㅠ~~)  
>
> [1편 [python] FastAPI 사용하여 구글 크롤링하기[1]_(설치부터 uvicorn실행까지)](https://jjam89.tistory.com/257)

# 목차

> a. 설치
>
> 1. requests
> 2. beutifulsoup4
> 3. pandas
>
> b. 구현

# a. 설치

> 검색 결과를 크롤링하기 전에 python의 `requests`, `beutifulsoup4`, `pandas`라이브러리들을 사용할 것입니다.

```shell
$ pip install requests
```

```shell
$ pip install beautifulsoup4
```

```shell
$ pip install pandas
```

![image-20221118105853968](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Interpreter\python\FastAPI[2].assets\image-20221118105853968.png)

위의 명령어로 각각의 library들을 설치해 줍니다.



# b. 구현

> 앞서 1편에서 fastAPI의 docs를 활용하여 swagger로 간편하게 구현한 API를 확인할 수 있었습니다.
>
> docs를 활용하여 테스트 및 구현해 보겠습니다. 필요하시다면 [1편](https://jjam89.tistory.com/257)을 참고해주세요.

## 설정

1. 이전에 세팅한 python 가상환경 실행

```shell
$ source .venv/Scripts/activate
```

2. `uvicorn` 실행

```shell
$ uvicorn main:app --reload
```

*`--reload` 명령으로 live server를 실행합니다. 코드 변경시 자동으로 server에 반영해 주는 옵션입니다*

3. `/docs` 접속

![image-20221118163129385](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Interpreter\python\FastAPI[2].assets\image-20221118163129385.png)

잘 연결되었네요! 이제 변수를 받아보겠습니다.

## get()

main.py를 열어보면 아래와 같이 작성되어 있을 탠데요

```python
from fastapi import FastAPI

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}

```

fastAPI의 document를 참고해서 아래와 같이 구현해 봅니다.

https://fastapi.tiangolo.com/ko/tutorial/path-params/

```python
from fastapi import FastAPI

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}

// 추가
@app.get("/msg")
async def root(msg: str):
    return {"message": msg}

```

이제 `docs` 화면을 가게 되면 아래와 같이 잘 출력되는 것을 확인할 수 있습니다. 물론 직접 url에 특정 문자를 쳐서 확인해 보셔도 됩니다.

![image-20221118164459222](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Interpreter\python\FastAPI[2].assets\image-20221118164459222.png)

이제 페이지에서 `메시지` 라고 전송해 보겠습니다.

![image-20221118165503463](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Interpreter\python\FastAPI[2].assets\image-20221118165503463.png)

아래와 같이 잘 받아지는것을 확인할 수 있습니다.

![image-20221118165451188](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Interpreter\python\FastAPI[2].assets\image-20221118165451188.png)

심지어 uvicorn으로 실시간으로 값이 잘 전달되는지 확인할 수 있습니다.(gitBash는 한글이 깨지는군요. 참고로 vsCode로 terminal을 실행시키면 따로 설정을 하지 않아도 한글로 잘 출력됩니다.)

![image-20221118165556507](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Interpreter\python\FastAPI[2].assets\image-20221118165556507.png)

이제 get()으로 받은 값을 검색하고 결과를 크롤링 해 보겠습니다.

requests.get()을 활용해서 구글의 html 파일을 가지고 와 보도록 하겠습니다.

```python
@app.get("/{search}")
def root(search: str):
    res = requests.get("https://google.com/?"+search)
    soup = bs(res.text, "html.parser")
    print(soup)
    return {"search": soup}
```

위의 코드로 실행시키니 무언가 막 뜨면서 `stackoverflow`가 발생해 버립니다. 

슬쩍 구글링을 통해 `headers`와 `cookie`를 넘겨주면 된다는 것을 찾았습니다. 

1. headers

headers 부분에 user-agent를 넣어 요청자가 누구인지 알려 줍니다.(알려주지 않으면 로봇으로 생각해 차단당한다네요.)

![image-20221118174901295](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Interpreter\python\FastAPI[2].assets\image-20221118174901295.png)

`header`에는 직접 google에서 검색 후 개발자도구(`f12`)를 통해 `Network` -> `Headers`에서 볼 수 있습니다.

2. cookie

[블로그](https://velog.io/@enjoywave/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EA%B5%AC%EA%B8%80-%EA%B2%80%EC%83%89-%EB%89%B4%EC%8A%A4-%ED%81%AC%EB%A1%A4%EB%A7%81-selinium-%EC%82%AC%EC%9A%A9-%EC%95%88%ED%95%A8)의 글을 참고하면 구글에서 쿠키 수집에 동의하냐는 페이지를 보내기 때문에 동의한다는 정보를 쿠키에 담아서 전송해야 한다고 합니다.

> 구글에서 쿠키 수집에 동의 하냐는 페이지를 보내기 때문입니다. 따라서 저는 쿠키 정보에 동의한다는 정보를 쿠키에 담아서 전송할 겁니다. `cookie = {'CONSENT' : 'YES'}` 라는 쿠키 데이터를 만들고 request get에 인자로 넣어줍니다.
>
> ```python
> search = '부산 관광지'
> ```

~~*위의 블로그 링크에서 글을 가지고 왔습니다 문제 시 삭제하도록 하겠습니다*~~

```python
@app.get("/{search}")
def root(search: str):
    header = {"user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36"}
    cookie = {"CONSENT": "YES"}
    url = "https://www.google.com/search?"+search

    res = requests.get(url, headers = header, cookies = cookie)
    soup = bs(res.text, "html.parser")
    print(soup)
    return {"search": soup}
```

`header`와 `cookie` 정보를 담아주고 요청을 보내봅니다.



`param` 으로 조금 더 많은 정보들을 담아서 넘겨보도록 하겠습니다.





![image-20221118175717869](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Interpreter\python\FastAPI[2].assets\image-20221118175717869.png)



## Requests





### References

https://velog.io/@enjoywave/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EA%B5%AC%EA%B8%80-%EA%B2%80%EC%83%89-%EB%89%B4%EC%8A%A4-%ED%81%AC%EB%A1%A4%EB%A7%81-selinium-%EC%82%AC%EC%9A%A9-%EC%95%88%ED%95%A8







