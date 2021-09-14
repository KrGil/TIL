# [MariaDB](CentOS) putty로 연결한 server에 mariaDB 10.4 설치하기(실패)

# Preview

> CentOS7, MariaDB 5.5 설치 후 remove 한 후에 MariaDB 10.4  설치를 시도.

# MariaDB Server10.4 설치하기

> 공식 홈페이지에 나와있는것을 따라했는데 오류 발생.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_29/Untitled.png?raw=true)
> Error로 인해 진행이 불가.

```jsx
[error] The MariaDB Repository only supports x86_64 and aarch64 (detected i686).
[error] The MariaDB Repository supports these Linux OSs, on x86_64 only:
* RHEL/CentOS 7 & 8 (rhel)
* Ubuntu 16.04 LTS (xenial), 18.04 LTS (bionic), & 20.04 LTS (focal)
* Debian 9 (stretch) & 10 (buster)
* SLES 12 & 15 (sles)
[error] See [https://mariadb.com/kb/en/mariadb/mariadb-package-repository-setup-and-usage/#platform-support](https://mariadb.com/kb/en/mariadb/mariadb-package-repository-setup-and-usage/#platform-support)
```

- 분명 CentOS 7 버전을 사용하고 있는데 이런 오류가 뜸.
- 기존에 있는 mariaDB를 삭제하고 다시 진행함.

> Maybe?

---

- 이제와 error를 보니 홈페이지에 적혀있는 명령어 중에 repository를 들고오는 명령어가 먹히지 않은 듯함.
- i686이 38bit를 뜻한다고함.
- 혹시 i686을 완전 삭제하고 x86_64 혹은 aarch64 를 받을수만 있다면 해결될 듯 함.
- 하지만 아래에 보는바와 같이 $ yum /etc/yum.repos.d/MariaDB.repo를 수정해도 먹히지 않았음.
- baseurl과 gpgkey를 다시 확인해 보아도 잘 설정된 듯 함.
- 다시 처음으로 돌아와 repository와 gpgkey를 받아오는 방법에 대해 고찰해 볼 필요가 존재.

> 검색하다 ubuntu와 CentOS7에서 10.4 버전 설치방법을 찾음.

[https://computingforgeeks.com/install-mariadb-on-ubuntu-and-centos/](https://computingforgeeks.com/install-mariadb-on-ubuntu-and-centos/)

```jsx
$ cat <EOF | sudo tee /etc/yum.repos.d/MariaDB.repo
[mariadb]
name = MariaDB
baseurl = http://yum.mariadb.org/10.4/centos7-amd64
gpgkey=https://yum.mariadb.org/RPM-GPG-KEY-MariaDB
gpgcheck=1
EOF
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_29/Untitled1.png?raw=true)
- 설정했다면 esc →

```jsx
:wq!
```

로 변경사항을 저장한 후 editor 종료.

# 1차 시도.

> 종료가 될 줄 알았는데 저장후 종료가 되지 않음...(:wq!가 먹히지 않음)

[https://stackoverflow.com/questions/8253362/etc-apt-sources-list-e212-cant-open-file-for-writing](https://stackoverflow.com/questions/8253362/etc-apt-sources-list-e212-cant-open-file-for-writing)

에서 나와있는 방법을 하나씩 실행.

- 필자는

```jsx
because the dir is not exist.

can use :!mkdir -p /etc/apt/ to make the directory.

then :wq
```

이 방법으로 실행됨.

mkdir로 파일을 먼저 만든 후 vim을 실행시키는 것도 하나의 방법인 듯.

이 후 아래 명령어로 설치하면 됨.

```jsx
$ sudo yum -y install MariaDB-server MariaDB-client
```

# 2차 시도

> Error 여기서 또 막힘.

만약 No package MariaDB-server available.
  * Maybe you meant: mariadb-server
No package MariaDB-client available. 

> editor vim 실행 후 다시 편집하기.

```jsx
$ sudo vim /etc/yum.repos.d/MariaDB.repo
```

다시 아래 링크에 나와있는 것을 따라해봄.

[https://computingforgeeks.com/install-mariadb-on-ubuntu-and-centos/](https://computingforgeeks.com/install-mariadb-on-ubuntu-and-centos/)

yum cache 클린하기.

```jsx
$ sudo yum makecache fast
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_29/Untitled2.png?raw=true)
# 3차 시도

> Error 여기서 다시 막힘.

No package MariaDB-server available.
  * Maybe you meant: mariadb-server
No package MariaDB-client available. 

[https://mariadb.com/kb/en/yum/#comment_3351](https://mariadb.com/kb/en/yum/#comment_3351)

위의 링크에서 나와있듯이

```jsx
$ sudo yum clean all
```

을 입력 후 재시도.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_29/Untitled3.png?raw=true)
되는가 싶더니 다시 안됨.

# 4차 시도

[https://kissdino.tistory.com/entry/MariaDB-설치](https://kissdino.tistory.com/entry/MariaDB-%EC%84%A4%EC%B9%98)

위의 링크에서 나온대로 yum을 다시 한번 업데이트 해 봄.

```jsx
$ yum update
```

- mariaDB에 관해서 무엇인가 update를 진행함

```jsx
[root@localhost yum.repos.d]# yum update
Loaded plugins: fastestmirror, langpacks
Loading mirror speeds from cached hostfile
 * base: ftp.yz.yamagata-u.ac.jp
 * extras: ftp.yz.yamagata-u.ac.jp
 * updates: ftp.yz.yamagata-u.ac.jp
mariadb                                                  | 2.9 kB     00:00
mariadb/primary_db                                         |  22 kB   00:00
No packages marked for update
[root@localhost yum.repos.d]#
```

실행이 안됨.

설치한 MariaDB 서버에 대해서 알아보기

```jsx
$ rpm -qi MariaDB-server
```

# References

[https://kyky1211.tistory.com/103](https://kyky1211.tistory.com/103)

[https://computingforgeeks.com/install-mariadb-on-ubuntu-and-centos/](https://computingforgeeks.com/install-mariadb-on-ubuntu-and-centos/)

[https://sarc.io/index.php/mariadb/500-repository-mariadb-5-5-with-yum](https://sarc.io/index.php/mariadb/500-repository-mariadb-5-5-with-yum)