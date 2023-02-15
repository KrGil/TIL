# [SpringBoot] VSCode에 MariaDB5.5 연동하기(2)

> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(1)](https://jjam89.tistory.com/121)
>
> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(2)](https://jjam89.tistory.com/123)
>
> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(3)](https://jjam89.tistory.com/124)

# Error


- 재설치 이후 처음 시작인데 이런 오류가 나옵니다.

```jsx
[root@localhost /]# /usr/bin/mysql_secure_installation

NOTE: RUNNING ALL PARTS OF THIS SCRIPT IS RECOMMENDED FOR ALL MariaDB
      SERVERS IN PRODUCTION USE!  PLEASE READ EACH STEP CAREFULLY!

In order to log into MariaDB to secure it, we'll need the current
password for the root user.  If you've just installed MariaDB, and
you haven't set the root password yet, the password will be blank,
so you should just press enter here.

Enter current password for root (enter for none):
ERROR 2002 (HY000): Can't connect to local MySQL server through socket '/var/lib/mysql/mysql.sock' (2)
```

- 원인 mysql과 mariadb는 다르다. 아마 mysql을 start 시켰을 것임.

```jsx
$ sudo pkill mysql

$ sudo service mariadb restart
```

- mysql을 끄고 mariadb를 재시작 시킴.

> Could not connect to HostAddress...

```jsx
Could not connect to HostAddress{host='10.0.100.58', port=3306, type='master'}. Host '10.0.120.8' is not allowed to connect to this MariaDB server
  Host '10.0.120.8' is not allowed to connect to this MariaDB server
```

> Solve

- MariaDB에 접속한 후 아래 명령어로 외부 접속 허용 계정 생성.

```jsx
$ grant all privileges on *.* to '사용자id'@'%' identified by '123123';
```

![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-03-2/Untitled.png?raw=true)


성공.

> UTF-8 관련 오류

```jsx
### Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLInvalidAuthorizationSpecException: Could not connect to address=(host=10.0.100.58)(port=3306)(type=master) : (conn=5) Access denied for user 'eisen '@'10.0.120.8' (using password: YES)
Current charset is UTF-8. If password has been set using other charset, consider using option 'passwordCharacterEncoding'
```

- db부터 모든데이터들을 utf-8로 변경하기 시작함.

- 각 컬럼들 타입 확인하기.

```jsx
SHOW FULL COLUMNS FROM user;
```

![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-03-2/Untitled1.png?raw=true)

- 보는바와 같이 비밀번호가 latin1_bin으로 적용.

```jsx
ALTER TABLE user MODIFY COLUMN Password char(41) COLLATE utf8_general_ci;
```

![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-03-2/Untitled2.png?raw=true)

- 변경.

...
