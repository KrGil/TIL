# [SpringBoot] VSCode에 MariaDB5.5 연동하기(3)

> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(1)](https://jjam89.tistory.com/121)
>
> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(2)](https://jjam89.tistory.com/123)
>
> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(3)](https://jjam89.tistory.com/124)

# Preview


##  Error

> Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLInvalidAuthorizationSpecException: Could not connect to address=(host=10.0.100.58)(port=3306)(type=master) : (conn=5) Access denied for user 'eisen '@'10.0.120.8' (using password: YES)
>
> Current charset is UTF-8. If password has been set using other charset, consider using option 'passwordCharacterEncoding'


## Solutions

### blog 보고 따라하기
[https://k9e4h.tistory.com/351](https://k9e4h.tistory.com/351)

![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-04/Untitled.png)

![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-04/Untitled1.png)

적용이 안됩니다 ㅠㅠ
아래의 언어설정하는 방법으로 재시도 해봅니다.

### Mariadb 및 mysql 서버 언어 설정하기

> my.cnf 파일 설정

```jsx
$ vim /etc/my.cnf
```

> 아래 내용 타이핑

```jsx
[mysqld]
collation-server = utf8mb4_unicode_ci
character-set-server = utf8mb4
skip-character-set-client-handshake
```

> 저장 후 종료(esc 누른 후 타이핑합니다.)

```jsx
:wq
```

## result
### UTF-8이 아니라 utf8mb4를 사용하는 이유.

>  [https://www.lesstif.com/dbms/mysql-rhel-centos-ubuntu-20775198.html](https://www.lesstif.com/dbms/mysql-rhel-centos-ubuntu-20775198.html)

MySQL 은 UTF-8 구현을 대충 해서 3 Byte 밖에 표현을 못하는 문제가 있었는데 Emoji 가 활성화되면서 4 byte 로 표현해야 하는 UTF-8 문자들에 대한 요구가 많아졌습니다.
그래서 다른 DBMS 와는 달리 MySQL 은 *utf8mb4* 라는 4byte 를 표현하는 새로운 캐릭터 셋을 만들었으니 Emoji 나 기타 4 byte 로 인코딩하는 UTF-8 문자를 MySQL 에 저장하려면  *utf8mb4* 인코딩을 사용해야만 합니다.

### 설정

- mysql 혹은 mariadb에 접속

```jsx
$ mysql -u root -p
```

- 서버 상태 확인

```jsx
$ status
$ \s
```

![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-04/Untitled2.png?raw=true)
- 변경 후 root를 제외한 다른 계정에서의 접속이 되지 않음.
![alt text](https://raw.githubusercontent.com/KrGil/TIL/8bc6daa747b211f932733d7d17435ede84ff0086/software/framework/springBoot/2021_08_04/Untitled3.png?raw=true)

- 계정 허락이 안되어있음.

![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-04/Untitled4.png?raw=true)
- 여기서는 제대로 설정 되어있는 듯 한데.... 흠...

> 다시 test에 권한 부여

```jsx
$ grant all privileges on *.* to test@'localhost' identified by 'test';
```
![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-04/Untitled5.png?raw=true)

```jsx
$ flush privileges;
```
![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-04/Untitled6.png?raw=true)

- grant 테이블을 리로드하는것이라함.

# Solve

[application.properties](http://application.properties) 파일에서 문제가 생겼습니다. 설정 파일에 white space를 체크해 줍니다.

```jsx
spring.datasource.username=test
```



어찌됬던 해결!

> 결론

- [application.properties](http://application.properties) 설정할때 빈칸없이 잘 쓰자.

# References

- [https://k9e4h.tistory.com/351](https://k9e4h.tistory.com/351)
- [https://inma.tistory.com/98](https://inma.tistory.com/98)
- [https://meongae.tistory.com/24](https://meongae.tistory.com/24)
