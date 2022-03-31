# Git Command

## 	List
 	1. ```git diff```

 2. ``` git log```

 3. ```etc```

    

## Notice

[something]의 ``` [  ] ``` 표시는 생략해도 된다는 의미입니다.

<something>의 ```<>``` 표시는 생략하면 안되고 something자리에 지칭하는 값을 넣으셔야 합니다.



## ``` git diff```

### git pull 하기 전에 리모트와의 변경점 확인하기

```
git diff HEAD <remoteName>/<branchName>
```

local의 최신 commit과 remote repo와의 변경점을 볼 수 있습니다.

e.g)  ```git diff HEAD origin/master``` 

*``` git fetch``` 이후 사용*



### git push 하기 전에 리모트와의 변경점 확인하기

```
git diff <remoteName>/<branchName> HEAD
```

local의 최신 commit과 remote repo와의 변경점을 볼 수 있습니다.

(실행 결과는 위와 동일한 것으로 보입니다.)



### git add 전에 변경점 확인하기

```
git diff
```



### git add 이후 변경점 확인하기

```
git diff --cached
git diff --staged
```

두 command 모두 동일한 결과를 내줍니다.



### git add 이전 변경점 확인하기

```
git diff --stat
```





### 방금 git commit 한 변경점 확인하기

```
git diff HEAD^ [HEAD]
```

``` cherry-pick ```시 어떤 파일이 변경되었는가를 조사하고 싶을 때도 이 커맨드로 확인할 수 있습니다..



### commit 끼리 비교하기

```
git diff <commitHash> <commitHash>
```

``` git log``` 시 뜨는 commit 의 고유 hash 번호. __*앞의 7글자만 적어도 됩니다.*__



### 특정 commit의 변경점 확인하기

```
git diff <commitHash>^
```

위의 ``` git diff HEAD^``` 를 보면 같은 기능이라는 것을 알 수 있습니다.



### 브랜치끼리 비교하기

```
git diff <branchNameA> <branchNameB>
```

Pull Request를 보내기 전에 mainBranch와의 변경점을 확인할 때 사용됩니다.



### 특정 1개의 파일의 변경점 확인하기

```
git diff -- <filePath>
```

git add 하기 전에 특정한 파일의 변경점을 확인하고자 할 때 사용됩니다.

디렉토리 비교도 가능합니다.

#### 다른 브랜치와의 특정 파일 비교하기

```
git diff <branchNameA> <branchNameB> --<filePath>
```



### 다른 파일끼리 비교하기

```
git diff -- <filePathA> <filePathB>
```



### 몇개의 파일이 몇 줄 변경되었는지 확인하기

```
git diff --stat
```

sourceCode나 git desktop과 같이 한 눈에 변경 내역을 볼 수 있습니다.

변경 숫자는 라인으로 표시해 줍니다. (개인적으로 상당히 유용하다 생각합니다.)



### 파일명만 확인하기

```
git diff --name--only
```



### 개행 코드나 공백 무시하기

```
git diff -w
```



### 변경점 전후에 표시되는 행 수 변경하기

```
git diff -U10
```

변경 전후의 행수 설정. U0으로 하면 전후의 행수가 0이 되어 보이지 않습니다.



### 단어 단위로 비교하기

```
git diff --color-words
```

행 단위가 아닌 단어 단위로 비교해 줍니다.(2줄로 -, +로 표시 되는 것이 그냥 한줄로 색상만 변경되어 표시됩니다.)



### 두 개의 파일 비교

```
diff -urN [타겟1] [타깃2]
```

> -b : 연속된 공백 무시
>
> -i  : 대소문자를 구분하지 않음
>
> -t  : 출력 라인에 TAB 문자를 넣음
>
> -w : 두 행의 비교 시 공백을 무시
>
> --brief : 파일 비교 후 결과 표시(같은지, 다른지)
>
> -d : 세세한 차이까지 검색
>
> -H : 큰 파일을 빠르게 처리할 때 사용
>
> -q : 두 파일의 차이점만 출력
>
> -s  : 두 파일이 같은 지 확인
>
> -r  : 두 디렉토리의 차이점 출력
>
> -u : undirectional new file 옵션으로 비교하는 파일/디렉토리가 빠져있을 경우 dummy로 처리해서 출력을 통일시킴
>
> -r  : recursive 하위 디렉토리 모두 검색
>
> -N : 검색 중 new file도 적용 가능

두 개의 파일을 비교해 줍니다.

#### References

https://eehoeskrap.tistory.com/248





## git log

### 요약하기

```
git log --pretty="%h %s" --graph
```

```%h``` 요약해쉬 7글자

```%s``` commit의 첫 번째 줄

```--graph``` 그래프 보여주기





### log 조회 범위 설정

```
git log --before=<number..>

git log --since=<number..>

git log --since=1month
```



### 특정 브랜치 log 조회하기

```
git log <origin/master>
```

특정 브랜치 log 보기



### 특정 작성인으로 로그 검색하기

```
git log --author=<name>

git log --author=<name> --grep=<name>
```



## etc

### git stash

```
git stash
```

untracked 파일은 되지 않습니다. git add 이후에 stash를 해야 모두 적용됩니다.

```
git stash pop
```

pop  시 모든 상태가 unstaged로 변경됩니다.(add 이전 상태로 변경됩니다.)



### 이전 commit message 사용하기

```
git commit -c HEAD 
```

```HEAD^``` , hash 등을 사용할 수 있습니다.



### git config list 보기

```
git config --list
```



```
git config --global --list
```

본인의 git 설정들을 볼 수 있습니다. 또한 ```--global``` 옵션을 추가하면 global 적용 옵션들만 따로 볼 수 있습니다.



## Git rebase

### commit 순서 바꾸기

```
git rebase -i HEAD~3
```

개인적으로 rebase의 경우 쓰기가 상당히 까다로운 듯 합니다.

- pick

  커밋을 선택(순서 변경)

- reword

  커밋 메시지 변경 -> 메시지 변경 editor 창이 뜸.

- edit

  커밋 메시지, 커밋 작업 내용 변경.

  변경할 커밋으로 checkout 되서 작업내용 수정 후 `git add ` -> `git commit ...` -> `git rebase --continue` 로 진행.

- squash

  해당 커밋을 앞 커밋과 합친다. 앞 커밋의 메시지가 남는다.

- fixup

  해당 커밋을 앞 커밋과 합치지만 본인의 커밋 메시지가 남는다.

- exec

  ?

- drop

  커밋 히스토리에서 커밋을 삭제.

### References

https://hajoung56.tistory.com/5



### ~와 ^

```
git show HEAD^
git show HEAD^^
git show HEAD~1
```

^의 경우 바로 전을 의미하고

~1 등의 숫자일 경우 범위를 지정할 때 많이 사용합니다.

```
git log HEAD^..HEAD
```

HEAD로부터 한개 전까지.

### 특정 브랜치를 내 브랜치로 merge하기

```
git merge <branch>
```

특정 브랜치에 있는 커밋들을 가지고 옵니다.

```
git merge -n master
```

```master``` 브랜치에 존재하는 커밋들을 unstaged 상태로 가지고 옵니다.



## git config

### git status 시 한글 안될 때.

```
git config --global core.quotepath false
```

```"\354\204\254\354\227\260\352\262\260\355\225\230\352\270\260.cpp"``` git status 시 이런식으로 path가 출력될 때 사용하시면 한글로 변환되어서 출력됩니다.



