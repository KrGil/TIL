# Windows_mobilehotspot_on

# Windows 노트북 모바일 핫스팟 자동 실행

### Batch File 생성 전 명령어 실행 해보기

> 관리자 권한으로 cmd 실행

- 아래의 명령어를 실행시킵니다. (앞의 $는 빼고 복사해주세요.)

```bash
$ netsh wlan start hostednetwork //start hotspot
```

![image-20210820134525333](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/Windows_mobilehotspot_on.assets/image-20210820134525333.png)

###### *이미지의 cmd창과 실제 cmd창에 차이가 존재할 수 있습니다.* 



> Error

- 아래와 같은 오류가 발생한다면

```
호스트된 네트워크를 시작할 수 없습니다.
그룹 또는 리소스가 요청된 작업을 실행할 올바른 상태에 있지 않습니다.
```

![image-20210820134936714](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/Windows_mobilehotspot_on.assets/image-20210820134936714.png)

###### *이미지의 cmd창과 실제 cmd창에 차이가 존재할 수 있습니다.* 



> Why

``` 
$ netsh wlan show drivers
```

![image-20210820135611098](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/Windows_mobilehotspot_on.assets/image-20210820135611098-16316869699353.png)

호스트된 네트워크 지원이 ''*__아니요__*''로 되어 있기 때문에 위와 같은 오류가 발생하는 것입니다.



> Solution

### PowerShell script file 생성(.ps1)

- 메모장에 아래 명령어를 복사해서 붙여넣습니다.(<span style="color:orange"><u>*$도 같이 복사해주세요.*</u></span>)
- 그 후 .ps1파일로 저장합니다.(필자는 mobilehotspot_on.ps1로 저장했습니다.)

```powershell
$connectionProfile = [Windows.Networking.Connectivity.NetworkInformation,Windows.Networking.Connectivity,ContentType=WindowsRuntime]::GetInternetConnectionProfile()
$tetheringManager = [Windows.Networking.NetworkOperators.NetworkOperatorTetheringManager,Windows.Networking.NetworkOperators,ContentType=WindowsRuntime]::CreateFromConnectionProfile($connectionProfile)

# Start Mobile Hotspot
$tetheringManager.StartTetheringAsync()
```

### Batch file 생성(.bat)
- 메모장에서 아래 명령어를 작성한 후 .bat파일로 저장(파일명은 상관없습니다. i.g) mobilehostapot_on.bat)


```bash
Powershell.exe -noprofile -executionpolicy bypass -file "ps1파일경로"
```
###### *실제 작성 예시*

```java
@echo off
Powershell.exe -noprofile -executionpolicy bypass -file "C:\Users\NC517\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\mobilehotspot_on.ps1"
pause
    
    @echo off
Powershell.exe -noprofile -executionpolicy bypass -file "C:\Users\admin\Documents\mobilehotspot_on.ps1"
pause
```

```Windows + R``` 를 눌러 실행을 키고 아래 문구를 칩니다.

```
$ shell:startup
```

- 그러면 시작메뉴 > 프로그램 > 시작프로그램 폴더가 켜집니다.
- 켜진 폴더에 .ps1파일과 .bat 파일을 붙여넣습니다. 

![image-20210820150340770](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/Windows_mobilehotspot_on.assets//image-20210820150340770-16316869830635.png)



### 컴퓨터를 재시작하면 아래와 같이 자동으로 모바일 핫스팟이 켜지는 것을 볼 수 있습니다.

![image-20210820152416488](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/Windows_mobilehotspot_on.assets//image-20210820152416488-16316869953047.png)



##### 실행을 눈으로 보고싶으시면 .ps1 파일에 아래 명령어를 추가하시면 됩니다.

```java
@echo off
Powershell.exe -noprofile -executionpolicy bypass -file "C:\Users\%username%\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\mobilehotspot_on.ps1"
pause
```

##### 그럼 이렇게 컴퓨터가 켜질때마다 cmd 창이 실행되는 것을 볼 수 있습니다.

![image-20210820152859833](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/Windows_mobilehotspot_on.assets//image-20210820152859833-16316870049759.png)

### Edit 환경변수 사용.

``` %username%``` 을 사용하여 사용자가 변경되어도 함께 변경 될 수 있도록 수정.

```bash
x @echo off
Powershell.exe -noprofile -executionpolicy bypass -file "C:\Users\%username%\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\mobilehotspot_on.ps1"
pause
```







# Reference

###### 첫 시도

https://seogilang.tistory.com/987#:~:text=%EC%8B%9C%EC%9E%91%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8%EC%97%90%20%EB%93%B1%EB%A1%9D%ED%95%98%EB%8A%94,%ED%95%98%EA%B1%B0%EB%82%98%20%EC%9D%B4%EB%8F%99%ED%95%98%EC%97%AC%20%EB%84%A3%EC%9C%BC%EB%A9%B4%20%EB%90%9C%EB%8B%A4.

###### 호스트된 네트워크 지원이 ''*__아니요__*'' 일 시 해결방법

https://superuser.com/questions/1174124/turn-on-mobile-hotspot-on-startup-windows-10

###### .bat파일로 .ps1 실행시키기

http://egloos.zum.com/BlogLee/v/5610496

