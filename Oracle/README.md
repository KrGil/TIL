# Oracle Query

> ORA-28000, 계정 잠금(LOCK) 해제

```jsx
ALTER USER user_name ACCOUNT UNLOCK
```

> Oracle Password expired

```jsx
ALTER USER my_user IDENTIFIED BY MyNewPassword123
```

- ex 버전을 사용한다면 system의 비밀번호가 없을 시 expired되면 수정이 힘들어 지기 때문에
- 설정한 비밀번호를 잘 기억하거나
- 미리 권한을 부여한 다른 계정을 생성해 두는 것도 좋은 방법일 듯 합니다.

> Connection 생성 및 권한 부여하기

```jsx
CREATE USER my_user IDENTIFIED BY MyNewPassword123;

GRANT RESOURCE, CONNECT TO my_user;
```