# SQL 연산 순서

#### DBMS의 종류

- 상용 DBMS

  - Oracle

  - MS-SQL

  - DB2
- 오픈소스 DBMS
  - MySQL
  - PostgreSQL 
- 따라서 DBMS마다 각자의 sql 문법들이 존재하며,
  - 이 때 등장한 것이 ANSI SQL입니다.(현재의 대부분의 DBMS들은 ANSI를 지원하고 있습니다.)



### 연산 순서

```sql
SELECT <column> 
FROM <table>
WHERE <condition>
```

> __5__ SELECT
>
> __1__ FROM
>
> __2__ WHERE
>
> __3__ GROUP BY
>
> __4__ HAVING
>
> __6__ ORDER BY





### References

- 기본 지식

  https://brunch.co.kr/@jeonghae/8

- 실행 순서(Oracle / MySql)

  https://blog.naver.com/writer0713/222277142471
  
  https://www.mysqltutorial.org/mysql-group-by.aspx
