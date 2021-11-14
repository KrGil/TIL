# Dual 모니터 사용 시 한글 번짐 현상

### Before we go

파견 가면서 새로운 모니터를 배정 받았습니다. 이 때 듀얼모니터의 텍스트가 심하게 번지는 현상이 생겨 눈에 상당히 많은 피로를 줄 듯 하더군요. 특히 이클립스는 듀얼 모니터로 못 볼 정도로 눈이 아프더군요.

그래서 한번 검색해 보았습니다.

### 모니터 글자 흐림 또는 번짐 현상(OS)

ClearType 기능

![image-20211110161354280](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/DualMonitor_text.assets/image-20211110161354280.png)

윈도우 검색창에서 ClearType을 검색하여 진행합니다.



### eclipse 텍스트 번짐 수정

>  elipse.exe 파일 우클릭 -> 속성
>
> 상단의 호환성 탭 클릭 -> 하단의 '높은 DPI 설정 변경' 버튼 클릭
>
> 높은 DPI 조정 재정의 체크 -> 응용 프로그램으로 설정

![image-20211110161627683](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Tools/DualMonitor_text.assets/image-20211110161627683.png)

프로그램 재시작 시 뚜렷한 텍스트를 볼 수 있습니다. 응용프로그램으로 설정 후 재시작 했는데도 텍스트 번짐 현상이 나온다면 다른 설정으로 한번 시도해 보시길 바랍니다.



### References

- 고급 배율 설정 및 높은 DPI 설정 변경

  https://mastmanban.tistory.com/1019

- eclipse 텍스트 번짐 오류 해결(응용 프로그램 선택으로 해결)

  https://blog.elmi.page/485#:~:text=%EB%82%B4%EC%9A%A9%EC%9D%84%20%EA%B0%84%EB%8B%A8%ED%95%98%EA%B2%8C%20%EC%9A%94%EC%95%BD,%EC%97%90%20%EC%B2%B4%ED%81%AC%EB%A5%BC%20%ED%95%98%EB%A9%B4%20%EB%90%9C%EB%8B%A4.

- 윈도우 전체 텍스트 설정

  https://nicedayhahaha.tistory.com/entry/%EB%AA%A8%EB%8B%88%ED%84%B0-%EA%B8%80%EC%9E%90-%EB%B2%88%EC%A7%90-%ED%98%84%EC%83%81-%ED%95%B4%EA%B2%B0%EB%B0%A9%EB%B2%95#:~:text=%EB%B3%B4%ED%86%B5%20%EB%AA%A8%EB%8B%88%ED%84%B0%EC%9D%98%20%EA%B8%80%EC%9E%90%EB%B2%88%EC%A7%90,%ED%81%AC%EA%B8%B0%EB%A5%BC%20%EC%A1%B0%EC%A0%88%ED%95%98%EC%8B%9C%EB%A9%B4%20%EB%90%A9%EB%8B%88%EB%8B%A4.