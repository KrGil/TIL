# [Window] Windows Terminal 꾸미기(3)

> Windows Terminal 옵션 실행

- Ctrl + ,  을 누르시면 설정창이 뜹니다.
- 설정창에서 이렇게 따로 바꾸실 수도 있습니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_2/Untitled.png?raw=true)

혹은 code를 수정해서 바꾸실 수도 있습니다. 위 사진의 왼쪽 하단의 설정아이콘을 클릭합니다.

그 후 [https://terminalsplash.com/](https://terminalsplash.com/) 여기서 마음에 드는 테마의 code 버튼을 클릭합니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_2/Untitled1.png?raw=true)

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_2/Untitled2.png?raw=true)

아래의 스크립트 부분에 추가해 주시면 됩니다.

```java
"schemes": [
    {
      "background": "#1A1A1A",
      "black": "#000000",
      "blue": "#579BD5",
      "brightBlack": "#797979",
      "brightBlue": "#9CDCFE",
      "brightCyan": "#2BC4E2",
      "brightGreen": "#1AD69C",
      "brightPurple": "#975EAB",
      "brightRed": "#EB2A88",
      "brightWhite": "#EAEAEA",
      "brightYellow": "#E9AD95",
      "cursorColor": "#FFFFFF",
      "cyan": "#00B6D6",
      "foreground": "#EA549F",
      "green": "#4EC9B0",
      "name": "Aurelia",
      "purple": "#714896",
      "red": "#E92888",
      "selectionBackground": "#FFFFFF",
      "white": "#EAEAEA",
      "yellow": "#CE9178"
    },
    {
      "background": "#0C0C0C",
      "black": "#0C0C0C",
      "blue": "#0037DA",
      "brightBlack": "#767676",
      "brightBlue": "#3B78FF",
      "brightCyan": "#61D6D6",
      "brightGreen": "#16C60C",
      "brightPurple": "#B4009E",
      "brightRed": "#E74856",
      "brightWhite": "#F2F2F2",
      "brightYellow": "#F9F1A5",
      "cursorColor": "#FFFFFF",
      "cyan": "#3A96DD",
      "foreground": "#CCCCCC",
      "green": "#13A10E",
      "name": "Campbell",
      "purple": "#881798",
      "red": "#C50F1F",
      "selectionBackground": "#FFFFFF",
      "white": "#CCCCCC",
      "yellow": "#C19C00"
    },
```

이미지의 경우 source를 클릭 하여 따로 받으실 수 있습니다.

profile → su-os-L.png를 다운받습니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_2/Untitled3.png?raw=true)

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_2/Untitled4.png?raw=true)

그 후 다운 받은 경로를 defaults 안의 backgroundImage : "이미지경로" 를 작성해 주시면 됩니다.

혹은 shemes에 작성하셔도 됩니다.

backgroundImage : "이미지경로"

- 제 script 입니다.
- backgroundImage, colorSchem 부분만 변경하시면
- 뒷배경과 terminal theme을 변경하실 수 있습니다.

```java
profiles": {
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
```

> 터미널 환경 설정하기

---

[https://terminalsplash.com/](https://terminalsplash.com/)

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_12_2/Untitled5.png?raw=true)

이렇게 변경하실 수 있습니다.
