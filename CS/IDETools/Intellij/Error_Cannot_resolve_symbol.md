# [Error] IntelliJ Cannot resolve symbol

### Befor we go

> 잘 실행되던 intelliJ의 프로젝트가 갑자기 빨간줄들이 그이면서 "Cannot resolve symbol..." error를 토해내기 시작했습니다. rebuil 후 재시작을 해 보았지만 해결되지 않더군요. 그래서 이것 저것 검색하다 시도한 해결방법들을 작성해 보겠습니다.



### Solution

1.  프로젝트를 rebuild 합니다.

   > 상단의 Build -> Rebuild Project를 선택합니다.
   >
   > 그 후 재시작.

![image-20211112083207494](/home/eisen/Documents/GitHub/TIL/CS/IDETools/Intellij/Error_Cannot_resolve_symbol.assets/image-20211112083207494.png)



2. 캐시를 비워줍니다.

> 상단의 File -> Invalidate Caches ... 를 클릭합니다.
>
> 그 후 아래 이미지와 같이 선택 후 실행해 줍니다.

![image-20211112083421528](/home/eisen/Documents/GitHub/TIL/CS/IDETools/Intellij/Error_Cannot_resolve_symbol.assets/image-20211112083421528.png)

![image-20211112083458226](/home/eisen/Documents/GitHub/TIL/CS/IDETools/Intellij/Error_Cannot_resolve_symbol.assets/image-20211112083458226.png)



3. Gradle을 Refresh  해줍니다.

   > 상단의 View -> Tool Windows -> Gradle을 클릭한 후
   >
   > 프로젝트명을 마우스 우클릭 후 Refresh Gradle Dependencies를 누르고 기다립니다.

![image-20211112084952695](/home/eisen/Documents/GitHub/TIL/CS/IDETools/Intellij/Error_Cannot_resolve_symbol.assets/image-20211112084952695.png)

4. Gradle 빌드 설정을 intelliJ IDEA로 바꿔줍니다.

> Settings -> Build, Execution, Deployment -> Build Tool -> Gradle -> Build and Run의 설정을 IntelliJ IDEA로 바꿔줍니다.

![image-20211112085226125](/home/eisen/Documents/GitHub/TIL/CS/IDETools/Intellij/Error_Cannot_resolve_symbol.assets/image-20211112085226125.png)

5. intelliJ의 버전을 체크해 봅니다.

   위의 방법들 모두 실행되지 않으면 최신버전으로 업데이트를 해보시길 바랍니다.

위의 과정을 모두 실행 한 후 IDE를 재시작 해주시길 바랍니다.





### References

**https://ottl-seo.tistory.com/entry/IntelliJ-Cannot-resolve-symbol-%EC%97%90%EB%9F%AC-%ED%95%B4%EA%B2%B0**



