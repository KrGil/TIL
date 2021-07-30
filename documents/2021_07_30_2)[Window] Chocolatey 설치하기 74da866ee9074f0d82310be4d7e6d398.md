# [Window] Chocolatey 설치하기

# Chocolatey란?

- Package를 설치/관리 해주는 툴.

> mac → homebrew
ubunto → apt-get
centOS → yum

**window → chocolatey**

mac의 homebrew를 매번 사용했었는데 다른 환경에서도 비슷한 기능을 하는 툴들이 존재하네요.

가장 먼저 이것을 설치했어야 하지 않나 싶습니다.

> 공식 홈페이지

[https://chocolatey.org/](https://chocolatey.org/)

[https://chocolatey.org/install](https://chocolatey.org/install)

> 설치방법

1. Windows Powershell을 관리자 권한으로 실행.
2. 아래 코드 복붙 후 엔터.

```jsx
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
```

> 설치 후 확인

- ~~terminal 실행~~ cmd창 실행
- 아래 코드 실행으로 설치 되었는지 확인

```jsx
$ choco -v
```
![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_30_2/Untitled.png?raw=true)

- 위의 이미지와 비슷하게 나오면 설치가 완료된 것입니다.

> 명령어

[https://docs.chocolatey.org/en-us/choco/commands/](https://docs.chocolatey.org/en-us/choco/commands/)

# Reference

---

[https://www.youtube.com/watch?v=FYkn9KOfkx0&list=PLPtc9qD1979DG675XufGs0-gBeb2mrona&index=1](https://www.youtube.com/watch?v=FYkn9KOfkx0&list=PLPtc9qD1979DG675XufGs0-gBeb2mrona&index=1)

[https://dejavuqa.tistory.com/209](https://dejavuqa.tistory.com/209)

[https://twofootdog.tistory.com/31](https://twofootdog.tistory.com/31)
