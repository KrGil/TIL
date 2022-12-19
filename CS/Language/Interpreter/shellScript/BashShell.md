Shell Command

```shell
$ git branch --merged | grep -v -P '(develop|master)' | xargs git branch -D
```





## .bat 파일들 mv로 이동시키기

````shell
 ls | grep -P '(\.bat)' | xargs mv -t  ./batchfiles
````





