# [Mac] python 설치하기

> 요즘 러시아와 우크라이나 관련 일이 많이 터지는 듯 합니다.
>
> 관련하여 도움이 될 순 없을까... 할 적에 개발로서 도움이 될 수 있는 좋은 기회를 가지게 되었습니다.
>
> 그런데 해당 프로젝트가 python으로 진행이 되더군요.
>
> python은 예전에 짧게 사용해 보긴 했지만... 잘 모르겠더군요. 그래도 조금이나마 도움이 될 수 있도록 개인 시간을 조금 투자하기로 했습니다.  
>
> 크롤링 기술이 대부분이었는데 해당 라이브러리 사용에 앞서 python 환경 설정부터 차근차근 해보았습니다.

# List

> Windows에서 python 설치하기
>
> [[Windows] python 설치하기](https://jjam89.tistory.com/268)

1. Homebrew 설치
2. pyenv 설치
3. pyenv-virtualenv 설치
4. request 설치
5. Error

# Install

> mac에서 python 설치의 경우 하단의 링크를 참고했습니다.
>
> 해당 링크의 글을 자세히 읽어보길 추천합니다.(python 설치시 해야할 것과 하지말아야 할 것을 알려줍니다.)
>
> https://opensource.com/article/19/5/python-3-default-mac

- python은 python2와 python3으로 이루어져 있습니다.
- mac은 python2를 기본으로 사용합니다(기존 python2로 짜놓은 소프트웨어들 때문인 듯 합니다.)
- mac의 `default python`의 설정은 건들이지 않는것이 좋습니다.
- 따라서 `pyenv`를 사용하여 안전하게 `default python`을 손대지 않고 특정 버전의 python을 쓸 수 있습니다.



## Homebrew 설치

- 아래의 링크를 참고해 주세요.

  [[Mac] Homebrew 설치하기](https://jjam89.tistory.com/212)

## pyenv 설치

Homebrew를 활용하여 아래 명령어로 `pyenv`를 설치합니다.

```
brew install pyenv
```

설치가 완료되었다면 `pyenv` command를 사용해 봅니다.

### Help

Help `-h` 명령어를 최대한 활용해 봅니다.

```
pyenv -h
pyenv install -h
```

![image-20220308230256782](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308230256782.png)

![image-20220308230453715](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308230453715.png)

`pyenv install -l`을 사용하면 설치할 수 있는 python 버전들이 나올 듯 하네요.

### List

```
pyenv install -l
```

너무 많아 이미지는 생략하도록 하겠습니다.

****`주의할 점`****

- Mac m1을 사용하시눈 분이시라면 3.9.1 이상부터 설치가 됩니다.
- 따라서 3.9.1 이전 버전인 3.7.x, 3.8.x 등은 설치 시 오류가 납니다.
- 하단의 `Error`를 참고해 주세요.

```
pyenv install 3.9.4
```

python 3.9.4 버전을 설치해 줍니다.(그냥 3.9.4가 설치해 보고 싶었습니다.)

![image-20220308211850333](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308211850333.png)

### global 설정

```
pyenv global 3.9.4
```

python 3.9.4 버전을 global하게 설정합니다.

![image-20220308211909864](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308211909864.png)



### .zshrc 설정

네... 이 로직의 경우 저도 잘 이해가 안가네요. 참고한 사이트의 내용입니다.

![image-20220308231413352](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308231413352.png)

```
echo -e 'if command -v pyenv 1>/dev/null 2>&1; then\n  eval "$(pyenv init -)"\nfi' >> ~/.zshrc
```

 `vi ~/.zshrc`로 위의 command가 잘 적용되어있는지 확인합니다.

![image-20220308212122617](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308212122617.png)

`vi ~/.zshrc`에서 아래 line들을 직접 추가하셔도 됩니다.

```
if command -v pyenv 1>/dev/null 2>&1; then
  eval "$(pyenv init -)"
fi
```

#### 추가

상단에 `PYENV_ROOT` 를 추가해 줍니다. 해당 경로를 설치해 주지 않으면 `pyenv globl`이나 `pyenv local` 명령으로 버전을 설정해 줘도 `which python ` 명령어 입력 시 버전이 바뀌지 않더군요!!

```
export PYENV_ROOT="$HOME/.pyenv/shims"
export PATH="$PYENV_ROOT:$PATH"
export PIPENV_PYTHON="$PYENV_ROOT/python"
```





### pip3 version 확인

python 관리 툴인 pip의 버전을 확인해 봅니다.

```
pip3 -V
```

![image-20220308212913992](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308212913992.png)





## pyenv-virtualenv 설치

`pyenv`를 설치했다면 Hombrew를 사용하여 `pyenv-virtualenv` 를 설치합니다.

`pyenv-virtualenv`를 활용하여 특정한 공간(가상공간)에서 특정한 python버전을 사용할 수 있는 환경을 설정할 수 있습니다.

```
brew install pyenv-virtualenv
```

![image-20220308213424007](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308213424007.png)



### 가상환경 생성

`pyenv virtualenv `로 가상환경 생성합니다.

기존에 `pyenv`를 사용하여 설치한 python 3.9.4버전을 활용하여 python 3.9.4 버전이 적용되는 가상환경을 생성합니다.

```bash
// pyenv virtualenv <python version> <virtualenv name>

pyenv virtualenv 3.9.4 crawlingTest
```

![image-20220308215006254](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308215006254.png)



### 특정 디렉토리에 적용

local 명령어로 특정 디렉토리(폴더)에 특정 python 가상 환경(env)를 지정합니다.

test 폴더에 가상환경 test1(env)을 지정합니다.

```bash
// cd 명령어로 적용할 디렉토리로 이동합니다.
// cd test 
pyenv local test1
```



위의 명령어가 실행되면 해당 디렉토리에 `.python-verion`파일이 생성됩니다.

`.python-version`에 설정된 `env`가 자동으로 지정됩니다. (추후 `activate` 명령어를 통해 지정된 env를 활성화 시킬 수 있습니다.) 

![image-20220308215248302](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308215248302.png)

### python 버전 확인

현재 설치 되어있는 env들과 현재 지정된 env를  확인할 수 있습니다.

```
pyenv virtualenvs
```

![image-20220308215619886](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308215619886.png)



## 가상환경 실행

```
pyenv activate
```

`.python-version`에 설정된 가상환경 env를 활성화 시킵니다.



```
pyenv deactivate
```

가상환경을 비활성화 시킵니다.



### Flow

1. `virtualenv`로 가상환경(env)를 생성합니다.
2. `local`로 특정 디렉토리에 적용시킬 가상환경(env)을 지정합니다.
3. `activate`로 지정된 가상환경(env)를 활셩화합니다.
4. `deactivate`로 활성화된 가상환경(env)를 비활성화 시킵니다.

# requsets 설치

사용할 가상환경을 설정했다면 아래의 명령어로 `request`를 설치합니다. (.python-version이 존재하는 디렉토리 또는 그 하단에서)

`request`는 python을 활용한 크롤링을 도와줄 라이브러리입니다.

```
pip3 install requests
```

![image-20220308220001539](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308220001539.png)

 이미지 하단에 warning이 떠 있습니다. 새로우 버전이 있나보군요. 설치해 줍니다.

```
/opt/homebrew/opt/python@3.9/bin/python3.9 -m pip install --upgrade pip
```

잘 설치되었는지 확인해 봅니다.

vsCode를 사용하여 request를 import 해 보았습니다. 잘 적용되는군요.

![image-20220308233153127](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308233153127.png)



### Error

> BUILD FAILED (OS X 12.1 using python-build 20180424)

위와 관련된 오류가 뜬다면 본인의 mac이 intel인지 m1인지 확인해 주세요.

mac m1은 python 3.9.1 이상부터 지원된다고 하네요.(3.9.0도 설치가 안되네요.)

https://stackoverflow.com/questions/65457674/unexpected-output-of-arch-on-osx-using-mac-m1-installing-elastic-beans

![image-20220308211721254](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Interpreter/python/mac_python.assets/image-20220308211721254.png)



긴 글 읽느라 고생하셨습니다. 다음에는 vscode에서 크롤링한 내용을 올리도록 하겠습니다.



### References

https://opensource.com/article/19/5/python-3-default-mac

https://velog.io/@ifthenelse/pyenv-virtualenv-%EC%84%A4%EC%B9%98-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0

오류

https://www.codeit.kr/community/threads/25318

https://stackoverflow.com/questions/65457674/unexpected-output-of-arch-on-osx-using-mac-m1-installing-elastic-beans