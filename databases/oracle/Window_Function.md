# Window Function

### Before we go further

> - 행과 행 간의 관계를 쉽게 정의하기 위해 만든 함수.
>
> - 분석함수 또는 순위 함수로도 알려져 있습니다.
>
> - 집계함수 또는 윈도우함수 전용으로 존재하는 기능들이 있습니다.
> - GROUP BY 절과 함께 사용할 수 없습니다.
> - WINDOW 함수로 인해 결과 건수가 줄어들지 않습니다.
> - 집계함수(SUM, MIN, MAX, AVG..) 등과 함께 사용하면 집계 대상이 되는 레코드 범위를 지정할 수 있습니다.



### 종류

> 1. 그룹 내 순위(RANK) 관련 함수 : RANK, DENSE_RANK, ROW_NUMBER
> 2. 그룹 내 집계(AGGREGATE) 관련 함수 : SUM, MAX, MIN, AVG, COUNT
> 3. 그룹 내 행 순서 관련 함수 : FIRST_VALUE, LAST_VALUE, LAG, LEAD(오라클 전용)
> 4. 그룹 내 비율 관련 함수  : CUME_DIST, PERCENT_RANK ,NTITLE, RATIO_TO_REPORT
> 5. 통계함수 등이 존재합니다.



### 문법

```sql
SELECT <column>
WINDOW_FUNCTION(arguments) OVER ( [PARTITION BY <column>] [ORDER BY <column> [WINDOWING 절])
FROM <table>
```





### References

https://moonpiechoi.tistory.com/128

