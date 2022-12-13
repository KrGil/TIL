# [intellij] Intellij SVN 연결하기

> 이직으로 아주 예전 코드를 유지보수하는 업무를 맡게 되었습니다. 기존에는 eclipse hellios 버전을 사용하고 있더군요...(무려 2010년에 나온 버전입니다...) 저는 보통 다크모드를 사용하는데 워낙 예전 버전이라 다크모드가 지원하지 않더군요. 너무 예전 버전이라 안먹히는 기능도 많아서 인텔리제이로 세팅해서 사용하려고 합니다. 그 과정에서 svn을 사용(...) 하는데 연결하는 방법에 대해 작성해 보려고 합니다.

# svn 연결하기

## svn url 연결

- intellij 최상단의 탭들 중에서 SVN이라 적혀있는 탭을 선택합니다.

![image-20221212095101188](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\SVN_connect.assets\image-20221212095101188.png)

- `SVN`을 클릭했다면 하단의 `Browse VCS Repository`를 클릭 -> `Browse Subversion Repository`를 클릭합니다.



![image-20221212095143821](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\SVN_connect.assets\image-20221212095143821.png)

- 위와 같은 화면이 나올 탠데 이때 연결할 SVN 주소를 작성해 줍니다.

![image-20221213091204741](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\SVN_connect.assets\image-20221213091204741.png)

연결 시 위와 같은 오류 메시지를 출력됩니다.

https://blog.jetbrains.com/idea/2013/12/Subversion-1-8-and-intellij-idea-13/

> Now, IntelliJ IDEA offers different integration options for each specific Subversion:
>
> - 1.6 – SVNKit only
> - 1.7 – SVNKit and command line client
> - 1.8 – Command line client only
>
> If you opt to the command line client, make sure you have its binaries [installed](http://subversion.apache.org/packages.html) on your machine, because they are not bundled with IntelliJ IDEA.

intellij에 command line client bundle이 없으니 따로 설치 하라는 듯 합니다.



## Apache Subversion Command-line tools 다운받기

> https://www.visualsvn.com/downloads/

![image-20221213091142637](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\SVN_connect.assets\image-20221213091142637.png)

- 위의 url 접속 후 다운받아 줍니다.

![image-20221213091847011](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\SVN_connect.assets\image-20221213091847011.png)

- `Settings` -> `Subversion` 에서 `Path to Subversion executable`에서 경로를 지정해 줍니다. 다만 이때 주의하실 점은 반드시 `svn.exe` 까지 경로를 잡아 주셔야 한다는 것입니다.



![image-20221213092318767](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\SVN_connect.assets\image-20221213092318767.png)

- SVN Repository 탭을 활성해 보면 위의 이미지와 같이 svn이 잘 연동되는 것을 알 수 있습니다.

해당 아티클은 갓대희님의 [**[IntelliJ] IntellijJ- SVN 연동 방법**](https://goddaehee.tistory.com/196) 아티클을 참고하여 작성한 글입니다.

감사합니다.

### Reference

https://goddaehee.tistory.com/196