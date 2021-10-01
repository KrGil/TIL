# Vim 설정하기(terminal, cmd 등)

vim을 사용한지도 벌써 몇 개월이 지났습니다. 그런데 구글링을 하던 중 vim 환경을 설정할 수 있다는 사실을 알았습니다.매번 사용할 때 line number가 없어서 조금 불편한 느낌이 들었었는데 이번 기회를 빌어 vim 환경 설정을 조금 바꿔보기로 했습니다.



## List

1. .vimrc 파일 생성
2. .vimrc 파엘에 설정 값 넣기
3. etc...(vim 단축키)



### 1. .vimrc 파일 생성

```
cd ~
```

홈 디렉토리(~)에 ```.vimrc``` 파일을 생성해 줍니다.(만약 모든 유저에게 동일하게 설정하고 싶으시다면 ```vim /etc/vimrc```를 수정해 주시길 바랍니다.)

홈 디렉토리가 궁금하시다면 아래 링크를 참고해 주시길 바랍니다.

[홈 디렉토리(~)란?(Home Directory)](https://jjam89.tistory.com/162)

```
vim .vimrc
```

vim으로 .vimrc 파일을 생성(없으시다면) 합니다.



### 2. vimrc 파일 설정

```
if has("syntax")
        syntax on
endif

set hlsearch
set nu
set autoindent
set cindent
set ts=4
set sts=4
set shiftwidth=4
set showmatch
set smartcase
set smarttab
set smartindent
set ruler
set fileencodings=utf8,euc-kr
```

위와 같이 설정해 주면 간단한 line number 표시, tab 시 indent 설정, utf8 설정 등을 할 수 있습니다.



### etc(vim 단축키)

#### 방향키

>  h,j,k,l   ==> 좌,하,상,우



Undo(되돌리기)

> u(줄의 기준으로 한개)
>
> U(줄 전체)
>
> ctrl-R(취소한 것을 다시 취소함.)



character 삭제하기

> x



텍스트 입력하기

> i(삽입)
>
> a(추가)



텍스트 삭제하기

> dw(단어 삭제)
>
> d$(줄 삭제) dd도 가능.



단어 첫글자 마지막 글자로 이동하기

> w(단어의 첫글자로)
>
> e(단어의 끝글자로)
>
> 
>
> 2w(ww) , 2e(ee), 3w(www) 등으로 실행 가능. 
>
> 0 (해당 줄의 가장 처음으로.)



조합 사용하기(단어 지우기)

> d2w (두 단어 삭제하기)
>
> 3dd (세 줄 전체 삭제하기)



삭제한 것 붙여넣기

> p(한 단어, 한 줄 다 적용)



고쳐쓰기

> r <철자>
>
> ce (위치한 커서의 단어 뒷부분이 지워지고 edit 모드로 진입.)
>
> c$ (위치한 커서의 줄 뒷부분이 모두 지워짐.)



이동하기

> gg (파일의 가장 첫 부분으로 이동)
>
> G (파일의 가장 마지막 부분으로 이동)
>
> ctrl + g(로 현재 라인 위치 확인)
>
> <lineNumber> + G (해당 라인으로 이동)



특정단어 찾기

> / <단어입력>
>
> ? <단어입력>
>
> ctrl + o (원래 위치로 이동)









vim 단축키가 궁금하시다면 아래 링크에서 확인해 주시길 바랍니다.

https://vimhelp.org/



### vim 배우기

```vimtutor```을 terminal 혹은 cmd에서 실행시키면 됩니다.

```
vimtutor
```







### Refereces

https://hyoje420.tistory.com/51