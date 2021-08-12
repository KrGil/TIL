# [Window] (WSL2) Windows Terminal ubuntu를 기본으로 실행하기(1)

> WSL 설치.

---

아래 링크를 확인해 주시기 바랍니다.

[https://jjam89.tistory.com/125](https://jjam89.tistory.com/125)

> Microsoft store에서 Windows Terminal 설치

---

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12/Untitled.png?raw=true)

> Microsoft store에서 ubuntu 설치

---

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12/Untitled1.png?raw=true)

wsl 버전 확인하기

```bash
$ wsl -l -v
```

> Window Terminal 실행

---

ctrl + ,

이후 빨강 동그라미로 표시한 설정아이콘 클릭.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12/Untitled2.png?raw=true)

vsCode가 있다면 vsCode가, VS가 있다면 VS가 열림.(vsCode로 열고싶은데 따로 설정이 궁금)

- 열렸다면 defaultProfile에 ubuntu의 guid를 넣어줍니다.

```bash
"copyFormatting": "none",
  "copyOnSelect": false,
  "defaultProfile": "{**2c4de342-38b7-51cf-b940-2309a097f518**}", //이부분
  "profiles": {
    "defaults": {
      "acrylicOpacity": 0.80000000000000004,
      "colorScheme": "ProducerReactive",
      "cursorShape": "filledBox",
      "fontFace": "D2Coding",
      "fontSize": 11,
      "scrollbarState": "hidden",
      "useAcrylic": true
    },
    "list": [
      {
        "commandline": "powershell.exe",
        "guid": "{61c54bbd-c2c6-5271-96e7-009a87ff44bf}",
        "hidden": false,
        "name": "Windows PowerShell"
      },
      {
        "commandline": "cmd.exe",
        "guid": "{0caa0dad-35be-5f56-a8ff-afceeeaa6101}",
        "hidden": false,
        "name": "Windows Command"
      },
      {
        "guid": "{b453ae62-4e3d-5e58-b989-0a998ec441b8}",
        "hidden": false,
        "name": "Azure Cloud Shell",
        "source": "Windows.Terminal.Azure"
      },
      {
        "guid": "{**2c4de342-38b7-51cf-b940-2309a097f518**}", // Ubuntu의 guid 이녀석
        "hidden": false,
        "name": "Ubuntu",
        "source": "Windows.Terminal.Wsl"
      }
    ]
```
