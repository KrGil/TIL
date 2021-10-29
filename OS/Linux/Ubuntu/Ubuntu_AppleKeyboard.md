# Ubuntu에서 AppleKeyboard 사용하기

> 저는  keychrone k6 키보드를 사용하는 중입니다. 아이폰과 피씨를 번갈아가며 블루투스를 등록해서 사용할 수 있습니다. 하지만 아이폰을 실행시켰을 경우 apple용 키보드로 전환하지 않고 사용하면 먹히지 않는 기능들이 몇 있습니다.
>
> 따라서 그냥 맥용 키보드를 우분투에 사용하고 편하게 아이폰 역시 블루투스로 변경하여 사용하기 위해 특정 키들을 리맵핑 해주는 방법을 적어보도록 하겠습니다.



### 우측 alt key

> window에서 우측 alt 키로 인식하던 키가 apple Keyboard로 변환하면서 super_R로 바뀌었습니다.
>
> 따라서 Super_R 을 Alt_R로 변경해 줍니다.(한글키)

super 키를 alt 키로 변경해 주는 이유는 만약 한/영 변환키가 제대로 먹혀 있다면 alt를 이용하여 한영키를 바꾸기 때문입니다.

#### Tweaks 사용

- 설치

```
sudo apt update
```



```
sudo apt install gnome-tweaks
```

tweaks를 실행시켜 줍니다.

![image-20211027173909865](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_AppleKeyboard.assets/image-20211027173909865.png)



그 후 Keyboard & Mouse 탬에 들어갑니다. 

아래 이미지와 같이 ```Overview Shortcut``` 의 우측 ```Additional Layout Options```을 클릭합니다.

그리고 그 후 ```Alt/Win key behavior```의 ```Alt is mapped to Win and the usual Alt```를 체크해 줍니다. 

![image-20211027174007729](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_AppleKeyboard.assets/image-20211027174007729.png)

그러면 alt키로 적용되며 기존 키보드에 설정한 한영 키 역시 잘 먹힙니다.

 

### 우측 키 변경하기.

> mac의 키보드 맵핑이 개인적으로 편하기 때문에 가장 왼쪽 하단부터 ```Windows(super), alt, ctrl``` 키로 새로 맵핑하였습니다.

![image-20211027174332797](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Linux/Ubuntu/Ubuntu_AppleKeyboard.assets/image-20211027174332797.png)

이렇게 설정을 변경하면 기존의 mac용 키보드와 비슷한 기능과 위치로 사용하실 수 있습니다.

