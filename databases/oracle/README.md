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

> Function

```jsx
create or replace FUNCTION "CHAT_VALIDATION" (
    MYNO NUMBER,
    TARNO NUMBER    
)
RETURN NUMBER
IS
V_NO NUMBER;
BEGIN
WITH TMPROOM AS (
    SELECT DISTINCT A.*
    FROM CHAT_ROOM A INNER JOIN MEM_CHAT B 
    ON (A.CHATROOM_NO = B.CHATROOM_NO)
    WHERE MEM_NO = MYNO
),
LASTROOM AS (
    SELECT R.CHATROOM_NO, MEM_NO
    FROM TMPROOM R LEFT OUTER JOIN MEM_CHAT M
        ON(R.CHATROOM_NO = M.CHATROOM_NO)
    WHERE R.CHATROOM_NO IN (
        SELECT CHATROOM_NO
        FROM (
            SELECT  CHATROOM_NO, COUNT(MEM_NO)CNT
            FROM MEM_CHAT
            GROUP BY CHATROOM_NO
        ) 
        WHERE CNT = 2
    )
)
SELECT DISTINCT CHATROOM_NO INTO V_NO
FROM LASTROOM
WHERE MEM_NO = TARNO;
RETURN V_NO;
END;
```
