

# ubuntu ls 시 색상반전(글자배경색) 수정

## Before we go any further...

우분투에서 ls 시 이렇게 글자 배경색상이 생깁니다... 고쳐보려고 정말 theme도 고쳐보고 색상도 따로 줘보고 해도 해결이 안되네요... 방법을 찾다 colorls라는 것을 보게 되었습니다.

![image-20210826091703873](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_zsh_colorls.assets/image-20210826091703873.png)

https://github.com/athityakumar/colorls

ColorLS는 `ls` 명령 출력결과를 색과 아이콘으로 꾸며주는 Ruby 스크립트이므로 설치, 동작을 하려면 Ruby가 깔려있어야 합니다. 



## Goal

1. apt-get update

2. ruby 설치

    - gcc 설치

    - build-essential 설치(make 명령어 알아듣게하기)

3. colorls 설치

## Process

### apt-get update

> 우선 Ubuntu를 처음 설치하면 해당 패키지관리 툴을 업데이트 해야합니다.(모든 linux는 설치 시 업데이트를 하는 듯 하네요.)

``` 
sudo apt-get update
```

###### centos는 ~~*yum update*~~ 



### Ruby 설치

> 위에 언급했듯이 colorls는 ruby 언어로 되어 있기 때문에 설정을 수정하기 위해 설치 합니다.

```
sudo apt-get install ruby-full
```

#### *설치확인*

``` -v ``` 명령어로 확인합니다.

```
ruby -v
```

### gcc 설치

> colorls를 설치하기 위해서 gcc를 설치합니다.

```
sudo apt-get install gcc
```

### build-essential 설치

> make 명령어 설치

```
sudo apt-get install build-essential
```

### colorls 설치

> 위의 모든 과정이 끝났다면 드디어 colorls를 설치합니다.

```
sudo gem install colorls
```

![image-20210826102632099](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_zsh_colorls.assets/image-20210826102632099.png)

후.. 긴 여정이었습니다.  이제 ls를 사용하면 colorls가 자동으로 작동하도록 등록합니다.

> ~/.zshrc를 수정합니다.

```vim``` 에디터를 사용해서 .zshrc파일을 엽니다.

``` vim ~/.zshrc``` 로 들어가 가장 하단에 아래의 코드를 붙여 넣습니다.

```
alias ls='colorls --group-directories-first'
source $(dirname $(gem which colorls))/tab_complete.sh
```

```--group-directories-first``` 를 추가하게 된다면 아이콘이 먼저 나온다고 하는데 저는 아이콘이 현재 나오질 않네요.

저는 ```D2coding```을 쓰는데 아이콘을 출력하려면 지원하는 해당 폰트를 사용해야 합니다.  ```MesloLGS NF``` 로 바꾸니 아이콘이 잘 나오네요.

https://github.com/romkatv/powerlevel10k#meslo-nerd-font-patched-for-powerlevel10k

``` source ~/.zshrc```로 변경 사항을 적용시킵니다.

![image-20210826103336817](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_zsh_colorls.assets/image-20210826103336817.png)



## 완성

폰트까지 변경해 주니  깔끔하게 출력이 됩니다.

![image-20210826105347515](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_zsh_colorls.assets/image-20210826105347515.png)



### 문제점

시스템에 의해 보호되는 파일이 존재하면 파일 리스트 자체를 열람할 수 없습니다... 기존의 ls는 해당건은 스킵하고 나머지를 출력했었는데 colorls는 출력을 해주지 않네요.



## Refences

https://github.com/athityakumar/colorls#flags

https://boltlessengineer.tistory.com/85