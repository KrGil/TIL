# [Mac] oh-my-zsh 설치하기

### Before we go further

Mac용 Oh-my-zsh 설치에 대해 작성할까 합니다. 생각해 보면 mac에서 가장 처음 zsh를 설치했었는데... windows terminal, linux에서 설치하는 것은 작성해 놓았으면서 mac에서의 설치는 작성하지 않았네요.

oh-my-zsh 설치부터 그와 함께 설치하면 좋은 plug-in들 설치까지 함께 작성하도록 하겠습니다



### 설치

```
sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

terminal에 상단의 명령어를 실행시킵니다.

![image-20220124172659451](/Users/eisen/Documents/Github/TIL/OS/Mac/oh-my-zsh설치하기.assets/image-20220124172659451.png)

Oh-my-zsh 설치는 오래 걸리지 않습니다.



### 설정

#### theme 설정

저는 개인적으로 agnoster란 theme을 사용합니다. 만약 다른 theme을 원하신다면 아래 링크에서 한번 살펴보시는 것도 좋을 듯 합니다.

> https://github.com/ohmyzsh/ohmyzsh/wiki/Themes

![image-20220124172844691](/Users/eisen/Documents/Github/TIL/OS/Mac/oh-my-zsh설치하기.assets/image-20220124172844691.png)

ZSH_THEME="" 부분을 원하시는 theme 이름으로 교체하시면 됩니다.



### font 설정

D2Coding ligature를 좋아하는 편이라 개발툴 등의 font를 모두 해당 font로 교체해서 사용하고 있습니다.

> https://github.com/naver/d2codingfont

압축을 풀고(D2CodingAll을 설치했습니다.) 설치를 완료합니다.

그 후 ```Command + ,``` 혹은 상단의 Preferences에 들어가서 Profiles의 Text 탭의 하단의 Font에서 D2Coding ligature를 선택합니다.

> Preferences -> Profiles -> Text -> Font : D2Coding ligatuer

![image-20220124173750562](/Users/eisen/Documents/Github/TIL/OS/Mac/oh-my-zsh설치하기.assets/image-20220124173750562.png) 

*저는 iterms에서 ligature를 사용하지 않습니다. (Use ligatures를 체크하지 않습니다)* 

##### ** 주의 **

> iterm이 아니라 기존 terminal 역시 font를 바꾸어 주어 이모티콘이나 한글이 깨지지 않도록 해줍니다.

이제 기본적인 설정은 모두 완료되었습니다.

여기서 조금 더 편리한 기능들과 보기좋은 기능들을 추가해 보도록 하겠습니다.

## 추가기능

> 1. 사용자 이름 변경 및 줄바꿈
>
> 2. 명령어 자동완성 (zsh-autosuggestion)
>
>    명령어 색상변경 (zsh-syntax-highlighting)



### 1. 사용자 이름 변경 및 줄바꿈 추가하기

#### 사용자 이름 변경하기

```
vi ~/.zshrc
```

위의 명령으로 zsh 쉘 설정파일에 접근합니다.

```
prompt_context() {
  if [[ "$USER" != "$DEFAULT_USER" || -n "$SSH_CLIENT" ]]; then
    prompt_segment black default "%(!.%{%F{yellow}%}.)$USER😝"
  fi
}
```

제일 하단에 위의 명령어를 붙여줍니다.

![image-20220124175215405](/Users/eisen/Documents/Github/TIL/OS/Mac/oh-my-zsh설치하기.assets/image-20220124175215405.png)

위의 이미지와 같이 본인의 이름과 이모티콘으로 변경된 것을 알 수 있습니다.

*수정 후 iterm을 재시작 해주시길 바랍니다.*

#### 줄바꿈 추가

```
vi ~/.oh-my-zsh/themes/agnoster.zsh-theme
```

위의 명령으로 agnoster theme의 설정을 변경시켜 줍니다.

```
build_prompt() {
  RETVAL=$?
  prompt_status
  prompt_virtualenv
  prompt_aws
  prompt_context
  prompt_dir
  prompt_git
  prompt_bzr
  prompt_hg
  prompt_newline
  prompt_end
}
prompt_newline() {
  if [[ -n $CURRENT_BG ]]; then
    echo -n "%{%k%F{$CURRENT_BG}%}$SEGMENT_SEPARATOR
%{%k%F{blue}%}$SEGMENT_SEPARATOR"
  else
    echo -n "%{%k%}"
  fi

  echo -n "%{%f%}"
  CURRENT_BG=''
}
```

제일 하단부에 위의 명령어를 붙여넣어 줍니다. 이때

>   prompt_status
>   prompt_virtualenv
>   prompt_aws
>   prompt_context
>   prompt_dir
>   prompt_git
>   prompt_bzr
>   prompt_hg
>   prompt_newline
>   prompt_end

위의 순서는 반드시 동일하게 작성하도록 합니다.




### 2. 명령어 자동완성 (zsh-autosuggestion), 명령어 색상변경 (zsh-syntax-highlighting)

> oh-my-zsh에 plugin을 추가하는 방법은 두가지 입니다.
>
> 둘 중 무슨 방법을 사용해도 잘 적용이 되지만 oh-my-zsh에서는  ZSH_CUSTOM에 추가하여 사용하는 방법을 권장하고 있습니다.

##### 1. Source /path/ 활용하여 추가하기

```
// brew를 이용하여 해당 플러그인을 다운받습니다.
brew install zsh-autosuggestions

brew install zsh-syntax-highlighting
```

위의 명령어로 plugin을 다운받습니다.

```
vi ~/.zshrc
```

zsh 설정 파일을 열고 제일 하단에 아래의 명령어를 추가합니다

```bash
// 본인의 맥북이 m1이라면 아래의 코드를 작성해 주세요.
source /opt/homebrew/share/zsh-autosuggestions/zsh-autosuggestions.zsh

source /opt/homebrew/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh

// 본인의 맥북이 intel이라면 아래의 코드를 작성해 주세요.
source /usr/local/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh
source /usr/local/share/zsh-autosuggestions/zsh-autosuggestions.zsh
```

*수정 후 iterm을 재시작 해주시길 바랍니다.*

이렇게 하면 모든 설정이 완료됩니다. 이 방법의 장점은 brew에서 모든것들을 관리하기에 해당 plugin을 삭제하거나 추가할 시 brew를 활용하여 더욱 편리하게 관리할 수 있다는 장점이 있겠습니다.



##### 2. ZSH_CUSTOM에 추가하기

```
// ZSH_CUSTOM 하단의 plugins 폴더에 해당 plugin들을 받습니다.
git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions

git clone https://github.com/zsh-users/zsh-syntax-highlighting ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting

```

위의 명령으로 받습니다. 

```
vi ~/.zshrc
```

zsh설정 파일에서 아래의 이미지와 같이 변경해 줍니다.

![image-20220124181138539](/Users/eisen/Documents/Github/TIL/OS/Mac/oh-my-zsh설치하기.assets/image-20220124181138539.png)

*수정 후 iterm을 재시작 해주시길 바랍니다.*

긴 글을 읽어주셔서 감사합니다. 위의 설정 중 안되거나 궁금한 점이 있다면 댓글 남겨주시길 바랍니다.



### References

https://shanepark.tistory.com/60?category=1182535

- 추가 기능

https://hjiee.tistory.com/entry/%ED%84%B0%EB%AF%B8%EB%84%90-Oh-My-ZSH%EB%A1%9C-%ED%84%B0%EB%AF%B8%EB%84%90-%EC%95%84%EB%A6%84%EB%8B%B5%EA%B2%8C-%EA%BE%B8%EB%A9%B0%EB%B3%B4%EA%B8%B0

https://kjhgao.tistory.com/96