# [2021_06_23]fullCalendar && GanttChart API

# preview

---

> Calendar.xml 수정

- script에서는 String,  java 에서는 ? , xml에서는 String
- invalid character, invalid column index 오류

> why?

- 본인은 mac을 사용.
- slack에서 보내준 코드를 그대로 복사해서 붙여넣었음.
- ‘ 와  ' 게 다르게 생긴듯이 서로 다른 문자임.
- mybatis에서 제대로 인식을 못함.
- 지우고 직접 작성하니 잘 됨.
- json 관련 사이트

[https://www.json.org/json-en.html](https://www.json.org/json-en.html)

# jsGantt 사용하기

---

> 기본 sample 출력하기

```jsx
<link rel="stylesheet" type="text/css" href="jsgantt.css" />
<script language="javascript" src="jsgantt.js"></script>
<div style="position:relative" class="gantt" id="GanttChartDIV"></div>
<script>

var g = new JSGantt.GanttChart('g',document.getElementById('GanttChartDIV'), 'day');

if( g.getDivId() != null ) {
g.setCaptionType('Complete');
g.setQuarterColWidth(36);
g.setDateTaskDisplayFormat('day dd month yyyy');
g.setDayMajorDateDisplayFormat('mon yyyy - Week ww');
g.setWeekMinorDateDisplayFormat('dd mon');
g.setShowTaskInfoLink(1);
g.setShowEndWeekDate(0);
g.setUseSingleCell(10000);
g.setFormatArr('Day', 'Week', 'Month', 'Quarter');

g.AddTaskItem(new JSGantt.TaskItem(1,   'Define Chart API',     '',           '',          'ggroupblack',  '',       0, 'Brian',    0,   1, 0,  1, '',      '',      'Some Notes text', g ));
g.AddTaskItem(new JSGantt.TaskItem(11,  'Chart Object',         '2016-02-20','2016-02-20', 'gmilestone',   '',       1, 'Shlomy',   100, 0, 1,  1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(12,  'Task Objects',         '',           '',          'ggroupblack',  '',       0, 'Shlomy',   40,  1, 1,  1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(121, 'Constructor Proc',     '2016-02-21','2016-03-09', 'gtaskblue',    '',       0, 'Brian T.', 60,  0, 12, 1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(122, 'Task Variables',       '2016-03-06','2016-03-11', 'gtaskred',     '',       0, 'Brian',    60,  0, 12, 1, 121,     '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(123, 'Task by Minute/Hour',  '2016-03-09','2016-03-14 12:00', 'gtaskyellow', '',  0, 'Ilan',     60,  0, 12, 1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(124, 'Task Functions',       '2016-03-09','2016-03-29', 'gtaskred',     '',       0, 'Anyone',   60,  0, 12, 1, '123SS', 'This is a caption', null, g));
g.AddTaskItem(new JSGantt.TaskItem(2,   'Create HTML Shell',    '2016-03-24','2016-03-24', 'gtaskyellow',  '',       0, 'Brian',    20,  0, 0,  1, 122,     '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(3,   'Code Javascript',      '',           '',          'ggroupblack',  '',       0, 'Brian',    0,   1, 0,  1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(31,  'Define Variables',     '2016-02-25','2016-03-17', 'gtaskpurple',  '',       0, 'Brian',    30,  0, 3,  1, '',      'Caption 1','',   g));
g.AddTaskItem(new JSGantt.TaskItem(32,  'Calculate Chart Size', '2016-03-15','2016-03-24', 'gtaskgreen',   '',       0, 'Shlomy',   40,  0, 3,  1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(33,  'Draw Task Items',      '',           '',          'ggroupblack',  '',       0, 'Someone',  40,  2, 3,  1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(332, 'Task Label Table',     '2016-03-06','2016-03-09', 'gtaskblue',    '',       0, 'Brian',    60,  0, 33, 1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(333, 'Task Scrolling Grid',  '2016-03-11','2016-03-20', 'gtaskblue',    '',       0, 'Brian',    0,   0, 33, 1, '332',   '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(34,  'Draw Task Bars',       '',           '',          'ggroupblack',  '',       0, 'Anybody',  60,  1, 3,  0, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(341, 'Loop each Task',       '2016-03-26','2016-04-11', 'gtaskred',     '',       0, 'Brian',    60,  0, 34, 1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(342, 'Calculate Start/Stop', '2016-04-12','2016-05-18', 'gtaskpink',    '',       0, 'Brian',    60,  0, 34, 1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(343, 'Draw Task Div',        '2016-05-13','2016-05-17', 'gtaskred',     '',       0, 'Brian',    60,  0, 34, 1, '',      '',      '',      g));
g.AddTaskItem(new JSGantt.TaskItem(344, 'Draw Completion Div',  '2016-05-17','2016-06-04', 'gtaskred',     '',       0, 'Brian',    60,  0, 34, 1, "342,343",'',     '',      g));
g.AddTaskItem(new JSGantt.TaskItem(35,  'Make Updates',         '2016-07-17','2017-09-04', 'gtaskpurple',  '',       0, 'Brian',    30,  0, 3,  1, '333',   '',      '',      g));

g.Draw();
}
else
{
alert("Error, unable to create Gantt Chart");
}

</script>
```

- [http://www.basoinsa.online/htdocs/includes/jsgantt/index.html](http://www.basoinsa.online/htdocs/includes/jsgantt/index.html)
- 코드를 입맛에 맞게 수정해서 사용.
- g.AddTaskItem(new JSGantt.TaskItem(35,  'Make Updates',         '2016-07-17','2017-09-04', 'gtaskpurple',  '',       0, 'Brian',    30,  0, 3,  1, '333',   '',      '',      g));
- 하단의 순서대로 내용물들이 들어감.

```jsx
<pID>25</pID>
<pName>WCF Changes</pName>
<pStart></pStart>
<pEnd></pEnd>
<pClass>gtaskred</pClass>
<pLink></pLink>
<pMile>0</pMile>
<pRes></pRes>
<pComp>0</pComp>
<pGroup>1</pGroup>
<pParent>2</pParent>
<pOpen>1</pOpen>
<pDepend>2,24</pDepend>
<pCaption>A caption</pCaption>
<pNotes>Text - can include limited HTML</pNotes>
```

# GanttChart view 출력하기

---

> GanttChart 필요한 데이터 query 짜기

- 해당 프로젝트의 모든 milestone과 issue가 필요.
- milestone은 issue가 존재할 수도 없을 수도 있다.
- issue는 milestone이 존재할 수도 있고 없을 수도 있다.
1. full outer join 사용하기.

```jsx
WITH ISSUEINFO AS (
SELECT A.ISSUE_SID, A.MILEST_SID, B.MEM_NO, A.PROJ_NO
FROM ISSUE A
    LEFT OUTER JOIN ISSUE_ASSIGNEE B ON (A.ISSUE_SID = B.ISSUE_SID)
    LEFT OUTER JOIN LABEL C ON (A.LABEL_NO = C.LABEL_NO)
)
SELECT D.MILEST_SID, F.ISSUE_SID, F.MEM_NO
FROM MILESTONE D
    FULL OUTER JOIN ISSUEINFO F ON (D.MILEST_SID = F.MILEST_SID)
WHERE D.PROJ_NO = 103 OR F.PROJ_NO=103;

```

2. union으로 중복 제거해서 결과값 출력하기

```jsx
WITH ISSUEINFO AS (
SELECT A.ISSUE_SID, A.MILEST_SID, B.MEM_NO, A.PROJ_NO
FROM ISSUE A
    LEFT OUTER JOIN ISSUE_ASSIGNEE B ON (A.ISSUE_SID = B.ISSUE_SID)
    LEFT OUTER JOIN LABEL C ON (A.LABEL_NO = C.LABEL_NO)
)
SELECT D.MILEST_SID, F.ISSUE_SID, F.MEM_NO
FROM MILESTONE D
    LEFT OUTER JOIN ISSUEINFO F ON (D.MILEST_SID = F.MILEST_SID)
WHERE D.PROJ_NO = 103 

UNION

SELECT D.MILEST_SID, F.ISSUE_SID, F.MEM_NO
FROM MILESTONE D
    RIGHT OUTER JOIN ISSUEINFO F ON (D.MILEST_SID = F.MILEST_SID)
WHERE F.PROJ_NO = 103; 
```

- 쿼리를 짜는데 실컷 조인은 잘 해놓고 where절에 proj_no를 milestone것만 줌.
- issueinfo에 proj_no가 존재하지 않으니 마지막 결과에서 짤려서 left outer join만 된 것처럼 보였던 것.
- 둘 중 어느것을 써도 무방함.

---

### 최종 쿼리문.

```jsx
<collection property="issueList" ofType="best.gaia.vo.IssueVO" javaType="java.util.List" autoMapping="false">
				<id column="ISSUE_ID" property="issue_sid"/>
					<result column="ISSUE_NO" property="issue_no"></result>
					<result column="ISSUE_TITLE" property="issue_title"></result>
					<result column="MILEST_ID" property="milest_sid"></result>
					<result column="ISSUE_START_DATE" property="issue_start_date"></result>
					<result column="ISSUE_END_DATE" property="issue_end_date"></result>
					<result column="ISSUE_STATUS" property="issue_status"></result>
	<!-- 				<result column="ISSUE_WRI_MEM_PIC" property="mem_pic_file_name"></result> -->
				<association property="label" javaType="best.gaia.vo.LabelVO" autoMapping="false">
					<result column="LABEL_NO" property="label_no"></result>
					<result column="LABEL_NM" property="label_nm"></result>
				</association>
				<collection property="assigneeList" ofType="best.gaia.vo.MemberVO" javaType="java.util.Set" autoMapping="false">
						<id column="ISSUE_ASSIN_MEM_NO" property="mem_no" />	
						<result column="MEM_ID" property="mem_id"></result>
						<result column="ISSUE_ASSIGN_MEM_PIC" property="mem_pic_file_name"></result>
		<!-- 				<result column="ISSUE_ASIGN_MEM" property="proj_user_nick"></result> -->
				</collection>
				<collection property="historyList" ofType="best.gaia.vo.IssueHistoryVO" javaType="java.util.List" autoMapping="false">
						<id column="ISSUE_HIS_NO" property="issue_his_no" />	
						<result column="ISSUE_HIS_CONT" property="issue_his_cont"></result>
		<!-- 				<result column="ISSUE_ASIGN_MEM" property="proj_user_nick"></result> -->
				</collection>
			</collection>

<select id="selectMilestoneIssueList" resultMap="milestoneMap" parameterType="int" >
		WITH ISSUEINFO AS (
		    SELECT A.ISSUE_SID, B.MEM_NO, M.MEM_ID, A.ISSUE_TITLE,  A.PROJ_NO 
		        , A.MILEST_SID, A.ISSUE_START_DATE, A.ISSUE_END_DATE
		        , A.ISSUE_STATUS
		    FROM ISSUE A
		        LEFT OUTER JOIN ISSUE_ASSIGNEE B ON (A.ISSUE_SID = B.ISSUE_SID)
		        LEFT OUTER JOIN MEMBER M ON (B.MEM_NO = M.MEM_NO)
		        LEFT OUTER JOIN LABEL C ON (A.LABEL_NO = C.LABEL_NO)
		)
		SELECT D.MILEST_SID, D.MILEST_TITLE, D.MILEST_START_DATE, D.MILEST_END_DATE 
		    , D.MILEST_NO, D.MILEST_CONT, D.MILEST_STATUS, D.PROJ_NO
		    , F.ISSUE_SID AS ISSUE_ID, F.MEM_NO AS ISSUE_ASSIN_MEM_NO, F.MEM_ID, F.ISSUE_TITLE
		    , F.MILEST_SID AS MILEST_ID, F.ISSUE_START_DATE, F.ISSUE_END_DATE
		    , F.ISSUE_STATUS 
		FROM MILESTONE D
		FULL OUTER JOIN ISSUEINFO F ON (D.MILEST_SID = F.MILEST_SID)
		WHERE D.PROJ_NO = ${proj_no} OR F.PROJ_NO=${proj_no}
	</select>
```

> 마일스톤 공정률 구하기.

[https://stackoverflow.com/questions/9129928/how-to-calculate-number-of-days-between-two-dates](https://stackoverflow.com/questions/9129928/how-to-calculate-number-of-days-between-two-dates)

- 현재 moment.js를 쓰는 중이니 위의 링크에서 나오는 방법을 사용.

```jsx
var a = moment([2007, 0, 29]); // end_date
var b = moment([2007, 0, 28]); // start_date
a.diff(b, 'days')   // =1
```

- 실제 구현한 코드

```jsx
const calComp = function(start_date, end_date, title){
	let currentTime = new Date();
	let today = moment(YYYYMMDD(currentTime));
	let process
	let total
	let result;
	if(CheckNullUndefined(start_date)){
		start_date = today
	}
	if(CheckNullUndefined(end_date)){
		return "0";	
	}else{
		end_date = moment(end_date);
		start_date = moment(start_date);
		total = end_date.diff(start_date, 'days');
		process = today < start_date ?  0 : today.diff(start_date, 'days');
		result = process<=total ? Math.round((process / total) * 100) : "100"
	}
	return result;
}
```

- 시간이 급박해서 조금 대충 짠 느낌이 있음.
- 추후에 refactoring 할 예정

> .ajax로 받은 데이터를 형식에 맞게 출력해주기

- milestoneList 의 milestone 내부에 issueList가 존재하는 형태.

```jsx
$.each(list, function(i, milestone){
	g.AddTaskItem(new JSGantt.TaskItem(
			milestone.milest_sid 
			, CheckNullUndefined(milestone.milest_title) ? "독립적인 이슈 목록" : milestone.milest_title 
			, milestone.milest_start_date
			, milestone.milest_end_date
			, "ggroupblack"
			, ''
			, 0
			, ""
			, Number(milestone.milest_status) ? "100" : calComp(milestone.milest_start_date,milestone.milest_end_date)
			, 1
				, 0
			, Number(milestone.milest_status) ? "0" : "1"
			, ''
			, ''
			, milestone.milest_cont
			, g 
	));
	$.each(milestone.issueList, function(l, issue){
		console.log(cnt)
		if(CheckNullUndefined(issue)){
			return true;
		}
		g.AddTaskItem(new JSGantt.TaskItem(
			cnt++
			, issue.issue_title
			, issue.issue_start_date
			, issue.issue_end_date
			, Number(issue.issue_status) ? "gtaskred" : "gtaskblue"
			, ''
			, 0
			, CheckNullUndefined(issue.assigneeList) ? "" : calIssueAssignees(issue.assigneeList)
			, Number(issue.issue_status) ? "100" : calComp(issue.issue_start_date,issue.issue_end_date, issue.issue_title)
			, 0
				, milestone.milest_sid
			, 2
			, milestone.milest_sid
			, ''
			, Number(issue.issue_status) ? "Closed" : "Open"
			, g 
		));
	})
});
```

- 실제 구현한 화면

![%5B2021_06_23%5DfullCalendar%20&&%20GanttChart%20API%2026d721fb66ee4ce6a26895ecc4fbcadc/Untitled.png](%5B2021_06_23%5DfullCalendar%20&&%20GanttChart%20API%2026d721fb66ee4ce6a26895ecc4fbcadc/Untitled.png)

> jsGantt.css

- 폰트가 너무 작게 설정 되어 있어서 변경. 9px → 14px
- 각 셀의 height 역시 너무 좁게 잡혀있어서 수정.

# 의문점

---

![%5B2021_06_23%5DfullCalendar%20&&%20GanttChart%20API%2026d721fb66ee4ce6a26895ecc4fbcadc/Untitled%201.png](%5B2021_06_23%5DfullCalendar%20&&%20GanttChart%20API%2026d721fb66ee4ce6a26895ecc4fbcadc/Untitled%201.png)

![%5B2021_06_23%5DfullCalendar%20&&%20GanttChart%20API%2026d721fb66ee4ce6a26895ecc4fbcadc/Untitled%202.png](%5B2021_06_23%5DfullCalendar%20&&%20GanttChart%20API%2026d721fb66ee4ce6a26895ecc4fbcadc/Untitled%202.png)

![%5B2021_06_23%5DfullCalendar%20&&%20GanttChart%20API%2026d721fb66ee4ce6a26895ecc4fbcadc/Untitled%203.png](%5B2021_06_23%5DfullCalendar%20&&%20GanttChart%20API%2026d721fb66ee4ce6a26895ecc4fbcadc/Untitled%203.png)

- 이렇게 쓸모없는 null milestone List가 많이 생겨남.
- 최초의 의도는 null milestone 하나에 list들을 담는것(milestone에 속하지 않은 issue들을 하나의 null milestone에 모두 집어넣을 계획)
- 실제로 최초의 시도때는 하나의 null milestone 안에 issue list 들이 담겨잇었음.
- 추후 시간 날 때 query 혹은 mybatis 부분을 살펴 보아야 겠음.(혹은 질문도 괜찮을 듯함.)
- 조금 쉬운 api를 겉핥기나마 건들이는 것은 이제 크게 두렵지 않음.
- 조금 발전한 기분이 든다.

# SUMMARY

---

1. union과 full outer join은 같다.
2. query를 짤 때 조건절에 대해 조금 더 고민하고 짜야한다.
3. jsGantt Improved는 가벼운 툴이지만 사용하려면 손을 좀 많이 봐야한다.
4. 개인적으로 관련 정보들이 많이 없어서 (심지어 document도 세세하게 설명되어있지 않음. js파일 들어가서 살펴봄) 입맛에 맞게 바꾸기 까다로웠음.

# TOMORROW

---

1. CHATTING CSS 수정
2. overview isseu list 수정
3. 전체적인 css 부분 수정하고 스토리 및 흐름도 수정하기.