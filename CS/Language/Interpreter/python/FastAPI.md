# [python] FastAPI 사용하여 구글 크롤링하기[1]_설치부터 uvicorn실행까지

> fastAPi 프레임 워크를 사용하여 python으로 기본적인 구글 검색 결과를 크롤링 하는 프로그램을 구현해 보았습니다.
>
> 프로그램을 구현하면서 했던 삽질(?)들과 느꼈던 것들을 정리할 겸 작성해 보도록 하겠습니다.
>
> python의 경우 초급수준(for문 정도 작성)인 상태였으며 fastAPI 처음사용(시작하는날 처음 들었습니다.)해 보았습니다.

# 목차

> a. fastAPI 기본 개념
>
> b. 실행 전 준비
>
> ​	1. python 가상환경
>
> ​	2. library 설치
>
> c. uvicorn 실행
>
> 	1. main.py 생성
> 	1. 라이브 서버 실행

[gitHub](https://github.com/KrGil/google_crawler)을 통해 소스 코드를 확인할 수 있습니다.

# a. 기본 개념

## FastAPI

![logo-teal](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/logo-teal.png)

FastAPI is a modern, fast (high-performance), web framework for building APIs with Python 3.7+ based on standard Python type hints.

웹 프레임워크라는군요. Spring과 같은 프레임워크라고 이해했습니다.  현대적이고 빠르다는 장점을 가지고 있다는군요.



## Requirements

Python 3.7+

FastAPI stands on the shoulders of giants:

- [Starlette](https://www.starlette.io/) for the web parts. -- ASGI framework(Asynchronous Server Gateway Interface)
- [Pydantic](https://pydantic-docs.helpmanual.io/) for the data parts. -- parsing library.

python 3.7 이상으로 지원하는군요. 저는 `python 3.9.x` 버전으로 만들어볼 예정이라 잘 적용될 듯 합니다.

`Starlette`과 `Pydantic`이라는 생소한 용어가 나오는군요.

저는 개념들이 생소하면서 좀 어려워 제 나름대로 정리하고 받아들였습니다. 잘못 작성되었다면 언제든지 댓글 부탁드립니다.



## Stalette

>  `Starlette`은 `ASGI framework`  라고 합니다.

우선 `ASGI`는 `web server, framework, application` 을 연결시켜주는 표준 api 이고 이걸 구현한 framework가 `Stalette` 이라고 받아들였습니다.

`ASGI`는 `WSGI` 가 있는데... 세부적인 것들은 제가 이해하지 못하기도 했고 단번에 받아들이기 힘든 개념들이 많아서 넘어가도록 하겠습니다.

## Pydantic

> `Python`의 `type hint`를 제공하는 library 입니다.

python에는 java와 다르게 type을 지정하지 않아도 변수가 선언됩니다

```python
ads = "123"
ads = 123
asd = [123]    
```

위와 같이요. java에서는 compile 오류가 나지만 python은 저렇게 선언이 가능합니다. 만약 request에서 String이 올것이라 생각하고 로직을 구현했는데 Integer 타입의 변수가 오게되면 곤란하겠죠.

그래서 아래와 같이 특정한 타입만 들어올 수 있게 강제하는 역할을 해줍니다.

```python
class RequestParam(BaseModel):
    word: str
    limitPage: int

@router.post('/')
def save(request: RequestParam):
    search = request.word
    limit = request.limitPage

```



# b. 준비 

## 1. python 가상환경

이제 기본적인 개념을 훑어 보았으니 python의 기본 설정을 해 보겠습니다.(python 설치는 skip 하겠습니다.)

> python은 가상환경을 사용해서 작업을 할 수 있습니다. 운영체제의 기본 python에 library들을 일일이 설치하지 않고 특정 프로젝트 전용 가상환경을 만들어 그 프로젝트에 특화된 환경을 만들어 줄 수 있습니다. 물론 공통으로 사용할 수 도 있고요.

### 가상환경 생성

```shell
$ cd <프로젝트 디렉터리>
$ python -m venv <환경변수 명>
```

저는 ` python -m venv .venv`로 생성했습니다.

![image-20221117162807221](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117162807221.png)

코드를 확인했을 때 위의 이미지와 같이 `.venv` 파일이 생성되는 것을 확인할 수 있습니다.

### 가상환경 실행

```shell
## windows
$ source ./.venv/Scripts/activate

## mac
$ source ./.venv/bin/activate
(.venv) $
```

windows와 mac의 경로가 조금 다르니 확인 바랍니다.

![image-20221117163309089](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117163309089.png)

### 가상환경 확인

```shell
(.venv) $ which python
/Users/dale/temp/my-project/.venv/bin/python
```

```shell
(.venv) $ python -V
Python 3.7.6
```

### 가상환경 비활성

```shell
(.venv) $ deactivate
$
```



## 2. library 설치

FastAPI의 기본적인 tutorial 을 통해 uvicorn 실행까지 따라해 보겠습니다.

https://fastapi.tiangolo.com/ko/tutorial/ 

### fastapi 

```shell
$ pip install fastapi
```

### ![image-20221117164855555](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117164855555.png)

### 2. uvicorn 

```shell
$ pip install "uvicorn[standard]"
```



# c. 실행

## main.py 생성

설치를 했다면 실행을 시켜 보겠습니다. 우선 기본적인 `main.py` 파일을 작성해 보겠습니다.

https://fastapi.tiangolo.com/ko/tutorial/first-steps/

작성 툴은 무엇을 쓰셔도 상관없습니다. 저는 Visual Studio Code와 Fleet, vim을 번갈아가며 사용했습니다.

```python
from fastapi import FastAPI

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}
```

![image-20221117165143001](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117165143001.png)

위와같이 작성한 후 `main.py`로 저장합니다.

![image-20221117165243301](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117165243301.png)

잘 저장되어있군요.



## 라이브 서버 실행
```shell
$ uvicorn main:app --reload
```

### ERROR

[WinError 10013] An attempt was made to access a socket in a way forbidden by its access permissions

위와 같은 오류가 나면 기존의 포트가 사용되고 있는지 확인해 봅니다. 기본 포트는 8000으로 되어 있으니 8000이 사용되는지 확인해 보시면 되겠군요.

![image-20221117170801050](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117170801050.png)

실행하면 위와 같이 어떤 url에서 어떤 port에 실행되는지 나옵니다. 

![image-20221117170856539](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117170856539.png)

chrome에서 실행하면 이렇게 `Hello World`가 출력되는것을 확인할 수 있습니다.

## docs

fastAPI에서 가장 매력적인 기능 중 하나라고 느껴지는 swagger 기본 제공 기능입니다.

`http://127.0.0.1:8000/docs`를 입력하게되면  아래와 같이 자동으로 swagger 페이지를 지원해 줍니다.

![image-20221117171123918](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117171123918.png)

이렇게 기본적인 python 가상환경설정부터 fastAPI를 활용한 uvicorn 서버 올리기까지 해 보았습니다.

다음편에서는 chrome에서 검색 결과를 crawling 하는 것을 포스팅 하도록 하겠습니다.

긴 글 읽느라 고생많으셨습니다. 감사합니다. 



### vscode 사용 시 가상환경 설정

실행할때 하단의 `python` 옆의 버전을 클릭합니다. 저는 `3.9.4 64-bit`를 사용하고 있군요.

![image-20221117170108731](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117170108731.png)

위에서 생성한 가상환경의 경로를 선택해 vscode에서 우리가 만든 가상환경을 사용하게 설정합니다. 

![image-20221117170232187](https://raw.githubusercontent.com/KrGil/TIL/38d8b493700b7b05e6473b4358c6cd9869580806/CS/Language/Interpreter/python/FastAPI.assets/image-20221117170232187.png)



### Reference

fastAPI

https://fastapi.tiangolo.com/

https://velog.io/@crosstar1228/BackendFastAPI-%EC%9E%85%EB%AC%B8-1-Uvicorn-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-%EA%B0%84%EB%8B%A8%ED%95%9C-%EC%9B%B9-%EC%84%9C%EB%B2%84-%EA%B5%AC%ED%98%84

pydantic

https://ks1171-park.tistory.com/83#:~:text=pydantic%EC%9D%80%20vaildation%20library%EA%B0%80,%EC%A0%9C%EC%95%BD%20%EC%A1%B0%EA%B1%B4%EC%9D%84%20%EB%B3%B4%EC%9E%A5%ED%95%A9%EB%8B%88%EB%8B%A4.

ASGI

https://www.itworld.co.kr/news/245062



python 가상환경

https://www.daleseo.com/python-venv/