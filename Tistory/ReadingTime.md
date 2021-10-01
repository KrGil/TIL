# [Tistory] Tistory 꾸미기(2)_ReadingTime 적용

###



![image-20210918160955254](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918160955254.png)



![image-20210918161251925](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918161251925.png)



![image-20210918161233564](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918161233564.png)



![image-20210918161559212](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918161559212.png)



![image-20210918161915023](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918161915023.png)





![image-20210918162034554](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918162034554.png)



```html
<!-- Reading Time -->

	<!-- <script src="/js/plugins/readingtime.js"></script> -->
	
	<script src="./images/readingtime.js"></script>
```



![image-20210918162627438](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918162627438.png)



```
<script>
	<!-- readingTime -->
	$(function(){
		// reading-time.js 발동
    $('.article-view').readingTime({
        readingTimeAsNumber: false,
        readingTimeTarget: $('.eta'),
        wordsPerMinute: 300,
        round: true,
        prependTimeString: '💻 읽는시간 : ',
        lang: 'kr'
    });
	})
</script>
```



![image-20210918163427736](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918163427736.png)

![image-20210918164147075](/Users/Eisen/Documents/GitHub/TIL/Tistory/ReadingTime.assets/image-20210918164147075.png)







### References

https://github.com/michael-lynch/reading-time

https://shanepark.tistory.com/225(강추)