[Windows] windows에서 python 설치하기

> 개인적으로 사용하던 노트북 말고 회사 노트북에 python을 설치해보려고 합니다. mac과는 방식이 조금 달라 설치와 환경설정에서 겪었던 문제들을 정리해 보겠습니다.

### mac에서 python 설치하기

> [[Mac] python 설치하기](https://jjam89.tistory.com/228)

# Python

## 환경

저는 `vsCode`와 `git bash`를 사용해서 `python` 을 사용할 예정입니다.

따라서 위와 관련된 환경 설정에 대해 알아보겠습니다.



## 설치

아래 주소에 python 홈페이지에서 원하시는 버전을 다운받으시면 됩니다.

https://www.python.org/downloads/

설치가 완료되었다면 windows 검색창에 python을 검색하시면 아래와 같이 설치한 python이 뜨게 됩니다.

![image-20230116092859997](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116092859997.png)



## 설정

### git bash

windows에서 gitbash를 사용하신다면 `python` 을 입력해서 사용하려면 몇가지 설정이 필요합니다.

#### winpty

`winpty`는 windows 기반 shell과의 통신연결을 위한 interface를 제공하는 패키지입니다. 이 패키지를 사용해서 python을 실행시켜 보겠습니다.

#### error

아래의 stackoverflow를 보신다면 `winpty python.exe` command를 사용하라고 하지만 막상 실행해보면 아래와 같은 오류들이 나옵니다.

https://stackoverflow.com/questions/32597209/python-not-working-in-the-command-line-of-git-bash

- `cannot start ...` error

![image-20230116090927835](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116090927835.png)

해당 오류는 windows 설정 -> app -> 앱 실행 별칭 화면에서 앱 설치 관리자를 꺼줍니다.

![image-20230116090905960](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116090905960.png)

- `Not fount in PATH` error

  위의 설정을 마쳤다면 아래의 이미지와 같이 python path를 설정하지 못했다고 나옵니다. 되시는분도 있겠고 저처럼 안되는 사람들도 있으니 아래의 오류가 나온다면 pyhon.exe가 어디에 설치되어 있는지 찾아봅니다. 

![image-20230116092736552](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116092736552.png)

저는 ` C:/Users/admin/AppData/Local/Programs/Python/Python311/python.exe`의 경로에 설치되어 있군요.

```bash
$ winpty C:/Users/admin/AppData/Local/Programs/Python/Python311/python.exe
```

다시 `winpty C:/Users/admin/AppData/Local/Programs/Python/Python311/python.exe` command로 실행시켜 봅니다.

![image-20230116092758838](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116092758838.png)

위와 같이 잘 실행되는 것을 볼 수 있습니다. 종료를 원하시면 `quit()` 혹은 `ctrl + z`를 누르시면 됩니다.

하지만 매번 저렇게 긴 명령어를 실행시키기 힘드니 `.bash_profile` 에 `alias`를 추가합니다.

```bash
$ echo "alias python='winpty C:/Users/admin/AppData/Local/Programs/Python/Python311/python.exe'" >> ~/.bash_profile
```

gitbash에서 `echo "alias python='winpty C:/Users/admin/AppData/Local/Programs/Python/Python311/python.exe'" >> ~/.bash_profile`로 `~/.bash_profile`에 `python`이라는 alias로 추가합니다.

```bash
$ source ~/.bash_profile
```

이후 `source ~/.bash_profile`를 사용해 bash_profile을 다시 읽은 후 python command를 사용해 봅니다.

![image-20230116094759819](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116094759819.png)

이렇게 gitbash에서의 설정을 마칩니다.



### vsCode

extention에서 python 설치

![image-20230116102556621](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116102556621.png)

python으로  언어 설정

![image-20230116102405489](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116102405489.png) 

python 버전 설정

![image-20230116102344288](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116102344288.png) 

**Terminal 사용시**

git bash로 terminal을 실행한 후 

![image-20230116102743353](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116102743353.png)

test할 python 파일을 실행시키면 됩니다.

![image-20230116103557660](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116103557660.png)

**가상환경 만들기**

```bash
python -m venv .venv

# windows
source .venv/Scripts/activate

# mac
source .venv/bin/activate
```



**라이브러리 설치하기**

```bash
python -m pip install matplotlib
```



**vsCode의 default shell을 gitbash로 설정하기**

![image-20230116103402154](https://raw.githubusercontent.com/KrGil/TIL/b5ac2a1a9635ec5e64eb679b8c23000d99123033/CS/Language/Interpreter/python/windows_python.assets/image-20230116103402154.png)



긴 글 읽느라 고생하셨습니다. 오늘도 즐거운 프로그래밍 되시길 바랍니다.



### References

https://wikidocs.net/8

https://stackoverflow.com/questions/32597209/python-not-working-in-the-command-line-of-git-bash
