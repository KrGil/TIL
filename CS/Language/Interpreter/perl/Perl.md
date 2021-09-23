# Perl

```-e``` (exists)



```ne``` (not equal)



``` my``` (변수타입) 블록 전에 쓰이면 어디서나 접근이 가능. 

- 블록 안에 쓰면 해당 블록 내에서만

- 블록 전에 쓰고 블록 내에서 다시 써도 밖에서 선언하면 전에 쓴게 적용.(주소값이 다르다?)





```<STDIN>```

```
$line = <STDIN>;
print $line;
```

사용자의 입력을 받습니다. 만약 "abc" 입력했다면

```$line```의 값은 "abc\n"이 됩니다.

(java의 Scanner와 비슷한 역할.)



```chomp``` 

```
chomp ($line = <STDIN>); // \n이 사라집니다.
```

입력받은값 중 가장 마지막에 붙는 \n을 지우는 역할을 합니다.

만약 "ABC"를 입력했다면 ```$line```의 값은 "ABC"가 됩니다.

``` 
$line = "abc"
```





### $ENV

perl에서는 시스템의 환경변수가 ```$EVN```에 모두 저장되어 있습니다.

```
$ENV{'JAVA_HOME'} = $java;
```

이렇게 직접 환경변수를 변경할 수 있음.



### -l

```
-l  File is a symbolic link (false if symlinks aren't supported by the file system).
```

https://perldoc.perl.org/functions/-l

- 심볼릭 링크가 아니면 false를 return 합니다.



### sub

- [`sub`](https://perldoc.perl.org/functions/sub) - declare a subroutine, possibly anonymously



### " "와 ' '의 차이

```perl
$name = "Perl";

print "my name is $name \n";
print 'my name is $name \n';

> my name is Perl 
> my name is $name \n
```



### CHILD_ERROR

> $? >> 8

https://perldoc.perl.org/perlvar#%24?



### 소유자 변경

> chown

파일이나 디렉터리의 소유자를 변경합니다.

```-R``` 명령으로 하위 디렉터리 모두 변경할 수 있습니다.



### Output redirection

- 0(stdin) 표준 입력 메시지
- 1(stdout) 표준 오류 메시지
- 2(stderr) 표준 출력 메시지

```cd /dev```에 들어가면 조금 더 이해하기 도움이 될 듯 합니다.

> 2>&1

표준오류 메시지를 출력하겠다는 의미입니다.

'2' : 표준 오류 메시지(오류가 발생 시)

'>' : 해당 파일에 내용을 덮어씌우기

'&1' :  현재 위치에 출력(그냥 1을 적지 않는 이유는 1을 output redirection으로 인식시켜주기 위해서입니다. i.g)2>1 1이란 파일에 오류메시지가 저장됩니다.)

https://stackoverflow.com/questions/818255/in-the-shell-what-does-21-mean



### > , >> 

**`open (MYFILE, '>>data.txt')`**— 열기 `data.txt`, 원본 데이터를 유지하고 끝에서 데이터를 추가합니다.

**`open (MYFILE, '>data.txt')`**— 열고 `data.txt`내부의 모든 것을 삭제하고 처음부터 데이터를 씁니다.

https://stackoverflow.com/questions/3004324/difference-between-and-in-perl





### questions

https://perldoc.perl.org/perlrun



## References

https://ponyozzang.tistory.com/17
