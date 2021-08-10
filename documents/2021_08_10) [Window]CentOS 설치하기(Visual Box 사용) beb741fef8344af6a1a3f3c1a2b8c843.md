# [Window]CentOS 설치하기(Visual Box 사용)

# 다운로드하기

[https://www.centos.org/download/](https://www.centos.org/download/)

> CentOS 8

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled.png?raw=true)

8 버전을 설치해 보겠습니다.

ISO 하단의 x86_64를 선택합니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled1.png?raw=true)
kakao를 한번 들어가보도록 하겠습니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled2.png?raw=true)

boot.iso를 다운받습니다. 750메가 정도 되네요.

> CentOS7

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled3.png?raw=true)

동일하기 x86_64를 선택합니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled4.png?raw=true)

그 후 Everything 을 선택하여 설치하면 됩니다.

# VirtualBox 설치하기

> 다운받기

[https://www.virtualbox.org/](https://www.virtualbox.org/)

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled5.png?raw=true)

타 버전을 받으시고 싶으시다면 위의 VirtuaklBox 6.0과 5.2 버전을 받으시면 됩니다.

**2020년을 기준으로 더이상 지원하지 않습니다.

**Windows hosts**를 클릭하면 다운받게 됩니다.

> 설치 후 실행하기

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled6.png?raw=true)

새로 만들기 → 클릭한 후 CentOS8

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled7.png?raw=true)
할당할 메모리를 지정해 주면 됩니다. 저는 5120MB 를 할당해 보겠습니다.

가상 하드 디스크 만들고 하드 디스크 파일 종류를 VDI(VirtualBox Disk Image)를 선택합니다.

원하시는 디스크 크기를 설정하고 완료 누르시면 생성 됩니다. (저는 200gb를 할당했습니다.)

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled8.png?raw=true)

아래 체크된 곳을 클릭한 후 본인이 다운받은 centOS .iso 파일을 선택해 줍니다.

> 이후부턴 CentOS7을 대상으로 설치하고 있습니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled9.png?raw=true)

실행하면 install을 합니다! 이때 키보드를 이용하는것을 추천드립니다. 마우스 잡기?? 기능을 활성화 하니 이 창에서 빠져나가질 못하네요. 추후에 추가적으로 마우스 관련 사항을 추가해 드리겠습니다.

아래 이미지와 같이 따로 키를 설정해도 되고 기본으로 오른쪽  control 키를 누르면 윈도우 화면과 VM 을 오고갈수 있습니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled10.png?raw=true)

> 소프트웨어 설정

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled11.png?raw=true)

설치대상도 선택하고

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled12.png?raw=true)

네트워크 설정

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled13.png?raw=true)

그 후 설치 시작을 눌러 설치를 진행합니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled14.png?raw=true)

설치가 완료되면 root 암호를 설정하고 사용자 생성을 완료하면 됩니다.

설치가 완료되면 재부팅 후 licensing을 클릭해 동의하기를 눌러주시면 됩니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled15.png?raw=true)

로그인 언어설정 등을 지나서

배경화면이 나오면 터미널을 켭니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled16.png?raw=true)

아래 명령어 yum update로 yum을 업데이드 한 후  

```jsx
$ yum update
```

서버를 reboot 시켜 줍니다.

```jsx
$ reboot
```

> 마우스 자연그럽게 왔다갔다 시키기.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10/Untitled17.png?raw=true)

설치하면 이제 마우스가  window와 server 사이를 자유롭게 왔다갔다 할 수 있습니다.
