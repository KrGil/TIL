# Vim 명령어

### Preview

- vim을 조금 더 효율적으로 사용하기 위한 명령어들



### 읽기 전용(read-only)

- view
- -R
- -M

> view command. 

```
view test.txt
```

수정 후 저장하고 싶다면 ```w!``` 로 강제 저장 할 수 있습니다.

*view로 파일을 여는 것이기에 일반 편집기능인 vim과 보여지는 화면이 조금 다릅니다.*



> -R command

``` 
vim -R test.txt
```

```-R``` 역시 저장하고 싶다면 ```w!```로 강제 저장 할 수 있습니다.



> -M command

```
vim -M test.txt
```

강제로 ```write``` option을 끄고 실행시킵니다. 그래서 편집, 저장이 불가능합니다.



본인의 상황에 맞춰서 쓰면 됩니다.
