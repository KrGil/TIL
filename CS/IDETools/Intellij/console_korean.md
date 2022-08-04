# [IntelliJ] console탭 한글 깨질 시

`control + ,` settings -> Editor -> File Encodings



![image-20220804140837942](C:\Users\Eisen\Documents\GitHub\TIL\CS\IDETools\Intellij\console_korean.assets\image-20220804140837942.png)

`double shift` -> Edit Custom VM Options... -> 

```
-Dfile.encoding=UTF-8
-Dconsole.encoding=UTF-8
```

![image-20220804141530004](C:\Users\Eisen\Documents\GitHub\TIL\CS\IDETools\Intellij\console_korean.assets\image-20220804141530004.png)



껐다 키기

![image-20220804141653275](C:\Users\Eisen\Documents\GitHub\TIL\CS\IDETools\Intellij\console_korean.assets\image-20220804141653275.png)



### Reference

https://velog.io/@hsjung2015/Intellij-or-Eclipse%EC%BD%98%EC%86%94%EC%B0%BD%EC%97%90-%ED%95%9C%EA%B8%80%EC%9D%B4-%EA%B9%A8%EC%A0%B8%EC%84%9C-%EB%82%98%EC%98%AC%EB%95%8C-%EC%B5%9C%ED%9B%84%EC%9D%98-%EB%B0%A9%EB%B2%95