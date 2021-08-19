# [Docker] Dockerfile 빌드 및 이미지 생성

> Preview

- **~~제가 바보라~~** 다른 글들을 봐도 Dockerfile 빌드하는 방법에 대해서 설명을 읽어도 중간중간 과정이 생략 되어 있어 알 수가 없었습니다.
- 그래서 이런저런 사이트와, 책을 참고하여 dockerfile 빌드와 이미지 생성에 대해 ~~제가~~ 알아볼수 있게 적어 보았습니다.

# 설치

> docker 설치

[https://www.docker.com/get-started](https://www.docker.com/get-started)

본인 운영체제에 맞는 버전을 다운받으시고 설치하시면 됩니다.

# Dockerfile 작성

> vsCode 사용.

원하는 editor를 켭니다. 저는 vsCode를 사용하겠습니다.

vsCode extention에서 docker를 install합니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_18/Untitled.png?raw=true)

아래 단축키를 눌러 new file을 typing합니다.

```bash
ctrl + shift + p
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_18/Untitled1.png?raw=true)

파일이 생성 되었다면 아래 Select a language를 선택합니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_18/Untitled2.png?raw=true)

docker 파일로 지정해 줍니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_18/Untitled3.png?raw=true)
- Dockerfile의 내용을 작성합니다.

```bash
FROM centos:7
RUN yum -y update && yum install -y firefox
CMD /usr/bin/firefox
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_18/Untitled4.png?raw=true)

**저장한 경로를 기억합니다. 사진에는 -y가 빠졌는데 빠지면 안됩니다.**

** -y는 설치 하겠느냐?(y/n) 에서 y를 자동으로 답하겠다는 뜻입니다.

# Build

> docker build

**D:\Eisen\DockerFiles**

저는 위의 경로에 저장했습니다.

해당 경로에서 cmd를 실행시켜 아래 명령어를 실행시킵니다..

```bash
$ docker build . -f firefox.dockerfile -t firefox
```

** -f 로 정확한 명칭을 지정해 주지 않으니 dockerfile을 인식을 못하더군요.

이렇게 build 하는것을 볼 수 있습니다.

```bash
D:\Eisen\DockerFiles>docker build . -f firefox.dockerfile -t firefox
[+] Building 34.0s (4/5)
 => [internal] load build definition from firefox.dockerfile                                                                         0.0s
 => => transferring dockerfile: 125B                                                                                                 0.0s
 => [internal] load .dockerignore                                                                                                    0.0s
 => => transferring context: 2B                                                                                                      0.0s
 => [internal] load metadata for docker.io/library/centos:7                                                                          0.0s
 => CACHED [1/2] FROM docker.io/library/centos:7                                                                                     0.0s
 => [2/2] RUN yum -y update && yum install -y firefox                                                                               34.0s
 => => # Transaction Summary
 => => # ================================================================================
...
```

firefox image도 생성된 것을 볼 수 있습니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_18/Untitled5.png?raw=true)

# 실행

> docker run

아래의 명령어에서 YOUR_IP 부분을 본인 IP 에 맞게 변경해 주시고 실행시키면 됩니다.

```bash
$ docker run -ti --rm -e DISPLAY=**YOUR_IP**:0.0 firefox
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_18/Untitled6.png?raw=true)

- error들이 뜨는데 되긴 되네요.
- 속도는... 직접 해보시길 바랍니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_18/Untitled7.png?raw=true)

- 한글이 모두 깨지네요. 언어팩도 설치해야할 듯 합니다.

> error

[https://bobcares.com/blog/dbus-launch-terminated-abnormally/](https://bobcares.com/blog/dbus-launch-terminated-abnormally/)

 - 한글 설정

```bash
FROM centos:7
RUN yum -y update && yum install -y firefox
RUN yum install -y dbus-x11
RUN fc-cache -r && echo "LANG=ko_KR.UTF-8" > /etc/locale.conf
RUN localedef -f UTF-8 -i ko_KR ko_KR.UTF-8
ENV LANG="ko_KR.UTF-8" \
    LANGUAGE="ko_KR:ja" \
    LC_ALL="ko_KR.UTF-8"
CMD /usr/bin/firefox
```

이렇게 설정을 해주었는데도 한글이 깨지네요.

흠... 다른 방법이 있다면 댓글 남겨 주시길 바랍니다.

> etc

- run 을 여러번 사용하면 레이어가 여러번 생겨나니 하나로 줄이는게 좋다고 합니다.

```bash
FROM centos:7
RUN yum -y update && \
    yum install -y firefox \
		            -y dbus-x11 && \
    fc-cache -r && \
    echo "LANG=ko_KR.UTF-8" > /etc/locale.conf && \
    localedef -f UTF-8 -i ko_KR ko_KR.UTF-8
ENV LANG="ko_KR.UTF-8" \
    LANGUAGE="ko_KR:ja" \
    LC_ALL="ko_KR.UTF-8"
CMD /usr/bin/firefox
```

# References

[https://dev.to/darksmile92/run-gui-app-in-linux-docker-container-on-windows-host-4kde](https://dev.to/darksmile92/run-gui-app-in-linux-docker-container-on-windows-host-4kde)

[http://cheonbrave.blogspot.com/2017/12/redhat-7-centos-7-locale.html](http://cheonbrave.blogspot.com/2017/12/redhat-7-centos-7-locale.html)
