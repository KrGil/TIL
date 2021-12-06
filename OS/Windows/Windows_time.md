# 윈도우 시간 동기화(부팅시 윈도우 시간이 자동동기화가 안될 시)

> 윈도우 포맷 이후 설정을 다르게 해줬는지 윈도우 부팅 시 매번 시간을 수동으로 동기화 시켜 주어야 하더군요.
>
> 그래서 방법을 찾아 보았습니다.

### 부팅 시 윈도우 시간 자동 동기화 하기

1. service.msc 실행 (```windows + R```)
2. ```windows Time```  실행.
3. 시작유형 _**자동**_으로 변경



``` Windows키 + R ``` -> ```services.msc``` 로 서비스 실행 -> Windows Time 찾아 실행

![image-20211206093002234](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Windows_time.assets/image-20211206093002234.png)

수동 -> 자동으로 변경

![image-20211206093035676](https://raw.githubusercontent.com/KrGil/TIL/main/OS/Windows/Windows_time.assets/image-20211206093035676.png)

이렇게 설정하면 윈도우 재부팅 시 시간이 자동으로 잡히는 것을 볼 수 있습니다.