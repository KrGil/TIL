# Git Command

### 	1. ```git diff```





## git pull 하기 전에 리모트와의 변경점 확인하기

```
git diff HEAD <remoteName>/<branchName>
```

local의 최신 commit과 remote repo와의 변경점을 볼 수 있습니다.

*``` git fetch``` 이후 사용*



## git push 하기 전에 리모트와의 변경점 확인하기

```
git diff <remoteName>/<branchName> HEAD
```

local의 최신 commit과 remote repo와의 변경점을 볼 수 있습니다.

(실행 결과는 위와 동일한 것으로 보입니다.)



## git add 전에 변경점 확인하기

```
git diff
```



## git add 이후 변경점 확인하기

```
git diff --cached
git diff --staged
```

두 command 모두 동일한 결과를 내줍니다.



## 방금 git commit 한 변경점 확인하기

```
git diff HEAD^ [HEAD]
```

``` cherry-pick ```시 어떤 파일이 변경되었는가를 조사하고 싶을 때도 이 커맨드로 확인할 수 있습니다..



## commit 끼리 비교하기

```
git diff <commitHash> <commitHash>
```

``` git log``` 시 뜨는 commit 의 고유 hash 번호. __*앞의 7글자만 적어도 됩니다.*__



