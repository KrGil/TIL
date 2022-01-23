# [Mac] Homebrew 설치하기 

### Before we go further

맥북 2021 m1을 얼마 전에 구입하여 기존 맥과 연동시키지 말고 완전 처음부터 설정을 해보자는 생각에 하나하나 설정을 하고 있습니다.

설정 도중에 m1이기에 기존에 사용하던 것들과는 조금 다른 설정들이 존재했습니다. Homebrew에서 받은 파일들의 경로가 기존 intel과 m1이 차이가 있더군요. 이에 대해 정리하고자 합니다.



### Homebrew

> Homebrew란 Mac OS용 패키지 관리자이자 툴입니다.

#### 설치

``` 
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

터미널에서 위의 명령어를 실행시켜 줍니다.

![image-20220123085005182](/Users/eisen/Documents/Github/TIL/OS/Mac/m1_homebrew_path.assets/image-20220123085005182.png)

비밀번호 등, 무엇을 요구하는지 잘 읽어본 후 엔터키를 쳐 설치를 완료합니다.

#### 주의

설치하다 붉은 글씨로 path가 없다는 error를 내뱉으면

1. 아래의 명령어를 터미널에서 실행시켜 주시거나

   a. ```~/.zshrc``` 라는 zsh설정 파일의 제일 하단에 ```export PATH=/opt/homebrew/bin:$PATH```라는 문구를 추가해주겠다는 명령어입니다.

```
echo 'export PATH=/opt/homebrew/bin:$PATH' >> ~/.zshrc
```

2. 직접 ~/.zshrc 파일에 들어가셔서 ```export PATH=/opt/homebrew/bin:$PATH``` 를 추가해 주어도 됩니다.

   ```
   cd ~/.zshrc
   // 제일 하단에 아래의 문구 복사 붙여넣기
   export PATH=/opt/homebrew/bin:$PATH
   ```



#### 설치 확인

```brew --version``` 명령어로 ```brew``` 명령어가 잘 먹히는지, 버전은 몇인지 등을 확인할 수 있습니다.

![image-20220123085753776](/Users/eisen/Documents/Github/TIL/OS/Mac/m1_homebrew_path.assets/image-20220123085753776.png)



### ** 주의 **

> Intel Mac과 M1 mac에서의 설치 경로가 변경되었습니다. 
>
> 본인의 Mac이 Intel인지 M1인지 잘 확인하신 후 경로가 필요할 경우 해당 경로로 작성해 주세요.

Intel :  `/usr/local`

M1 :  `/opt/homebrew`

#### 예시

> ```brew install zsh-syntax-highlighting```와 ```brew installzsh-autosuggestions ```을 설치했을 때 입니다.
>
> ```~/.zshrc``` 파일 제일 하단에 아래와 같이 설정을 해주시면 됩니다.

Intel mac에서

```null
source /usr/local/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh
source /usr/local/share/zsh-autosuggestions/zsh-autosuggestions.zsh
```

M1 mac에서

```null
#.zshrc에 추가할 코드
source /opt/homebrew/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh
source /opt/homebrew/share/zsh-autosuggestions/zsh-autosuggestions.zsh

#추가 후 터미널에서 source ~/.zshrc 실행
#설치한 플러그인 잘 실행되는지 확인
```

![image-20220123091002870](/Users/eisen/Documents/Github/TIL/OS/Mac/m1_homebrew_path.assets/image-20220123091002870.png)

설치 시 위의 이미지와 같이 해당 경로가 표시되어 있으니 설치 시 주의깊게 살펴보시길 바랍니다.

### Reference

[homebrew]

https://brew.sh/

[homebrew 및 여러가지 설치]

https://shanepark.tistory.com/167

[homebrew 설치 경로]

https://velog.io/@hyeonze/%ED%84%B0%EB%AF%B8%EB%84%90-M1-mac%EC%97%90%EC%84%9C-.zshrc%EA%B2%BD%EB%A1%9C-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0