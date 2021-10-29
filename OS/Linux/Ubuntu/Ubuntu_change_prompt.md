# Ubuntu agnoster 테마 프롬프트 변경하기

### 목차

- ```~/.oh-my-zsh/themes/agnoster.zsh-theme`` 파일 열기(vim)
-  ```prompt_dir()```, ```prompt_context()``` 변경하기.



### 전체 경로를 현재 위치만으로 설정하기

> ```~/Documents/testFile``` -> ```testFile```  

기존에 있는 텍스트 파일을

```
# Dir: current working directory
prompt_dir() {
  prompt_segment blue black '%~'
}
```

아래와 같이 수정.

```
 prompt_dir() {
  prompt_segment blue $CURRENT_FG '%c'
}
```

그럼 현재 위치한 경로만 볼 수 있습니다. 만일 현재 경로가 궁금하시면 ```pwd``` 커맨드로 확인 하실 수 있습니다.



### UserName 부분 변경하기

기본 설정된 아래의 부분을 

```
#prompt_context() {
 # if [[ "$USERNAME" != "$DEFAULT_USER" || -n "$SSH_CLIENT" ]]; then
  #  prompt_segment black default "%(!.%{%F{yellow}%}.)%n@%m"
 # fi
#}
```

아래와 함께 변경해 주시면 됩니다.

```
prompt_context() {
  if [[ "$USERNAME" != "$DEFAULT_USER" || -n "$SSH_CLIENT" ]]; then
    prompt_segment black default "👾"
  fi
}
```



만약 특정 theme이 아니라 전체적은 것을 수정하고 싶으시다면 theme이 아닌 zsh 자체 설정을 변경해 주시면 됩니다. 해당 관련 포스트는 추후에 직접 해 본 후 정리해서 올리도록 하겠습니다.

