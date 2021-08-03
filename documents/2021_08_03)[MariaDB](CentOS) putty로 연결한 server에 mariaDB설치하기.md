# [MariaDB](CentOS) putty로 연결한 server에 mariaDB 설치하기(3)

# Preview

> CentOS7, MariaDB 5.5 설치 후 remove 한 후에 MariaDB 10.4  설치를 시도.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_03/Untitled.png?raw=true)

- 안되는 이유를 알게됨. centOS 서버 자체가 32bit로 설정되어있던거임... 나는 당연히 64bit로 설정이 되어 있는줄 알았음.

그래서 그냥 5.5를 새로 깔기로 함.

# X 잘못설치함....

[https://www.programmersought.com/article/53796246624/](https://www.programmersought.com/article/53796246624/)

```jsx
$ systemctl list-unit-files --type=service
```

** 키보드를 이용해서 내림.... 마우스 드래그가 안먹힘.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_03/Untitled1.png?raw=true)

새로 설치가 잘 된 것을 볼 수 있음

mysql을 설치하더라. mariadb가 아니라... 멍청... 시간을 너무 많이 날렸네요.

이걸 다시 따라하기.

[https://mariadb.com/resources/blog/installing-mariadb-10-on-centos-7-rhel-7/](https://mariadb.com/resources/blog/installing-mariadb-10-on-centos-7-rhel-7/)

```jsx
rpm -qa | grep mysql

rpm -e --nodeps 결과물아래는예시
rpm -e --nodeps mariadb-devel-5.5.64-1.el7.x86_64 //예시
```

재설치.

```jsx
$ sudo yum install mariadb-server
```

# Result

> 새로 깔게 되면서 느낀점.

- mariaDB와 mysql을 주의해서 설치하자. (삽질을 너무 많이함)
