# [Window] Hiper-v 설치하기

[https://docs.microsoft.com/ko-kr/virtualization/hyper-v-on-windows/quick-start/enable-hyper-v](https://docs.microsoft.com/ko-kr/virtualization/hyper-v-on-windows/quick-start/enable-hyper-v)

# PowerShell을 사용하여 Hyper-V를 사용하도록 설정

- PowerShell 관리자 권한으로 실행.
- cmd에서는 먹히지 않으니 PowerShell로 실행하시기 바랍니다.

```jsx
$ Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All
```

# CMD와 DISM을 사용하여 Hyper-V를 사용하도록 설정

- 역시 관리자 권한으로 실행해야 합니다.

```jsx
$ DISM /Online /Enable-Feature /All /FeatureName:Microsoft-Hyper-V
```

재부팅 이후 윈도우 검색창에 h 를 쳐 보면 이렇게 활성화 된 것을 볼 수 있습니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10_2/Untitled.png?raw=true)
