# [scp]scp란?(윈도우와 리눅스 간의 파일 전송)

## Before we go further

- 윈도우에서 ssh를 활용하여 특정 ip에 비밀번호 없이 접속하는 방법에 대해 작성했었습니다.

    [[Linux](server) ssh 비밀번호 없이 접속하기](https://jjam89.tistory.com/139)

- 그런데 리눅스 서버에 있는 특정 파일을 윈도우로 넘기려 하니 갑자기 막막한 느낌이 들더군요.(~~제가 scp에 대해 전혀 모르고 사용했었습니다...~~)

그런 이유로 간단하게 ```scp```에 대해 적고 ```scp```를 이용한 파일 업로드 및 다운로드하는 법에 대해 적어보겠습니다.



### SCP란?

> Secure Copy로 네트워크가 연결되어 있는 원격지에 파일을 간편하고 안전하게 전송할 수 있는 명령어입니다.

```scp```는 ```ssh```프로토콜과 ```rcp```의 조합입니다.(rcp는 scp이전의 파일전송 프로토콜입니다.)

그리고 [openSSH8.0 배포때 발표 내용](https://www.openssh.com/txt/release-8.0) 으로 인하여 앞으로는 ```scp``` 보다 ```rsync```와 ```sftp``` 사용을 권장하고 있습니다.

참고 : https://hoing.io/archives/6588



https://unix.stackexchange.com/questions/571293/is-scp-unsafe-should-it-be-replaced-with-sftp



## 우선 모든 명령어는 로컬 컴퓨터에서 작성됩니다.

- 저는 local환경이 Windows이고 원격 환경이 Linux 이므로 보실 때 참고하시길 바랍니다.
- 참고 : https://coconuts.tistory.com/343



## Window에서 scp 사용 전 설정

설정 창에서 앱 및 기능 -> 선택적 기능 -> OpenSSH 클라이언트 확인

![image-20210827180350247](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/scp.assets/image-20210827180350247.png)

아래 사진처럼 OpenSSH 클라이언트가 설치 되어 있어야 ssh 기반으로 돌아가는 scp가 실행이 됩니다.

![image-20210827190720328](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/scp.assets/image-20210827190720328.png)



### **_Windows(로컬) -> Linux(원격)_**

> Upload 입니다.

```
scp [로컬파일경로][파일]  [원격계정]@[원격ip/도메인]:[받을경로]
```

###### *경로는 C:\Users\username 이상의 경로로 해주어야 합니다.*

###### *scp -r 옵션을 사용하면 폴더(디렉토리)로 전송이 됩니다.*



한번 사용해 보겠습니다.

![image-20210827191508839](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/scp.assets/image-20210827191508839.png)

```java

$ vim test.txt		// test.txt를 생성합니다.
$ ll				// 파일이 생성 되었는지 확인합니다.
total 6.0K
-rw-r--r-- 1 NC517 197121 282 11월 19  2020  desktop.ini
-rw-r--r-- 1 NC517 197121   5  8월 27 19:14  test.txt
drwxr-xr-x 1 NC517 197121   0  8월 23 11:06 '바로가기 파일들'

$ pwd			// 현재 경로를 확인합니다.
/c/Users/NC517/Desktop

// scp로 test.txt를 vm으로 돌아가고있는 localserver에 파일을 전송합니다.
$ scp C:/Users/NC517/Desktop/test.txt root@localhost:/home/eisen	
test.txt                                                                              100%    5     1.2KB/s   00:00

```

```scp```를 활용한 코드입니다.

```
scp C:/Users/NC517/Desktop/test.txt root@localhost:/home/eisen
```


#### 결과

![image-20210827192001762](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/scp.assets/image-20210827192001762.png)

이렇게 파일이 잘 올라가는 것을 볼 수 있습니다.





### *Linux(원격) -> Windows(로컬)*

> Download 입니다.

~~~
scp [원격계정]@[원격ip/도메인]:[파일] [받을경로]
~~~

위치만 바꿔주면 됩니다.

test.txt를 test1.txt로 이름을 바꿔줍니다.

![image-20210827192422248](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/scp.assets/image-20210827192422248.png)

아래 명령어를 실행시킵니다.

``` java
scp root@localhost:/home/eisen/test1.txt C:/Users/NC517/Desktop
```

현재 폴더에 다운받고 싶다면 ```./``` 를 사용하셔도 됩니다. 

``` java
scp root@localhost:/home/eisen/test1.txt ./
```



명령어를 실행시키면 아래 이미지와 같이 test1.txt가 생기는 것을 볼 수 있습니다.

![image-20210827192600466](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/scp.assets/image-20210827192600466.png)

#### 실행 code

```
$ ll
total 6.0K
-rw-r--r-- 1 NC517 197121 282 11월 19  2020  desktop.ini
-rw-r--r-- 1 NC517 197121   5  8월 27 19:14  test.txt
drwxr-xr-x 1 NC517 197121   0  8월 23 11:06 '바로가기 파일들'

$ scp root@localhost:/home/eisen/test1.txt C:/Users/NC517/Desktop
test1.txt                                                                             100%    5     2.0KB/s   00:00

$ ll
total 7.0K
-rw-r--r-- 1 NC517 197121 282 11월 19  2020  desktop.ini
-rw-r--r-- 1 NC517 197121   5  8월 27 19:14  test.txt
-rw-r--r-- 1 NC517 197121   5  8월 27 19:25  test1.txt
drwxr-xr-x 1 NC517 197121   0  8월 23 11:06 '바로가기 파일들'
```



### Result

---

upload :  ``` scp C:/Users/NC517/Desktop/test.txt root@localhost:/home/eisen```

download : ``` scp root@localhost:/home/eisen/test1.txt ./ ```











### Reference

https://coconuts.tistory.com/343

https://hoing.io/archives/6588

https://ko.strephonsays.com/ssh-and-vs-scp-14947

https://ko.eyewated.com/rcp-scp-ftp-%EC%BB%B4%ED%93%A8%ED%84%B0%EA%B0%84%EC%97%90-%ED%8C%8C%EC%9D%BC%EC%9D%84-%EB%B3%B5%EC%82%AC%ED%95%98%EA%B8%B0%EC%9C%84%ED%95%9C-%EB%AA%85%EB%A0%B9/

https://unix.stackexchange.com/questions/571293/is-scp-unsafe-should-it-be-replaced-with-sftp