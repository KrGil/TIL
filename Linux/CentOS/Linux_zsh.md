# CentOS7에 oh_my_zsh 설치하기

https://nitocin.tistory.com/entry/ohmyzsh-%EC%98%A4%ED%94%84%EB%9D%BC%EC%9D%B8-%EC%84%A4%EC%B9%98

### zsh와 git 설치

아래 코드 실행

```
yum -y install git-core zsh
```

설치 확인하기

```
zsh
```

```zsh``` 실행 시 아무런 메시지가 뜨지 않으면 설치가 완료된 것입니다.



### Oh_my_zsh 설치

#### 설치위치 지정 설치(/usr/local/.oh-my-zsh)

```
export ZSH="/usr/local/.oh-my-zsh"; sh -c "$(curl -fsSL https://raw.githubusercontent.
com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```

*위와 같이 설치해 주는 이유는 위치를 따로 지정하지 않았을 시 기본적으로 사용자 home 디렉토리 아래에 설치됩니다. root계정으로 설치시 /root/.oh-my-zsh에 설치가 되는데 일반 계정 사용자는 oh-my-zsh 사용 시 /root/.oh-my-zsh를 참조하게 되는데 일반 계정은 /root/에 접근할 수 없는 문제가 생깁니다.* 



#### curl 사용 기본 설치

```
sh -c "$(curl -fsSL https://raw.githubusercontent.
com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```



### 기본 설치 경로 변경으로 설치 시

```
export ZSH_CUSTOM=$ZSH/custom
```

```~/.zshrc```에서 위의 코드를 붙여넣어줍니다.

```
vim ~/.zshrc
```

```  env | grep ZSH_CUSTOM``` 명령어를 실행시켜 잘 적용되었는지 확인합니다.

```
$ env | grep ZSH_CUSTOM
ZSH_CUSTOM=/usr/local/.oh-my-zsh/custom
```

위와 같이 뜨지 않고 아무것도 뜨지 않으면 적용이 되지 않았으니 다시 확인해 주셔야 합니다.





### 테마 설정

테마는 ```powerleve10k``` 를 사용하겠습니다.

처음 zsh를 설치할 때 ```git``` 역시 같이 설치했기에 git 명령어를 사용할 수 있습니다.

```
git clone --depth=1 https://github.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k
```

설치가 모두 되었다면 ```.zshrc`` 파일을 수정합니다.

```
vim ~/.zshrc
```

```ZSH_THEME```을  ```"powerlevel10k/powerlevel10k"```으로 변경합니다.

``` powerlevel10k
ZSH_THEME="powerlevel10k/powerlevel10k"
```

```reboot``` 으로 서버를 재시작 시켜 줍니다.



그 후 powerlevel10k 기본 설정을 따라하시면 됩니다.



### zsh 버전이 낮다고 뜰 때

https://gist.github.com/Semo/378fba2516a31f2608f0ad0161a73ab7



### root가 아닌 다른 사용자로 전환할 때

#### zsh 경로 설정

현재 사용자의 zsh의 경로가 잘못 잡혀 있어 ```zsh``` 명령어가 먹히지 않을 시

```
vim /etc/shells
```

위에 설정해 둔 ```zsh``` 경로를 추가합니다. i.g)```/usr/local/bin/zsh```

그 후 아래의 명령어를 실행합니다.

```
chsh -s /usr/local/bin/zsh -USER
```

적용이 잘 되어 있는지 확인해 줍니다.

```
which zsh
```







#### root의 zsh 설정을 그대로 적용시키고 싶다면(theme)

```cp``` 명령으로 ~/.zshrc를 /home/user/.zshrc로 복사해 줍니다.

root 계정으로 ```.zshrc```가 존재하는 아래의 작업을 실행합니다.

```
cp .zshrc /home/USER/.zshrc
```

**실행 예시**

``` cp .zshrc /home/eisen/.zshrc``` USER에 계정명을 작성해 주시면 됩니다.



### powerlevel10k 재설정 명령어

powerlevel10k 설정이 마음에 들지 않을 시 아래의 명령어를 실행합니다.

```
p10k configure
```



### zsh에 alias 설정하기

```~/.zshrc``` 에 각각 설정해도 되지만 ```/etc/zshrc```를 수정하면 따로따로 설정하지 않아도 모든 사용자가 동일한 ```alias```를 사용할 수 있습니다. 

```
vim /etc/zshrc
```

본인이 원하는 alias를 추가해 보시기 바랍니다.

```
alias c='clear' 

alias b='cd ..' 
alias bb='cd ../..' 
alias bbb='cd ../../..' 
alias bbbb='cd ../../../..' 

alias rma='rm -rf'
```

수정 이후 source /etc/zshrc로 적용시키던, ```reboot```으로 재부팅 하시고 사용하시면 됩니다.

```alias``` 명령으로 현재 적용되고 있는 alias들을 볼 수 있습니다.
