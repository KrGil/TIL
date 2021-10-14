# Ubuntu(21.04)에서 hotspot 켜기



### Gnome Wi-Fi 설정 도구창

![Screenshot from 2021-10-12 10-03-11](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_hotspot.assets/Screenshotfrom2021-10-1210-03-11.png)

우측 상단에 존재하는 설정창을 클릭해 Wi-Fi Hotspot 설정을 킵니다.



### Hotspot 생성

![Screenshot from 2021-10-12 10-04-32](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_hotspot.assets/Screenshotfrom2021-10-1210-04-32.png)

그 후 켜진 Wifi 창에서 다시 우측 상단의 ```Connect to Hidden Network```를 선택하여 wife를 하나 설정합니다.



![Screenshot from 2021-10-12 10-04-42](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_hotspot.assets/Screenshotfrom2021-10-1210-04-42.png)

```Connection```에 ***```Hotspot```***을 선택한 후 Network name을 설정합니다.(저는 eisen's hotspot이라 정했습니다.)



### 생성한 hotspot 설정

![image-20211012101438072](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_hotspot.assets/image-20211012101438072.png)

그 후 ```ALT``` +``` F2``` 를 눌러 Run a Command 창을 띄운 후 

```nm-connection-editor``` 를 입력합니다.

![image-20211012101637425](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_hotspot.assets/image-20211012101637425.png)

생성하신 hotspot을 더블클릭으로 설정창을 띄웁니다.



![image-20211012101745856](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_hotspot.assets/image-20211012101745856.png)

Mode -> Hotspot으로 설정한 후 Wi-Fi Security 탭에서 WPA & WPA2 Personal을 선택한 후 비밀번호를 설정합니다.(비밀번호는 8글자?인가 이상이어야 합니다.)

![image-20211012101757672](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_hotspot.assets/image-20211012101757672.png)

그 후 이제 설정이 모두 끝났습니다. ubunt setting 화면의 Wi-Fi 탭에 들어가시면 이렇게 화면이 뜨는것을 보실 수 있습니다. 본인의 핸드폰에서 카메라로 해당 화면을 찍으면 hotspot에 들어갈 수 있습니다.

![image-20211012102501729](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_hotspot.assets/image-20211012102501729.png)





### References

https://genuine-lamps.com/ko/linux/4249-how-to-set-up-a-wifi-hotspot-on-linux.html