# 2021_06_28) subDB 생성 및 export하기.

# Alter로 테이블 데이터 변경하기.

---

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

# Oracle DB Export 하기

---

> window에서 export하기

1. 상단의  도구 >  데이터베이스 익스포트

   ![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/image.png?raw=true)

2. 경로 설정 및 전체적인 설정하기.

![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/image_(1).png?raw=true)

image_(2).png

![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/image_(2).png?raw=true)

이 후 완료하면 해당 경로에 .sql 파일이 생성

> mac에서 export 하기

![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/Untitled.png?raw=true)

맥 역시 동일.