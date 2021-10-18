# Element.innerHTML는 <script>를 실행시키지 않습니다.



### innerHTML

innerHTML의 경우 기본적으로 <script> 태그를 일반 text 문자로 인식하게끔 되어 있습니다. 이는  

https://www.w3.org/TR/2008/WD-html5-20080610/dom.html#innerhtml0 해당 링크에서 나와 있듯이

> script elements inserted using innerHTML do not execute when they are inserted.

code injection과 같은 경우를 방지하기 위해서라는군요.



따라서 ajax로 페이지를 붙일 때 innerHTML을 제외하고 <script> 를 적용 시키는 방법은 총 2가지가 있습니다.

1. elemental.innerHTML=string 대신 jQuery의 $(elemental).html(string)을 사용하면 됩니다.

2. <script> 객체를 생성해서 DOM 에 직접적으로 넣어주면 됩니다.

   ```js
   const script = document.createElement("script"),
     text = document.createTextNode("console.log('foo')");
   
   script.appendChild(text);
   document.body.appendChild(script);
   ```



### References

https://stackoverflow.com/questions/49867200/why-doesnt-a-browser-run-a-script-in-an-html-fragment-retrieved-via-fetch-api