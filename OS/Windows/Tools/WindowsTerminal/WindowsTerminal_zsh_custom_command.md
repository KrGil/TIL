### Windows terminal(git bash)에서 "open" command로 해당경로 폴더 열기



## Before we go any further...

저는 맥을 오래 사용해서 그런지 cmd에서 ```open .```커맨드를 자주 사용해서 finder(folder)를 실행시켰습니다. 

Windows에는 ```start``` 라는 커맨드가 존재하지만 이게 도무지 익숙해 지질 않더군요... 

이번에도 start 명령어를 까먹어서 한참이나 삽질 한 후에 ~~화가나서~~ Windows 환경에서 ``` open```  명령어를 적용시키기로 했습니다.



## Goal

1. Windows terminal 설치 및 Git Bash 추가하기

    https://jjam89.tistory.com/136

2. zsh 설치하기

    https://jjam89.tistory.com/150

3. ~/.zshrc 수정하기

###### *zsh가 설치되어있지 않으면 ~/.bashrc를 수정하시면 될 거라 생각합니다.* 

### ~/.zshrc 수정

- 앞의 과정을 모두 따라하셨다면 ```vim``` 으로 .bashrc 파일을 실행시킨다면  아래의 코드가 작성되어 있을 것 입니다.

```
$ vim ~/.bashrc

# Launch Zsh 
if [ -t 1 ]; then 
    exec zsh 
fi
```

###### *cmd 실행 시 zsh 로 실행하겠다는 코드입니다.*

- 이제 ```vim``` (vscode, notepad 등을 사용하셔도 무방합니다.)를 이용하여 .zshrc 파일을 수정합니다.

```
# User configuration
open() {
    start "$@"
}
```

###### vim 혹은 vi로 파일을 여셨다면 a -> 방향키 -> ctrl+v -> exc -> ":wq" 를 하시면 됩니다 ㅎㅎ

###### ~~google에 검색하세요!!~~

![image-20210825170252074](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/WindowsTerminal/WindowsTerminal_zsh_custom_command.assets/image-20210825170252074.png)

### 여기서 source <path>를 해 주셔야 바로 적용됩니다.

```
$ source ~/.zshrc
```

- 변경사항을 바로 적용시키는 명령어입니다.



## 실행하기

- 이렇게 ```open``` 명령어를 못찾겠다는 경고문이

![image-20210825170633016](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/WindowsTerminal/WindowsTerminal_zsh_custom_command.assets/image-20210825170633016.png)

- folder도 잘 열고 잘 실행되는 것을 볼 수 있습니다.

![image-20210825170822471](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/WindowsTerminal/WindowsTerminal_zsh_custom_command.assets/image-20210825170822471.png)



## Notice

Windows Terminal을 쓰신다면 다양한 terminal들을 쓰실탠데(git bash, 명령프롬프트, ubuntu, powershell...) 서로의 설정을 공유하지 않는 듯 합니다. 

그러니 각각 설정을 따로 해 주셔야 합니다 ㅎㅎ



### MORE

#### Alias 사용하기

> 댓글로 alias를 사용해서 좀 더 쉽게 설정하는 방법을 알려주셔서 좀 더 끄적여 봅니다~

    alias open=start
![image-20220128090232501](C:\Users\Eisen\Documents\GitHub\TIL\OS\Windows\Tools\WindowsTerminal\WindowsTerminal_zsh_custom_command.assets\image-20220128090232501.png)

위의 이미지와 같이 작성하면 됩니다!

```~/.zshrc ``` 파일 자체에서 수정해도 되고 $ZSH_CUSTOM의 하단에 .zsh파일을 따로 생성하여 저처럼 alias만 모아두는 파일을 생성한 후 작성하셔도 됩니다!

_참고로 bash를 사용하시는 분들은 ~/.bashrc 파일에 위의 문구를 작성하시면 됩니다!_ 
