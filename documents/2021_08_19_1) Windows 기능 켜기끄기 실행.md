

[Windows] IIS(Internet Information Services)

> 개념

- 마이크로소프트 윈도우를 사용하는 서버들을 위한 인터넷 기반 서비스들의 모임
- FTP, SMTP, NNTP, HTTP/HTTPS를 포함하고 있습니다.
- 윈도우 OS에서만 사용이 가능하다. 
- [ASP스크립트][whatisasp] 언어를 사용할 수 있다.

- [IIS 공식사이트][iisHome]



> 설치

- 윈도우 10을 쓰시는 분이시라면 Windows 기능 켜기/끄기를 통해 바로 설치할 수 있습니다.(Windows Server를 설치할 필요가 없습니다.)
- 반드시 .NET Framework를 함께 설치해야합니다.

https://mainia.tistory.com/6131

### Windows 기능 켜기/끄기 실행

---

- Windows 기능 켜기/끄기를 실행시키기 위한 두가지 방법.
  1. Window키 + R 단축키 -> appwiz.cpl 검색으로 창을 띄웁니다.
    ![image-20210819132625692](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819132625692.png)

  2. Windows 설정 -> 앱 선택 -> 앱 및 기능의 가장 하단에 있는 "프로그램 및 기능" 선택합니다.

     ![image-20210819132914456](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819132914456.png)

  ![image-20210819133226369](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819133226369.png)

- 이후 아래 이미지처럼 Windows 기능 켜기/끄기를 클릭하시면 됩니다.

![image-20210819133317614](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819133317614.png)

- 인터넷 정보 서비스 체크

![image-20210819133701053](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819133701053.png)

- World Wide Web 서비스 > 응용 프로그램 개발 기능을 확장시켜 아래 이미지처럼 체크해 줍니다.

  ![image-20210819133929668](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819133929668.png)

```
응용 프로그램 개발 기능의 경우 IIS 에서 응용프로그램을 실행하기 위한 설치 목록들입니다.
- CGI(Common Gateway Interface) : IIS가 외부 프로그램을 실행시키는 방법을 제공. CGI 방식의 요청을 위한 프로그램 
- ISAPI(Internet Server Application Programming Interface) : PHP와 Java 응용프로그램의 연동
```

- .NET Framework 3.5를 설치합니다.

  ![image-20210819134407768](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819134407768.png)

### IIS 웹 서버 구동 및 확인

---

- Windows 관리 도구 -> IIS(인터넷 정보 서비스) 관리자를 선택합니다.

  ![image-20210819141020778](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819141020778.png)

- 사이트 -> Default Web Site -> 시작을 클릭하여 서버를 시작합니다. -> 이후 인터넷에서 "localhost"를 칩니다. 아래와 같은 화면이 뜨면 서버가 잘 돌아가고 있다는 뜻입니다.

  ![image-20210819141304179](C:\Users\NC517\AppData\Roaming\Typora\typora-user-images\image-20210819141304179.png)





# References

[whatisasp]: https://cartney79.tistory.com/279#:~:text=ASP%EB%9C%BB%EC%9D%80%20%EC%82%AC%EC%9A%A9%EC%9E%90%EA%B0%80,%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%A9%EB%8B%88%EB%8B%A4.	"what is asp"

[iisHome]: https://www.iis.net/?utm_medium=iis-deployment	"what is iis"

https://studyforus.tistory.com/265
