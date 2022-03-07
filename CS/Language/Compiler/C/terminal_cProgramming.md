# [C] Terminal(iterm)에서 C언어 프로그래밍 하기



# gcc 설치

![image-20220307201315158](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/C/terminal_cProgramming.assets/image-20220307201315158.png)





## test.c 파일 생성 및 실행

1. vi editor를 사용하여 `test.c`  파일을 생성합니다.

![image-20220307202126300](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/C/terminal_cProgramming.assets/image-20220307202126300.png)

2. vi 모드에 진입한 후 아래의 코드를 입력하고 `:wq`를 입력하여 `test.c`파일을 저장합니다.

```c
#include <stdio.h>

int main(void) {
   printf("Hello, world!\n");
   return 0;
}
```

![image-20220307202144613](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/C/terminal_cProgramming.assets/image-20220307202144613.png)



3. `ll` 명령어를 통하여 `test.c` 파일이 잘 생성되어 있는지 확인해 봅니다.

![image-20220307202217928](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/C/terminal_cProgramming.assets/image-20220307202217928.png)

4. `cc` command를 사용하여 C 언어로 되어있는 파일을 compile 해 줍니다.

해당 명령어르 실행하면 아래 이미지와 같이 `a.out` 이라는 컴퓨터가 이해할 수 있는 언어로 되어 있는 파일이 새로 생성됩니다.

![image-20220307202236754](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/C/terminal_cProgramming.assets/image-20220307202236754.png)

`vi a.out`명령어를 활용하여 해당 파일을 들어가 보면 인간이 알아보기 힘든 언어로 바뀌어 있는 것을 알 수 있습니다.

```
vi a.out
```

![image-20220307202823889](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/C/terminal_cProgramming.assets/image-20220307202823889.png)



5. `./a.out` 명령어로 Hello, world! 를 실행해 봅니다.

![image-20220307202254008](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/C/terminal_cProgramming.assets/image-20220307202254008.png)

이상입니다.

간단하게 mac에서 C 언어로 프로그래밍을 알아보았습니다.

따로 C 프로그램을 배우진 않을 예정이지만 terminal을 활용하여 프로그래밍을 할 수 있다는 사실이 신기하네요.

고생하셨습니다.



### References

http://daplus.net/c-%ED%84%B0%EB%AF%B8%EB%84%90%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-mac-os-x%EC%97%90%EC%84%9C-c-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8%EC%9D%84-%EC%8B%A4%ED%96%89%ED%95%98%EB%8A%94-%EB%B0%A9/

