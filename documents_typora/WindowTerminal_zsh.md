

# zsh

## WindowsTerminal에 oh_my_zsh 설치
### 1. zsh 파일 다운로드

https://gist.github.com/fworks/af4c896c9de47d827d4caa6fd7154b6b

![image-20210824142128517](https://raw.githubusercontent.com/KrGil/TIL/main/documents_typora/WindowTerminal_zsh.assets/image-20210824142128517.png)

- 빨간줄 쳐져있는 링크를 클릭하면 다운받아집니다.

### 2. 압축 풀고 git 폴더에 넣기

![image-20210824142412445](https://raw.githubusercontent.com/KrGil/TIL/main/documents_typora/WindowTerminal_zsh.assets/image-20210824142412445.png)

- 압축 풀고 나온 파일들(빨간색 밑줄)을 git 폴더에 붙여넣어줍니다.
- C:\Program Files\Git

### 3. git bash에서 zsh 실행

아래 zsh 명령으로 git bash에 잘 설치되어 있는지 확인합니다.

``` 
$ zsh
```

![image-20210824142637802](https://raw.githubusercontent.com/KrGil/TIL/main/documents_typora/WindowTerminal_zsh.assets/image-20210824142637802.png)

###### *위 이미지의 log와 같게 나오면 잘 설치된 것입니다.*




### 4. git bash에 oh_my_zsh 설치

```
$ sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```

### 5. ~/.bashrc 파일 수정

- 존재하지 않는다면 생성합니다.

``` 
$ vim ~/.bashrc
```

```
# Launch Zsh 
if [ -t 1 ]; then 
    exec zsh 
fi
```

### 6. theme 적용

#### Honukay

1. 아래 명령으로 honukay theme을 install 합니다.

```
curl -fsSL https://raw.githubusercontent.com/oskarkrawczyk/honukai-iterm/master/honukai.zsh-theme -o ~/.oh-my-zsh/custom/themes/honukai.zsh-theme
```

2. 시작 시 Honukay  theme을 defalut로 설정합니다.

```
sed -i 's/ZSH_THEME="robbyrussell"/ZSH_THEME="honukai"/g' ~/.zshrc
```

#### povwerlevel10k

1. install

```
$ git clone --depth=1 https://github.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k
```

2. 실행 시 기본 파일 설정

```
$ sed -i 's/ZSH_THEME="robbyrussell"/ZSH_THEME="powerlevel10k/powerlevel10k"/g' ~/.zshrc
```

혹은 

```
$ vim ~/.zshrc
```

로 아래 이미지처럼 수정해 주어도 됩니다.

![image-20210824144031567](https://raw.githubusercontent.com/KrGil/TIL/main/documents_typora/WindowTerminal_zsh.assets/image-20210824144031567.png)

#### powerlevel10k의 경우 설치 후 재실행 할 경우 아래처럼 설정값을 따로 설정하는 질문들이 나옵니다. 잘 읽어 본 후 본인에 맞게 설정하시면 됩니다.

![image-20210824144212130](https://raw.githubusercontent.com/KrGil/TIL/main/documents_typora/WindowTerminal_zsh.assets/image-20210824144212130.png)

```p10k configure ```로 재설정 할 수 있습니다.



