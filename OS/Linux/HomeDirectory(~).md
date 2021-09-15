# Home Directory(~) ? 

### Home Directory란?

멀티 유저 시스템에선 사용자마다 돌깁적인 공간을 할당해줘서 독립 공간에 파일을 저장할 수 있도록 합니다.

리눅스에선 이런 독립 공간을 'home directory'라고 합니다. ``` chmod```로 권한을 설정하여 타인이 디렉토리를 수정, 삭제, 읽기 등을 제한할 수 있습니다.



### Home Directory 경로

보통은 ```/home/User```에 위치합니다. 제 ```User``` 아이디가 eisen 일 시 eisen 계정의 home directory는 ```/home/eisen``` 이 됩니다.

해당 계정으로 로그인 시 (i.g ```ssh eisen@localhost```) 자동으로 home directory에 위치하게 됩니다.

```pwd``` 커맨드를 사용하여 현재 위치를 알아 볼 수 있습니다.



### ~ 사용(tilde).

> home/User

```/home/User```을 ```~```으로 대신 사용하실 수 있습니다.

``` cd 
cd /home/eisen/etc
```

위의 명령어를

``` 
cd ~/etc
```

로 사용할 수 있습니다.

*** root로 로그인 시 root의 home directory로 이동합니다. ***



> 특정 사용자의 home directory

사용자가 ```eisen``` 과 ``` gil``` 이 존재한다면

```/home/gil/test``` 파일로 ```~```로 사용할 수 있습니다.

```
cd /home/gil/test
```

위의 명령어를

```
cd ~gil/test
```

을 사용할 수 있습니다.

*** 권한이 있어야만 다른 사용자의 파일로 이동할 수 있습니다. ***



#### home directory & ~

home directory가 무엇인지, ```~``` 를 어떻게 사용하는지 간단하게 알아보았습니다.













https://violet-bora-lee.github.io/linux-survival-for-korean/#/linux-home-directories