# [leetCode]LeetCode를 Github에 자동커밋하기

### before we go further

요즘 [지인](https://github.com/Shane-Park)의 강력한 추천으로 프로그래머스에서 leetCode로 넘어갈까 합니다(프로그래머스 2단계가 어려워서...ㅎㅎ) 차근차근 easy 단계부터 시작할까 합니다 ㅎㅎ 가장 처음 two-sum 문제를 풀었는데... 이중for문(O(n^2))으로 푸니 결과가 처참하더군요... 추후에 이것에 대해 글을 작성하도록 하겠습니다ㅎㅎ

![9941F43B5ABDBF4E1F](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/9941F43B5ABDBF4E1F-16423965385951.png)

그러던중 [지인의 글](https://shanepark.tistory.com/322)(여기클릭!)을 보고 아주 간단하게 leetcode와 github을 연동시킬 수 있다는 사실을 알게 되었습니다. leetcode 관련 첫 글을 무엇으로 작성할까 하다가 github 연동시키기로 시작하면 좋을것 같다는 생각에 글을 작성하게 되었습니다!

### LeetCode? LeetHub!

> https://chrome.google.com/webstore/detail/leethub/aciombdipochlnkbpcbgdpjffcfdbggi?hl=en

해당 링크에 접속하면 아래와 같은 화면이 나옵니다.

![image-20220117142637284](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/image-20220117142637284.png)

설치하면 아래와 같이 chrome의 우측 상단에 표시됩니다. 그 후 Authenticate를 클릭하면 

![image-20220117152447849](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/image-20220117152447849.png)

아래와 같은 화면이 나옵니다.

![image-20220117152656752](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/image-20220117152656752.png)

기존에 있는 Repository에 연결시킬 수도 있고 아니면 새로운 프로젝트로 연결시킬 수 있습니다.

#### Notice

기존에 있는 Repository 하단의 경로에는 적용이 되지 않더군요... 혹시 가능한 방법을 아신다면 댓글로 알려주시면 바로 적용해 보도록 하겠습니다.

![image-20220117154641844](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/image-20220117154641844.png)

링크는 제대로 걸리는데 말이죠... ㅠㅠ 아래의 주소로 걸어두어도 되지 않더군요.

```
KrGil/TIL/CS/Algorithm/LeetCode/leetCode
```

> leetcode로 link를 작성했습니다.

링크를 걸 경우 아래와 같은 화면이 뜨게 됩니다.

![image-20220117154940380](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/image-20220117154940380.png)



그 후 leetcode에서 평소와 같이 문제를 풀고 submit을 누릅니다.

![image-20220117155106542](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/image-20220117155106542.png)

그러면 아래 이미지들과 같이 자동으로  github에 글들이 올라옵니다.

![image-20220117155626779](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/image-20220117155626779.png)

chrome의 우측 상단에서 클립한 leethub을 보면 easy가 한개 올라가 있는 것을 알 수 있습니다.

![image-20220117152311711](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Algorithm/LeetCode/LeetCode_Github.assets/image-20220117152311711.png)

###### 

또한 내용을 수정한 후 submit을 클릭하면 github에 잘 반영되는것을 알 수 있습니다



만약 leetcode와 프로그래머스의 차이점 등 leetcode에 대해 좀 더 자세히 알고 싶으신 분들은 아래 링크를 참고하시길 바랍니다.

**https://shanepark.tistory.com/322**

### Caution

블로그를 작성한다고 leethub을 삭제 후 재설치했는데 기존 repository에 존재하는 파일의 경우 따로 반영이 되지 않는걸 알 수 있습니다. 만약 실수로 삭제했고 repository의 내용이 적다면 github의 repository를 삭제한 후 다시 submit을 클릭하면 재반영되는것을 알 수 있습니다.

### References

https://shanepark.tistory.com/322
