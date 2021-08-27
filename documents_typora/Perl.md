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







### questions





https://perldoc.perl.org/perlrun





### @INC

``` @INC``` location of perl libraries



## References

https://ponyozzang.tistory.com/17
