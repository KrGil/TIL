[IntelliJ] 외부모듈(JAR)의 class 파일 코드가 compiled code로 표기되는 현상

> 최근들어 두번이나 해당 현상을 겪었습니다. 두번째도 첫번째와 동일하게 구글링(...)을 하는 절 보며 블로그에 정리해서 올려야겠다는 생각을 가지게 되었습니다.
>
> 해당 현상 발생 시 저처럼 해결이 잘 되길 바라겠습니다.



## Problem

![image-20220926092413666](C:\Users\Eisen\Documents\GitHub\TIL\CS\IDETools\Intellij\compiled_code.assets\image-20220926092413666.png)

위의 이미지에서 보는 바와 같이 인텔리제이에서 외부 모듈(JAR)의 class 파일을 열었을 시 `/* complied code */`로 표기되는 현상을 최근들어 두번이나 겪게 되었습니다.

한번은 회사에서 IDE 툴인 `intelliJ`를 함께 사용하기 시작했는데 이 때와 두번째는 개인적으로 사용하는 `intelliJ` 버전을 업데이트 하면서 겪게 되었습니다.

**원인**은 `디컴파일러`가 제대로 코드를 해석하지 못해서(?) 라고 합니다.



## Solution



plugin 중에 `Java Bytecode Decompiler' 라는 녀석이 디컴파일을 하는 녀석인데 저는 적용 풀었다 다시 해도 해당 기능이 잘 동작하지 않다군요. 구글링 중 [이 사이트](https://quick-advisors.com/how-to-view-compiled-code-in-intellij/)의 방법을 따라하니 잘 동작하더군요.

https://quick-advisors.com/how-to-view-compiled-code-in-intellij/

> ### How to read Java class file in IntelliJ?
>
> Locate the file in ${IntelliJ_INSTALL_DIR}\plugins\java-decompiler\lib\java-decompiler. jar (example: C:\Program Files\JetBrains\IntelliJ IDEA 2018\plugins\java-decompiler\lib). Copy it somewhere and rename to fernflower. jar (optional).

원문의 내용 중 제가 따라해서 해결했던 부분인데요 

java-decompiller.jar의 이름을 fernflower.jar로 변경해 주었습니다.

![image-20220926092854096](C:\Users\Eisen\Documents\GitHub\TIL\CS\IDETools\Intellij\compiled_code.assets\image-20220926092854096.png)



그러면 아래와 같이 class 내부의 코드가 잘 나오는 것을 확인할 수 있습니다.

![image-20220926132005745](C:\Users\Eisen\Documents\GitHub\TIL\CS\IDETools\Intellij\compiled_code.assets\image-20220926132005745.png)

감사합니다.



### References

https://web2eye.tistory.com/247

https://quick-advisors.com/how-to-view-compiled-code-in-intellij/

> 

다른 방법 안됨 

