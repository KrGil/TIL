# [Window] Windows Terminal에 Git Bash 추가하기(2)

> Windows Terminal 설치

microsoft store에서 설치하시면 됩니다.(아래 사이트를 참고시길 바랍니다)

[https://jjam89.tistory.com/135](https://jjam89.tistory.com/135)

> Windows Terminal 실행

- ctrl + ,
- 옵션 창을 실행시킵니다.
- 그 후 빨간 박스 클릭

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_1/Untitled.png?raw=true)


> Window Terminal 옵션

```java
"profiles": {
    "defaults": {
      "acrylicOpacity": 0.80000000000000004,
      "backgroundImage": "D:\\Eisen\\terminal/au-os-L.png",
      "backgroundImageAlignment": "bottomRight",
      "backgroundImageStretchMode": "none",
      "colorScheme": "Aurelia",

      "cursorShape": "filledBox",
      "fontFace": "D2Coding",
      "fontSize": 11,
      "hidden": false,

      "scrollbarState": "hidden",
      "startingDirectory": "c:/",
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
        "guid": "{2c4de342-38b7-51cf-b940-2309a097f518}",
        "hidden": false,
        "name": "Ubuntu",
        "source": "Windows.Terminal.Wsl"
      },
      **{
        "guid": "{124fc1da-dadc-4276-9c4e-f0524ba57a49}",
        "name": "Git Bash",
        "commandline": "\"%PROGRAMFILES%\\git\\usr\\bin\\bash.exe\" -i -l",
        "icon": "%PROGRAMFILES%\\git\\mingw64\\share\\git\\git-for-windows.ico",
        "startingDirectory": "%USERPROFILE%",
        "cursorShape": "filledBox",
        "hidden": false
      }**
    ]
  },
```

- 빨간 글씨체 부분이 gitbash 추가하는 부분입니다.
- 본인 프로필 구조를 잘 살펴 보시고 해당하는 곳에 그대로 붙여넣기 하시면 됩니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_1/Untitled1.png?raw=true)

- 저장하고 나오시면 이렇게 git bash가 추가 된 것을 확인하실 수 있습니다.
- 만약 추가되지 않는다면 설치된 git bash의 경로를 확인해 주시기 바랍니다.

> Window Terminal 실행 시 git bash를 default로 실행시키고 싶다.

- 옵션에서 defaultProfile을 git bash의 guid로 교체하시면 됩니다.

```java
"defaultProfile": "{124fc1da-dadc-4276-9c4e-f0524ba57a49}",
```

OR

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_1/Untitled2.png?raw=true)

 이렇게 변경해 주셔도 됩니다.

그러면 이렇게 git bash가 추가됩니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_1/Untitled3.png?raw=true)
