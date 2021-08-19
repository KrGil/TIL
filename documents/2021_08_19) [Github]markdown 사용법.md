# Header

# this is a H1

## this is a H2

### this is a H3

> h3부터는 언더라인이 없습니다.
>
> ####### H7은 지원하지 않습니다.

```
# this is a H1
## this is a H2
### this is a H3
```



# blockqute

> this is a blockqute.
>
> > this sis a blockquet.
> >
> > > 이렇게 계속해서 늘어날 수 있습니다.

```
> this is a blockqute.
>> this is a blockqute.
>>> 이렇게 계속해서 늘어날 수 있습니다.
```



# Numbers

1. 이렇게
2. 계속 늘어납니다.



101. 특정 번호부터
102. 계속 늘어납니다.

```
1. 이렇게 
2. 계속 늘어납니다.

101. 특정 번호부터
102. 계속 늘어납니다.
```



# List

* 이렇게 리스트 가능!
  + 플러스
    + 도 가능합니다.
    + 혹은 그냥 탭을 쓰셔도 되요.
  + alt+ tab이나요!

```
* 이렇게 리스트 가능!
	+ 플러스
		- 도 가능합니다.
		- 혹은 그냥 탭을 쓰셔도 되요.
	+ alt + tab이나요!
```



# Code

> Using Tab

this is a normal paragraph:

​	this is a code block.

end code block.

먹힌다는데 Typora에서 작성중인데 안먹히네요.

> Using <pre><code></code></pre>

<pre>
    <code>
    	public class BootSpringBootApplication{
    		public static void main(String[] args){
    			System.out.println("Hello, Honeymoon");
    		}
    	}
    </code>
</pre>

> Using ```

````java
```java
public class BootSpringBootApplication{
    public static void main(String[] args){
    	System.out.println("Hello, Honeymoon");
    }
}
```
````



# 수평선

***

---

```
***
---
```



# 링크

> 참조링크

Link: [Tistory][tistorylink]

[tistorylink]: https://jjam89.tistory.com "myBlog"

```
[link keyword][id]

[id]: URL "Optional Title here"

// code
Link: [Tistory][tistorylink]

[Tistory]: https://jjam89.tistory.com "myBlog"
```

> 외부링크

Link: [Github](https://github.com/KrGil?tab=repositories, "myGithub")

```
사용문법: [Title](link)
적용예: [Github](https://github.com/KrGil?tab=repositories, "myGithub")
```

> 일반링크

Link: <http://example.com/>

E-mailLink: address@example.com

```
일반적인 URL 혹은 이메일주소인 경우 적절한 형식으로 링크를 형성한다.

* 외부링크: <http://example.com/>
* 이메일링크: <address@example.com>
```

