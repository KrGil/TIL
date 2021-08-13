# [Linux](Server) ssh 비밀번호 없이 접속하기

# id_rsa, id_rsa.pub 생성하기

- 클라이언트(local)에서 ssh-keygen 명령으로 id_rsa, id_rsa.pub을 생성합니다.

```java
$ ssh-keygen -t rsa
```

- 위의 명령으로 ssh 공개키와 개인키를 생성합니다. key를 생성하면, 홈 디렉토리내의 .ssh 디렉토리에 id_rsa, id_rsa.pub 두개의 파일이 생성된다.

위의 명령어 입력 전에도 ssh username@localhost 로 접속을 하면 자동으로 id_rsa, id_rsa.pub 파일이 생성 됩니다만!
**ssh-keygen -t rsa 명령어를 한번 더 실행하시길 강력 추천드립니다**.(~~필자는 여기서 삽질을 했습니다~~.)

> 실행 코드

---

```bash
$ ssh-keygen -t rsa
Generating public/private rsa key pair.
Enter file in which to save the key (/c/Users/NC517/.ssh/id_rsa):
/c/Users/NC517/.ssh/id_rsa already exists.
Overwrite (y/n)? y
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /c/Users/NC517/.ssh/id_rsa
Your public key has been saved in /c/Users/NC517/.ssh/id_rsa.pub
The key fingerprint is:
SHA256:4jF47PyNk4i3VQ6u9ZaT+v2ahgsf5G4oMNh7pHhTzCg NC517@DESKTOP-9MQT7BS
The key's randomart image is:
....
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_13_1/Untitled.png?raw=true)

# 서버에 id_rsa.pub 집어넣기

- 생성된 id_rsa.pub 파일을 **authorized_keys**라는 파일로 서버에 복사합니다.

```java
$ scp id_rsa.pub root@localhost:/root/.ssh/authorized_keys
```

- .ssh 파일이 없다면 아래 명령어로 생성해 주면 됩니다.

```bash
$ mkdir ~/.ssh
```

> 실행 코드

---

```bash
$ scp id_rsa.pub root@localhost:/root/.ssh/authorized_keys
root@localhost's password:
id_rsa.pub                                             100%  575   152.4KB/s   00:00
```

root 계정이 아닌 타 계정이라면

CentOS7의 경우 /home/eisen/.ssh/authorized_keys 이더군요.

```bash
$ scp id_rsa.pub root@localhost:/home/eisen/.ssh/authorized_keys
```

> 실제 접속 이미지

- root 계정

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_13_1/Untitled1.png?raw=true)

- 밑에 exity는 오타입니다... exit 치려 했어요ㅠ

- eisen 계정

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_13_1/Untitled2.png?raw=true)

만약 접속이 불가능 하다면, 서버의 sshd_config(/etc/ssh/sshd_config) 파일에서 아래의 사항을 확인한다. 주석처리가 되어 있을 경우 주석을 제거하고 ssh데몬을 재시작 한 후에 접속 테스트를 한다.

PubkeyAuthentication yes
AuthorizedKeysFile      .ssh/authorized_keys

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_13_1/Untitled3.png?raw=true)

생각보다 쉽죠? ㅎㅎ ~~2시간 걸린건 안비밀~~

# References

[http://faq.add4s.com/?p=333](http://faq.add4s.com/?p=333)

[https://shanepark.tistory.com/195](https://shanepark.tistory.com/195)
