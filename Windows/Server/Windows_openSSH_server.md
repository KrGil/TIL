# Windows를 서버로 사용하기(openssh_server, defaultShell)

### 1. OpenSSH server 설치

설정 -> 앱 -> 선택적 기능 -> 기능추가 -> openssh 서버 추가

![image-20210914090847483](https://raw.githubusercontent.com/KrGil/TIL/main/Windows/Windows_openSSH_server.assets/image-20210914090847483.png)



![image-20210914090731173](https://raw.githubusercontent.com/KrGil/TIL/main/Windows/Windows_openSSH_server.assets/image-20210914090731173.png)

```
Start-Service sshd
Set-Service -Name sshd -StartupType 'Automatic'
```

sshd를 지금 실행하고 컴퓨터가 켜질 때 sshd를 자동실행시키게 합니다.



### ssh 접속 시 기본 prompt 변경하기(change opensshserver default shell)

__*PowerShell로 작업을 해야 합니다.*__

> powershell

```vhdl
New-ItemProperty -Path "HKLM:\SOFTWARE\OpenSSH" -Name DefaultShell -Value "C:\Windows\System32\WindowsPowerShell\v1.0\powershell.exe" -PropertyType String -Force
```

> bash

```vhdl
New-ItemProperty -Path "HKLM:\SOFTWARE\OpenSSH" -Name DefaultShell -Value "C:\WINDOWS\System32\bash.exe" -PropertyType String -Force
```

하나는 powershell을 기본으로, 하나는 bash(설치되어있다면)를 기본으로 하는 명령어입니다.

> git bash

```vhdl
New-ItemProperty -Path "HKLM:\SOFTWARE\OpenSSH" -Name DefaultShell -Value "C:\Program Files\Git\bin\bash.exe" -PropertyType String -Force
```



[Windows Terminal 설치하기](https://jjam89.tistory.com/135?category=957755)

[Windows Terminal에 Git bash 추가하기](https://jjam89.tistory.com/136)

[Git bash에 oh-my-zsh 설치하기](https://jjam89.tistory.com/150)







### References

https://superuser.com/questions/1332346/setting-to-use-git-bash-as-default-shell-when-connecting-remotely-via-openssh-to

https://docs.microsoft.com/ko-kr/windows-server/administration/openssh/openssh_server_configuration

https://github.com/PowerShell/Win32-OpenSSH/wiki/DefaultShell

https://www.hanselman.com/blog/the-easy-way-how-to-ssh-into-bash-and-wsl2-on-windows-10-from-an-external-machine

https://blog.joyfui.com/1193