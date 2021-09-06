# [Linux] CentOS 명령어

>  hostname 변경하기

```jsx
$ hostnamectl set-hostname [name]
```

- hostnamectl set-hostname myplayGround



> 네트워크 정보 확인

```bash
$ ifconfig
[root@localhost ~]# ifconfig
**eth0**: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 10.0.100.58  netmask 255.255.0.0  broadcast 10.0.255.255
        inet6 fe80::8bbf:dfe7:26ec:dd03  prefixlen 64  scopeid 0x20<link>
        ether 00:15:5d:66:69:04  txqueuelen 1000  (Ethernet)
        RX packets 20205246  bytes 2747005256 (2.5 GiB)
        RX errors 0  dropped 1556355  overruns 0  frame 0
        TX packets 22384  bytes 2295538 (2.1 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
...
```



> 부팅 시 자동으로 네트워크 잡히도록 설정

```jsx
$ vim /etc/sysconfig/network-scripts/ifcfg-[네트워크인터페이스이름]
```

- vim /etc/sysconfig/network-scripts/ifcfg-[**eth0**]
- ONBOOT=yes

```bash
TYPE=Ethernet
PROXY_METHOD=none
BROWSER_ONLY=no
BOOTPROTO=none
DEFROUTE=yes
IPV4_FAILURE_FATAL=no
IPV6INIT=yes
IPV6_AUTOCONF=yes
IPV6_DEFROUTE=yes
IPV6_FAILURE_FATAL=no
IPV6_ADDR_GEN_MODE=stable-privacy
NAME=eth0
UUID=4b1a7bf3-92ff-4c8f-84f8-77280fa0eb16
DEVICE=eth0
**ONBOOT=yes
...**
```



> 수정된 사항 바로 적용시키기

```bash
$ source /etc/bashrc
```

https://klero.tistory.com/entry/source-명령어란



> 특정 유저 사용하기

```bash
$ su - [username]
```

- su - eisen



> systemctl

- 서비스 제어 명령어

```bash
$ systemctl stop postfix
```

- postfix 를 중지시키겠다.

```bash
$ systemctl list-unit-files | grep postfix
```

- 시스템에 있는 unit 중에서 postfix를 검색하겠다.



> ps

- 프로세스

```bash
$ ps aux | grep postfix
```

- 프로세스들 중에서 postfix를 찾겠다.



> iptables

```java
$ iptables nL    // 방화벽 상태 확인
$ iptables -F    // 모든 방화벽 열기(방화벽 모든 설정 삭제)
```



> 특정 ip에 파일 전송하기

```java
$ scp [전송할파일이름(확장자까지)] [Username][@127.0.0.1](<mailto:jmocha@127.0.0.1>)(또는 localhost):[폴더명]
```

- scp testFile.tar.gz eisen[@127.0.0.1](mailto:jmocha@127.0.0.1)(또는 localhost):test



> 디렉토리 소유 유저 변경

```java
$ chown [user]:[group] [/path/to/file_or_directory]
```

chown user:group /path/to/file_or_directory



> 재시작하기

```bash
$ sudo reboot
$ sudo reboot -f
$ sudo systemctl --force --force reboot
```



> 복사하기

https://corej21.tistory.com/42

```jsx
$ cp [Option][원본][사본]
```

- cp mydir1 mydir2



> 심볼릭 링크

https://zetawiki.com/wiki/리눅스_심볼릭링크_폴더_생성_실습

```jsx
$ ln -s /volumes/disk3/test/eisen eisen
```

현재 위치에 eisen이라는 심볼릭 링크를 생성.



> 파일 검색하기

```jsx
find [path] [option] [name]
```

path : 어디서부터 찾을지 작성합니다. `/` 는 최상위에서 찾아보겠다는 명령입니다.

option : 주로 `-name`을 적습니다.

name : 찾을 파일을 적습니다. `*.txt`처럼 찾을 파일의 타입으로 검색해도 됩니다.

```jsx
sudo find / -name test.txt
```



> ssh 설정 변경하기

```
sudo vim /etc/ssh/sshd_config
```



> 본인의 ip에 대해 검색

```ip route show```







### 사용자 및 권한 관련 명령어

https://hooongs.tistory.com/239

#### 사용자 권한 변경

https://twofootdog.tistory.com/9



# Reference

https://klero.tistory.com/entry/source-명령어란

https://corej21.tistory.com/42