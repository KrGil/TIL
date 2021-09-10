# CentOS7에 oh_my_zsh(zsh) 설치하기



# Before we go further

### 하나 

본인이 <u>**하나의 계정에만 설정을 적용할 것**</u>인가 아니면 <u>**모든 계정에게 설정을 적용할 것**</u>인지 두가지를 알고 계서야 합니다.(<u>*서로 설정하는 파일이 다릅니다.*</u>)

<u>*하나의 계정에만*</u> 설정 적용하기

​	``` ~/.zshrc``` 		//zsh

​	``` ~/.bashrc ```		// bash

<u>*모든 계정에게*</u> 설정 적용

​	``` /etc/zshrc ```		// zsh

​	```/etc/bashrc ```		// bash

위의 내용을 유의하시고 밑의 내용을 따라하실 때 본인의 상황에 맞춰서 수정해 주시길 바랍니다.

### 둘 

> bash

CentOS7에서 ```bash``` 는 ```~/.bashrc```, ``` ~/.bash_profile```, ```/etc/bashrc``` 파일을 가지고 있습니다.

```~/.bashrc```(개인설정파일) 은 ```/etc/bashrc```(전역설정파일) 을

``` ~/.bash_profile``` 은 ```~/.bashrc```  을 부름으로 서로서로 꼬리를 물고 있습니다.

> zsh

```zsh```는 ```~/.zshrc```, ```/etc/zshrc```, ```$ZSH_CUSTOM``` 파일을 가지고 있습니다.

``` $ZSH_CUSTOM```의 경로는 ```.oh-my-zsh``` 설치 시 보통 ```/usr/local/.oh-my-zsh/custom``` 에 있습니다.(환경변수가 존재하지 않는다면 설정해 주시면 됩니다.) 

### 셋

하나의 파일을 수정한 후 변경사항이 먹히지 않은 듯 한다면 ```source ~/.zshrc/```, ```source /etc/zshrc``` 을 실행해 봅니다.





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

위와 같이 뜨지 않고 아무것도 뜨지 않으면 적용이 되지 않았으니 환경변수를 확인해 주셔야 합니다.



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

alias =

```

수정 이후 source /etc/zshrc로 적용시키던, ```reboot```으로 재부팅 하시고 사용하시면 됩니다.

```alias``` 명령으로 현재 적용되고 있는 alias들을 볼 수 있습니다.



### Bash 설정 zsh에 적용

- 두가지 방법이 존재합니다. 
    1. ``` source ~~~```을 사용하여 ```zsh``` 설정에 ```zsh``` 실행 시 ```bash```를 실행 명령문 삽입
    2. ```bash``` 의 내용을 ```zsh```에 복사 붙여넣기
- 개인적으로 2번째 방법을 추천드립니다.(*실행에 문제는 없지만 오류가 뜹니다*)

#### bash로 모든 계정 공통으로 설정하기

``` /etc/bashrc ``` 에 설정 

```~/.bashrc```가 실행될 때 전역 설정인 ```/etc/bashrc```을 실행,  ```~/.bash_profile```이 ```~/.bashrc```을 실행시킵니다.

#### 하나의 계정에만 적용

``` ~/.zshrc``` 파일 수정

```
$ vim ~/.zshrc

source ~/.bash_profile
```

``` source ~/.bash_profile```을 추가해 주시면 됩니다.



#### 모든 계정에 공통적으로 적용

- 두가지 방법이 존재하며, 공식적으로는 2번 방법을 추천하고 있습니다.

1.```/etc/zshrc``` 파일 수정

```
$ vim /etc/zshrc

source ~/.bash_profile
```

공통으로 적용시키는 것 역시 ``` source ~/.bash_profile ``` 코드를 작성 파일 ``` /etc/zshrc ``` 에 추가해 주시면 됩니다.



2.``` /usr/local/.oh-my-zsh/custom ``` 에서 ```anyname.zsh``` 파일을 생성하시면 됩니다.

위의 과정을 정확히 따라오셨다면 ``` echo $ZSH_CUSTOM ``` 명령을 입력했을 시 ```/usr/local/.oh-my-zsh/custom``` 이라는 결과가 나오셨을 겁니다.

```
$ echo $ZSH_CUSTOM

/usr/local/.oh-my-zsh/custom
```

혹은 개인적으로 수정한 경로가 있다면 그 경로가 뜰 것입니다. 그 경로로 이동하여 ```.zsh``` 파일을 생성하여 ```~/.bash_profile``` 에 적용된 alias 나 PATH 들을 붙여넣으시면 됩니다.





#### 첫번째 방법 적용 시의 오류(실행에는 아무런 문제가 없습니다... 다만 찜찜할 뿐.)

```
source ~/.bash_profile
```

혹은

```
if [ -f ~/.bash_profile ]; then
        . ~/.bash_profile
fi
```

을 사용하여 ```~/.zshrc``` 파일에 추가하게 된다면 아래와 같은 로그가 뜹니다.

*실행환경이 ```zsh``` 이기에 ```bash``` 환경에서만 작동하는 명령어가 실행이 안됨으로 오류 발생.*

```
/etc/bashrc:37: command not found: shopt
/etc/bashrc:fc:38: no such event: 1
/etc/bashrc:40: command not found: shopt
/etc/bashrc:51: command not found: shopt
bash: shopt: 명령을 찾을 수 없습니다...
/etc/bashrc:fc:38: no such event: 1
bash: shopt: 명령을 찾을 수 없습니다...
bash: shopt: 명령을 찾을 수 없습니다...
```





### References

**https://nitocin.tistory.com/entry/ohmyzsh-%EC%98%A4%ED%94%84%EB%9D%BC%EC%9D%B8-%EC%84%A4%EC%B9%98**

