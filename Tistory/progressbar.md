

# 티스토리 꾸미기(1)_상단_프로그레스바_스크롤바_진행바

### 상단에 progressbar 표시하기

> 프로그레스바, 진행바, 스클로바 등등으로 불립니다.
>
> 적용하는 방법은 매우 간단합니다.
>
> 복사해서 붙여넣기만 하면 됩니다.
>
> 그럼 시작하겠습니다.



### code

---



```html
<!--상단 프로그레스바 스크립트 시작--> 
<script type="text/javascript" src="https://rawcdn.githack.com/mburakerman/prognroll/0feda211643153bce2c69de32ea1b39cdc64ffbe/src/prognroll.js"></script> 
<script type="text/javascript"> 
    $(function() { 
        $("body").prognroll({ height: 5, color: "#555" }); 			
        $(".content").prognroll({ custom: true });
    }); 
</script>
```

위의 코드를 복사한 후 꾸미기 -> 스킨 편집 -> html 편집

HTML에서 <head> 안에 붙여넣기 하시면 됩니다.

### !Caution!

---



저 같은 경우 <head> 바로 밑에 위의 코드를 붙여넣으니 

```html
prognroll.js:1 Uncaught TypeError: Cannot read property 'fn' of undefined
    at prognroll.js:1
    at prognroll.js:3
```

이런 오류가 발생하더군요. 그래서 저는 </head> 바로 위에다 붙여 넣었더니 잘 작동하네요.

*jQuery를 사용하는 듯 합니다. 그게 없어서 발생하는 오류인가 싶었는데 jQuery 불러오는 스크립트를 빼고 확인했는데 아닌 듯 하더군요.*..



### Setting

---

```html
 $("body").prognroll({ height: 5, color: "#555" }); 			
```

위의 ``` height```와 ```color```을 수정하시면 됩니다.

```height```는 프로그레스바의 두께, ```color```는 색상을 조절합니다.

```color```의 경우 구글 사이트에 [#000000](https://www.google.com/search?q=%23000000&oq=%23000000&aqs=chrome..69i57.1325j0j15&sourceid=chrome&ie=UTF-8) 혹은 [adobe color](https://color.adobe.com/ko/create/color-wheel) 검색하시거나 해당 링크를 타시면 본인이 원하는 색상을 검색할 수 있습니다.



### 최종 코드입니다.

```html
<!--상단 프로그레스바 스크립트 시작--> 
	<script type="text/javascript" src="https://rawcdn.githack.com/mburakerman/prognroll/0feda211643153bce2c69de32ea1b39cdc64ffbe/src/prognroll.js"></script> 
	<script type="text/javascript"> 
		$(function() { 
			$("body").prognroll({ height: 5, color: "#fccb4f" }); 			
			$(".content").prognroll({ custom: true });
		}); 
	</script>
```

제가 선택한 색상은 gingerline 입니다.

![image-20210830171746178](https://raw.githubusercontent.com/KrGil/TIL/main/documents_typora/Tistory/progressbar.assets/image-20210830171746178.png)



# reference

https://esef.tistory.com/403#:~:text=%EB%B6%89%EC%9D%80%EC%83%89%EC%9C%BC%EB%A1%9C%20%ED%91%9C%EC%8B%9C%ED%95%9C,%EB%84%A3%EA%B8%B0%EB%A7%8C%20%ED%95%98%EB%A9%B4%20%EB%81%9D%EC%9E%85%EB%8B%88%EB%8B%A4.

