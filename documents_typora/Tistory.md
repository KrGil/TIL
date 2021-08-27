# Tistory 꾸미기

highlight.js 직접 넣기

https://highlightjs.org/static/demo/

```
	<!--Syntax Highlighter-->
	<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.1.1/highlight.min.js"></script>
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.1.1/styles/lioshi.min.css">
		<script>hljs.initHighlightingOnLoad();</script>
```



코드 라인 넘버 넣기

```
<!--Code Block Line Number-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/highlightjs-line-numbers.js/2.8.0/highlightjs-line-numbers.min.js"></script>
	<script>
		hljs.initLineNumbersOnLoad();
			$(document).ready(function() {
			$('code.hljs').each(function(i, block) {
				hljs.lineNumbersBlock(block);
			});
		});
	</script>

```



코드블럭 수정하기

```
code {
    border-radius: 5px;
    font-family: "Consolas", "Sans Mono", "Courier", monospace;
    font-size: 1.0rem;
    line-height: 130%;
    margin: 0rem auto;
}
```



코드블럭 주위 수정하기

```
.article-view pre {
    padding: 0px;
    background: rgba(0, 0, 0, 0.05);
    font-size: 16px;
    color: rgba(34, 85, 51, 0.87);
    white-space: pre-wrap;
}
```





코드 라인 넘버 수정

```
	.entry-content > table {
  width: 100%;
  margin-bottom: 22px;
  border: 1px solid #e6e6e6;
  border-collapse: collapse;
  text-align: center;
  font-size: 1em;
  line-height: 1.5714;
  color: #666;
}
.entry-content > table thead th {
  padding: 7px 0 11px;
  border-left: 1px solid #e6e6e6;
}
.entry-content > table tbody tr {
  padding: 7px 0 11px;
  border-left: 1px solid #e6e6e6;
  border-top: 1px solid #e6e6e6;
}
.entry-content > table tbody td {
  padding: 7px 0 11px;
  border-left: 1px solid #e6e6e6;
  border-top: 1px solid #e6e6e6;
}
```



```
.article-view table {
    border: 1px solid #dadce0;
    border-collapse: collapse;
}
 
.article-view table thead tr {
    background: rgba(0, 0, 0, 0.05);
    font-size: 16px;
    color: #000;
}
 
.article-view table tr th,
.article-view table tr td {
    padding: 7px;
    border-left: 1px solid #dadce0;
}
 
.article-view table tr {
    border-bottom: 1px solid #dadce0;
}
```

```
/* for block of numbers */
.hljs-ln-numbers {
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
 
	text-align: center;
	color: #f09;
	border-right: 0px solid #CCC;
	vertical-align: bottom;
	padding-right: 50px;
	font-size: 12px;
	width: 15px;
 
	/* your custom style here */
}
 
/* your custom style here */
.hljs-ln td.hljs-ln-code {
	padding-left: 10px;
	line-height: 1.5;
}
 
/* for block of code */
.hljs-ln-code {
	vertical-align: center;
	padding-left: 50px;
	font-size: 13px;
}
```





https://parkjye.tistory.com/14

https://boltlessengineer.tistory.com/205?category=1133338

https://parkjye.tistory.com/14

https://bagineer.tistory.com/5