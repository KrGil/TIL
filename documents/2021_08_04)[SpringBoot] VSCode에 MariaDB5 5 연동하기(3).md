# [SpringBoot] VSCode에 MariaDB5.5 연동하기(3)

# Preview

---

> Error

### Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLInvalidAuthorizationSpecException: Could not connect to address=(host=10.0.100.58)(port=3306)(type=master) : (conn=5) Access denied for user 'eisen '@'10.0.120.8' (using password: YES)
Current charset is UTF-8. If password has been set using other charset, consider using option 'passwordCharacterEncoding'

> Solutions

- [https://k9e4h.tistory.com/351](https://k9e4h.tistory.com/351)

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_04/Untitled.png?raw=true)
![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_04/Untitled1.png?raw=true)
안됨.

아래 방법으로 시도.

# Mariadb 및 mysql 서버 언어 설정하기

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

> 저장 후 종료(esc 누름)

```jsx
:wq
```

## UTF-8이 아니라 utf8mb4를 사용하는 이유.

- [https://www.lesstif.com/dbms/mysql-rhel-centos-ubuntu-20775198.html](https://www.lesstif.com/dbms/mysql-rhel-centos-ubuntu-20775198.html)

**MySQL 은 UTF-8 구현을 대충 해서 3 Byte 밖에 표현을 못하는 문제가 있었는데 Emoji 가 활성화되면서 4 byte 로 표현해야 하는 UTF-8 문자들에 대한 요구가 많아졌다.
그래서 다른 DBMS 와는 달리 MySQL 은 *utf8mb4* 라는 4byte 를 표현하는 새로운 캐릭터 셋을 만들었으니 Emoji 나 기타 4 byte 로 인코딩하는 UTF-8 문자를 MySQL 에 저장하려면  *utf8mb4* 인코딩을 사용해야 한다.**

> mysql 혹은 mariadb에 접속

```jsx
$ mysql -u root -p
```

> 서버 상태 확인

```jsx
$ status
$ \s
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_04/Untitled2.png?raw=true)
- 변경 후 root를 제외한 다른 계정에서의 접속이 되지 않음.
![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_04/Untitled3.png?raw=true)

- 계정 허락이 안되어있음.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_04/Untitled4.png?raw=true)
- 여기서는 제대로 설정 되어있는 듯 한데.... 흠...

> 다시 test에 권한 부여

```jsx
$ grant all privileges on *.* to test@'localhost' identified by 'test';
```
![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_04/Untitled5.png?raw=true)

```jsx
$ flush privileges;
```
![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_04/Untitled6.png?raw=true)

- grant 테이블을 리로드하는것이라함.

안됨...

# Solve!

[application.properties](http://application.properties) 파일의

```jsx
spring.datasource.username=test
spring.datasource.username=test
```

위에것을 아래것으로 수정함.

다른점이 없다 싶겠지만

첫번째 맨 끝에 white space가 하나 들어가있었음.....

ㅎㅎ

어찌됬던 해결!

> 결론

- [application.properties](http://application.properties) 설정할때 빈칸없이 잘 쓰자.

# References

- [https://k9e4h.tistory.com/351](https://k9e4h.tistory.com/351)
- [https://inma.tistory.com/98](https://inma.tistory.com/98)
- [https://meongae.tistory.com/24](https://meongae.tistory.com/24)
