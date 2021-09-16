# Git Command

### 	1. ```git diff```



## README

[something]의 ``` [  ] ``` 표시는 생략해도 된다는 의미입니다.

<something>의 ```<>``` 표시는 생략하면 안되고 something자리에 지칭하는 값을 넣으셔야 합니다.



## git pull 하기 전에 리모트와의 변경점 확인하기

```
git diff HEAD <remoteName>/<branchName>
```

local의 최신 commit과 remote repo와의 변경점을 볼 수 있습니다.

i.g)  ```git diff HEAD origin/master``` 

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



## 특정 commit의 변경점 확인하기

```
git diff <commitHash>^
```

위의 ``` git diff HEAD^``` 를 보면 같은 기능이라는 것을 알 수 있습니다.



## 브랜치끼리 비교하기

```
git diff <branchNameA> <branchNameB>
```

Pull Request를 보내기 전에 mainBranch와의 변경점을 확인할 때 사용됩니다.



## 특정 1개의 파일의 변경점 확인하기

```
git diff -- <filePath>
```

git add 하기 전에 특정한 파일의 변경점을 확인하고자 할 때 사용됩니다.

디렉토리 비교도 가능합니다.

### 다른 브랜치와의 특정 파일 비교하기

```
git diff <branchNameA> <branchNameB> --<filePath>
```



## 다른 파일끼리 비교하기

```
git diff -- <filePathA> <filePathB>
```



## 어느정도 변경되었는지만 확인하기

```
git diff --stat
```

sourceCode나 git desktop과 같이 한 눈에 변경 내역을 볼 수 있습니다.

변경 숫자는 라인으로 표시해 줍니다. (개인적으로 상당히 유용하다 생각합니다.)





