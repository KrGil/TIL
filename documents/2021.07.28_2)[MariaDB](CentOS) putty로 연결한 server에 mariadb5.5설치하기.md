# [MariaDB](CentOS) putty로 연결한 server에 mariaDB 5.5 설치하기

# MariaDB Server 5.5 설치하기

---

[https://mariadb.com/resources/blog/installing-mariadb-10-on-centos-7-rhel-7/](https://mariadb.com/resources/blog/installing-mariadb-10-on-centos-7-rhel-7/)

The RHEL 7 and CentOS 7 distributions include MariaDB Server 5.5 by default.

찾아보니 CentOS 8 버전도 기본적으로 5.5를 가지고 있다.

따라서 mariadb server 5.5를 설치하려면 아래의 명령어를 작성하면 된다.

```jsx
$ sudo yum install mariadb-server
```
![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_28_2/Untitled.png?raw=true)
![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_28_2/Untitled1.png?raw=true)

- Complete가 뜨면 설치가 완료된 것!

## MariaDB 실행하기

```jsx
$ systemctl start mariadb
```

- 비밀번호 설정하기

```jsx
$ /usr/bin/mysql_secure_installation
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_28_2/InkedUntitled_(2)_LI.jpg?raw=true)

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_28_2/Untitled2.png?raw=true)

- mysql에 접속하기

```jsx
$ mysql -u 계정아이디 -p 비밀번호
```

- root계정 말고 다른 계정 생성하기.(root계정으로 접속해야지 생성 가능)
- 모든 권한 부여한 아이디 생성.
- [localhost](http://localhost) : 내부접속만 허용 % : 외부접속 허용하기.

```jsx
$ grant all privileges on *.* to eisen@'localhost' identified by '123123';
```

- eisen으로 접속이 가능하다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_28_2/Untitled3.png?raw=true)
# MariaDB Server10.4 설치하기

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_28_2/Untitled4.png?raw=true)
> 오류가 발생

[error] The MariaDB Repository only supports x86_64 and aarch64 (detected i686).
[error] The MariaDB Repository supports these Linux OSs, on x86_64 only:
* RHEL/CentOS 7 & 8 (rhel)
* Ubuntu 16.04 LTS (xenial), 18.04 LTS (bionic), & 20.04 LTS (focal)
* Debian 9 (stretch) & 10 (buster)
* SLES 12 & 15 (sles)
[error] See [https://mariadb.com/kb/en/mariadb/mariadb-package-repository-setup-and-usage/#platform-support](https://mariadb.com/kb/en/mariadb/mariadb-package-repository-setup-and-usage/#platform-support)

> 10.4는 해결 방법을 찾고 있는 중임

[https://computingforgeeks.com/install-mariadb-on-ubuntu-and-centos/](https://computingforgeeks.com/install-mariadb-on-ubuntu-and-centos/)

```jsx
cat <EOF | sudo tee /etc/yum.repos.d/MariaDB.repo
[mariadb]
name = MariaDB
baseurl = http://yum.mariadb.org/10.4/centos7-amd64
gpgkey=https://yum.mariadb.org/RPM-GPG-KEY-MariaDB
gpgcheck=1
EOF
```