# IIS_2
# [Windows] IIS로 "Hello World" 띄우기(test1.aspx)

### ASPX 파일 생성

---

- Visual Studio로 Web Form 파일 생성(Web Form 파일이 aspx 확장자를 갖는 파일입니다.)

    ![Untitled](https://raw.githubusercontent.com/KrGil/TIL/main/documents/IIS_2.assets/Untitled.png)

[https://hackersstudy.tistory.com/16](https://hackersstudy.tistory.com/16)

- 생성 후 아래처럼 작성해 줍니다. <title>과 <body>  부분만 수정했습니다.

```bash
<%@ Page Language="VB" %>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta charset="utf-8" />
    <title>.aspx test</title>    
</head>
<body>
    <h1>Hello World</h1>
    <h2>This is a test file.</h2>
</body>
</html>
```

- 작성 후 저장합니다. 저는 D:\Eisen\.net 에 저장했습니다.

![Untitled](https://raw.githubusercontent.com/KrGil/TIL/main/documents/IIS_2.assets/Untitled1.png)

### ISS 관리자 실행

- 웹 사이트 추가 → 저장한 파일 경로를 설정합니다.

![Untitled](https://raw.githubusercontent.com/KrGil/TIL/main/documents/IIS_2.assets/Untitled2.png)

** **포트 번호를 변경해 주셔야 합니다.(본인이 쓰지 않는 포트번호를 설정합니다. i.e) 80 → 8080)**

- 기본 문서로 들어갑니다.

![Untitled](https://raw.githubusercontent.com/KrGil/TIL/main/documents/IIS_2.assets/Untitled3.png)

- 우측의 추가버튼 → test1.aspx  확인을 누릅니다.

![Untitled](https://raw.githubusercontent.com/KrGil/TIL/main/documents/IIS_2.assets/Untitled4.png)

- 그 후 localhost.:8080으로 접속하시면 이렇게 잘 뜨는것을 확인하실 수 있습니다.

![Untitled](https://raw.githubusercontent.com/KrGil/TIL/main/documents/IIS_2.assets//Untitled5.png)

### Result

> 간단하게 사용해본 결과 작동하는 원리나 구조에서는 차이가 있을 듯 하지만 사용하는 과정에서 html과 큰 차이를 느끼지 못했습니다.

# References

[https://hackersstudy.tistory.com/16](https://hackersstudy.tistory.com/16)

[https://www.lifewire.com/what-is-an-aspx-file-2619705](https://www.lifewire.com/what-is-an-aspx-file-2619705)

[https://blog.daum.net/day24hours/12576186#:~:text=aspx는 asp.net 파일의 확장자 입니다.&text=aspx파일은 서버코드,완전히 분리되어 구동됩니다.&text=asp.net는 비쥬얼 스튜디오가 없으면 개발이 힘듭니다.&text=aspx는 닷넷(.net)의 페이지확장자 입니다](https://blog.daum.net/day24hours/12576186#:~:text=aspx%EB%8A%94%20asp.net%20%ED%8C%8C%EC%9D%BC%EC%9D%98%20%ED%99%95%EC%9E%A5%EC%9E%90%20%EC%9E%85%EB%8B%88%EB%8B%A4.&text=aspx%ED%8C%8C%EC%9D%BC%EC%9D%80%20%EC%84%9C%EB%B2%84%EC%BD%94%EB%93%9C,%EC%99%84%EC%A0%84%ED%9E%88%20%EB%B6%84%EB%A6%AC%EB%90%98%EC%96%B4%20%EA%B5%AC%EB%8F%99%EB%90%A9%EB%8B%88%EB%8B%A4.&text=asp.net%EB%8A%94%20%EB%B9%84%EC%A5%AC%EC%96%BC%20%EC%8A%A4%ED%8A%9C%EB%94%94%EC%98%A4%EA%B0%80%20%EC%97%86%EC%9C%BC%EB%A9%B4%20%EA%B0%9C%EB%B0%9C%EC%9D%B4%20%ED%9E%98%EB%93%AD%EB%8B%88%EB%8B%A4.&text=aspx%EB%8A%94%20%EB%8B%B7%EB%84%B7(.net)%EC%9D%98%20%ED%8E%98%EC%9D%B4%EC%A7%80%ED%99%95%EC%9E%A5%EC%9E%90%20%EC%9E%85%EB%8B%88%EB%8B%A4).

[https://docs.microsoft.com/ko-kr/visualstudio/deployment/tutorial-import-publish-settings-iis?view=vs-2019](https://docs.microsoft.com/ko-kr/visualstudio/deployment/tutorial-import-publish-settings-iis?view=vs-2019)
