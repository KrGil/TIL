# [2021_06_22]fullCalendar && GanttChart API

### preview

---

- fullcalendar open, closed, all에 따른 데이터 업데이트 구현하기

# fullCalendar 일정 변경 시 업데이트 하기

---

> 일정 이동 시 해당 날짜 구하기

```jsx
console.log(arg.event.start)
console.log(arg.event.end);
```

- 일정 이동 시 데이터 값이 나옴.
- 날것 그대로 쓸 수 없으니 일정한 형식에 맞게 formatting
- time = moment(time).format('YYYY-MM-DD');

> query 짜서 직접 업데이트 시켜주기

```jsx
<update id="updateIssueDate" parameterType="java.util.Map">
		UPDATE ISSUE
		SET 
		<trim prefixOverrides=",">
		 	<if test="@org.apache.commons.lang3.StringUtils@isNotBlank(start_date)">
		    , ISSUE_START_DATE = #{start_date, jdbcType=VARCHAR}
		    </if>
		    <if test="@org.apache.commons.lang3.StringUtils@isNotBlank(end_date)">
			, ISSUE_END_DATE = #{end_date, jdbcType=VARCHAR}
			</if>
	    </trim>
		WHERE ISSUE_SID = #{sid}
	</update>
```

# GanttChart API 사용하기

---

> GanttChart API 검색하기

- [https://ourcodeworld.com/articles/read/434/top-5-best-free-jquery-and-javascript-dynamic-gantt-charts-for-web-applications](https://ourcodeworld.com/articles/read/434/top-5-best-free-jquery-and-javascript-dynamic-gantt-charts-for-web-applications)
- 이 중에서 jsGanttImproved를 사용하기로함.

> jsGantt Improved 사이트

- [http://www.basoinsa.online/htdocs/includes/jsgantt/index.html](http://www.basoinsa.online/htdocs/includes/jsgantt/index.html)
- github나 다른 사이트의 설명들 보다 여기에 적혀있는 설명이 훨씬 도움이 많이 됨.
- example 역시 여기에 있는 example 사용하는것이 훨씬 도움됨.

> 마일스톤 아래에 이슈가 존재할 수 있도록 하기.

- xml 수정 하는 중.

# fullCalendar error 발생

---

> Invalid Character ,  Invalid Column index Error

- "2021-01-01" 형태의 string을 mybatis에서 넘길 시 오류 발생.

```jsx
<update id="updateIssueDate" parameterType="java.util.Map">
		UPDATE ISSUE
		SET 
		<trim prefixOverrides=",">
		 	<if test="@org.apache.commons.lang3.StringUtils@isNotBlank(start_date)">
		    , ISSUE_START_DATE = DATE_FORMAT(STR_TO_DATE(#{start_date,jdbcType=VARCHAR},‘YYYY-MM-DD’'),‘YYYY-MM-DD’)
		    </if>
		    <if test="@org.apache.commons.lang3.StringUtils@isNotBlank(end_date)">
			, ISSUE_END_DATE = DATE_FORMAT(STR_TO_DATE(#{start_date,jdbcType=VARCHAR},‘YYYY-MM-DD’'),‘YYYY-MM-DD’)
			</if>
	    </trim>
		WHERE ISSUE_SID = #{sid}
	</update>
```

- 처음에는 #{start_date, jdbcType=VARCHAR}로 넘기니 잘 되었는데
- 팀원이 실행시켰을 시 오류 발생.

- Invalid Character 오류는 TO_DATE(#{start_date.jdbcType=VARCHAR}, YYYY-MM-DD)로 넘겼을 시 발생.
- DATE_FORMAT(STR_TO_DATE(#{start_date,jdbcType=VARCHAR},‘YYYY-MM-DD’'),‘YYYY-MM-DD’) 오류 발생.

---

해결 못함. 내일 해결할 예정

# Summary

---

1. 역시 나는 아직 많이 부족하다.
2. 좀 더 열심히 해 보아야 겠다.
3. 내일 gantt chart를 완성해야 하는데... view단이라도 완성시켜야 겠다.

# Tomorrow

---

> Calendar.xml 수정 및 Ganttchart view 완성

- script에서는 String,  java 에서는 ? , xml에서는 String
- 해당 프로젝트에 속한 모든 마일스톤, 그리고 그에 속한 issue들 들고오기.
- ... 짠 query들을 그냥 날리고 집에 온 듯 하다. 내일은 좀 더 빠른 시간 내에 완성 가능할 듯.