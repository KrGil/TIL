# Diff 명령으로 파일 비교하기

> 저는 어릴 적 프로그래머라고 생각하면 메트릭스의 화면이 생각납니다ㅎㅎ 검정 화면에 알수없는 검정색 숫자들이 주르륵 써져있었죠. 그 이후 프로그램에 조금 알게 되었을 땐 검정 화면에 알수없는 글자들이 초록빨강흰색으로 도배되어 있는 화면이 떠오르더군요.
>
> 이번에 회사에서 시니어급 프리 한분이 저와 같은 팀으로 배정되었습니다.  저는 이클립스의 git synchronize의 gui 화면에서 사용했었는데 이분은 깃을 오래 사용하셨는지 gitbash에서 모든 작업을 하더군요.
>
> 아... 그 어찌나 멋져 보이던지 계속해서 그 장면이 제 머리속을 떠나지 않더라구요...
>
> 그래서 저 역시 mac에서는 terminal의 command를, window에서는 gitbash를 활용한 명령으로 작업들을 진행해 보고 싶더군요.
>
> 그 첫 단계로 diff 명령으로 통한 파일 비교입니다. 궁금한 점이나 잘못된 부분이 존재할 경우 언제든지 댓글 달아주시면 됩니다.



## Diff

diff 명령어의 기본 형식입니다.  해당 명령어를 활용하여 파일을 비교해 보는 테스트를 해 보겠습니다.

```bash
diff <OPTION> [file1] [file2] 
```



### testfile 생성

우선 두개의 파일을 비교하기 위해서 두개의 파일을 생성해 봅니다.

```bash
echo "first" > test1.txt
echo "second" > test2.txt
```

![image-20220219212829211](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git/Diff_Command.assets/image-20220219212829211.png)



두개의 파일을 생성하고 ```diff``` 명령어로 실제 비교해 봅니다.

```bash
diff test1.txt test2.txt
```



![image-20220219212938890](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git/Diff_Command.assets/image-20220219212938890.png)

`< >` 해당 기호를 활용하여 구분점을 두고 있습니다만 좀 알아보기 힘들군요.

 ```option```을 활용해 보겠습니다.



### Option 활용해보기

```bash
diff -u test1.txt test2.txt
```

![image-20220219213250828](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git/Diff_Command.assets/image-20220219213250828.png)

`-u` 옵션으로 git과 비슷하게 `+ -` 구분자를 활용하여 비교해 주네요. 

아래에 간단하게 옵션들을 소개하겠습니다만 이 외에도 여러가지 옵션들이 존재합니다. 구글에서 `diff 옵션`으로 검색하면 더욱 많은 결과를 얻을 수 있습니다.

| -c   | 두 파일간의 차이점 출력                                      |
| ---- | ------------------------------------------------------------ |
| -d   | 두 파일간의 차이점을 상세하게 출력                           |
| -r   | 두 디렉토리간의 차이점 출력, 서브디렉토리 까지 비교          |
| -i   | 대소문자의 차이 무시                                         |
| -w   | 모든 공백 차이무시                                           |
| -s   | 두 파일이 같을 때 알림                                       |
| -u   | 두 파일의 변경되는 부분과 변경되는 부분의 근처의 내용도 출력 |



이렇게 검색을 했는데 흰 글자에 기호만 바뀌니 알아보기 힘드네요. 그럼 색상을 추가해 보도록 해겠습니다.

###  colordiff 설치하기

```bash
brew install colordiff
```

위의 command로 `colordiff`를 설치합니다.

그 후 아래의 명령어를 실행시켜 봅니다.

```bash
diff -u test1.txt test2.txt | colordiff
```

![image-20220219213223713](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git/Diff_Command.assets/image-20220219213223713.png)

!!! 일반적으로 git을 사용할때와 동일한 색상으로 파일을 비교하는 것을 알 수 있습니다.

```bash
colordiff -u test1.txt test2.txt
```

위의 명령으로 동일한 효과를 나타낼 수 있습니다.

기존에는 두개의 파일을 비교할 때 notepad++를 활용하거나 eclipse를 사용하여 compare 기능을 적용시켰는데 이제는 조금 더 있어 보이게 두개의 파일을 비교할 수 있게 되었습니다!

여기까지 읽느라 고생하셨습니다. 다들 있어 보이는 코딩하는 하루 되세요!!