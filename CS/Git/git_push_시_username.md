# Git push 시 username과 userpass를 물어볼 때

> 예전에 한번 이런 경우가 발생해 검색 후 해결했었습니다. 그 때 당시에는 별 생각없이 해결하고 넘어갔었는데 또다시 이런 경우가 발생하여... 기록에 남기려고 합니다. 
>
> 역시 기억력은 믿을게 못되나 봅니다.

### 상태

![image-20211122091204978](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git/git_push_시_username.assets/image-20211122091204978.png)

위의 사진처럼 ```git remote -v``` 명령어 입력 시 https:// 주소로 되어 있을 시 ```git push``` 할 경우 Username과 Userpass를 묻는것으로 확인됩니다.

따라서 ssh를 등록한 후 [(git ssh 등록 링크)](https://github.com/settings/keys)  아래처럼 해당 repository의 Clone -> SSH의 주소를 복사합니다.

![image-20211122091338537](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git/git_push_시_username.assets/image-20211122091338537.png)

### git remote 재설정하기

```
git remote set-url origin git@github.com:username/repo.git

// 예시
git remote set-url origin git@github.com:KrGil/jpa_study.git
```

![image-20211122091759131](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git/git_push_시_username.assets/image-20211122091759131.png)

위의 명령어를 입력한 후 ``` git remote -v``` 로 확인하면 ```https://...``` 로 시작하던 url이 ```git@...``` 으로 변경된 것을 알 수 있습니다. 그 후 ``` git push``` 를 하면 더이상 Username과 Userpass를 물어보지 않고 push가 성공하는것을 볼 수 있습니다.



### References

https://stackoverflow.com/questions/6565357/git-push-requires-username-and-password