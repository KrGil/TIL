# [Shoveling] 코드 블럭 오류(라고 생각했던 삽질기)

> 오늘 [JitPack을 활용하여 라이브러리 생성하기(maven, gradle)](https://jjam89.tistory.com/216?category=903881) 글을 다시 살펴 보는 중 코드블럭들 중 하나가 hljs(highlightjs)를 적용시키지 않더군요. 그래서 확인해 보았습니다.

# Before we go further

저는 `typora`라는 markdown editor를 사용하고 있습니다. 헌데 평소와 같이 code를 작성하여 올렸었는데 어떤 것은 제 의도대로 잘 나오고 어떤 것은 이상하게 나오더군요. 그래서 왜 이런 현상이 일어나는지 알아보았습니다.(~~hljs에서 놓친 부분이 있다고 생각하고 신나게 구글 번역기까지 돌려가며 issue 작성 중에 제 잘못이라는 것을 깨달았습니다...~~)

![image-20220304223340678](/Users/eisen/Documents/Github/TIL/Tistory/highLightJs.assets/image-20220304223340678.png)

*네... 작성하다가 제 실수인걸 알고 후다닥 지웠습니다...*

# Problem

[JitPack을 활용하여 라이브러리 생성하기(maven, gradle)](https://jjam89.tistory.com/216?category=903881)해당 글에서 아래와 같이 codeblock이 깨져서 나오더군요.

![image-20220304124547789](https://raw.githubusercontent.com/KrGil/TIL/07cb25426428920219a7923c3c49e265ef6889de/Tistory/highLightJs.assets/image-20220304124547789.png)

원래 의도는 아래와 같았는데 말이죠.

![image-20220304124848397](https://raw.githubusercontent.com/KrGil/TIL/07cb25426428920219a7923c3c49e265ef6889de/Tistory/highLightJs.assets/image-20220304124848397.png)



# Solve

> 해당 문제를 해결하기 위해 제가 무의식적으로 했던 패턴을 한번 정리해 보았습니다.
>
> 1.  f12 즉 개발자 도구를 키고 문제의 부분과 제대로 되어 있는 부분을 파악 및 비교하는 것이었습니다.
>
> 2. 저는 typora를 사용하기에 typora에 실질적으로 어떻게 글이 짜여져 있는지 확인해 보았습니다.
>
>    (typora는 command + / 버튼으로 본인이 작성한 markdown 언어를 확인할 수 있습니다.)
>
> 3. 가설을 세운 후 글을 하나씩 재작성 해 보며 어느 부분이 오류를 일으키는지 확인해 보았습니다.
>
>    (typora의 codeblock에 존재하는 태그들이 문제라 여겨 변경해 보았습니다.)
>
> 4. typora의 codeblock에서 markup을 입력 시 해당 문제가 발생하는 것을 발견.
>
>    관련하여 분석하니 typora는 markup이 아닌 markdown을 지원.

## 1. 개발자 도구 확인

아래와 같이 `markup`은 hljs가 지원하지 않는 것을 확인했습니다. markup이 아니라 markdown으로 사용했어야 했는데 말이죠... 이땐 그걸 몰랐습니다.

![image-20220304124705757](https://raw.githubusercontent.com/KrGil/TIL/07cb25426428920219a7923c3c49e265ef6889de/Tistory/highLightJs.assets/image-20220304124705757.png)

잘 적용된 친구와 비교해서 살펴 보았습니다.  상단의 `<code class="language-xml hljs">` 부분이 다르다는 것을 알아차립니다.

![image-20220304124936673](https://raw.githubusercontent.com/KrGil/TIL/07cb25426428920219a7923c3c49e265ef6889de/Tistory/highLightJs.assets/image-20220304124936673.png)

## 2. typora 확인

실제 블로그에 올리기 전 작성한 typora의 글을 확인해 보았습니다. 

문제의 부분은 우측 하단 언어 지정란이 markup으로 되어 있으며

![image-20220305000129603](https://raw.githubusercontent.com/KrGil/TIL/main/Tistory/highLightJs.assets/image-20220305000129603.png)

잘 작성되어있는 부분은 xml로 작성되어 있네요.

![image-20220305000638705](https://raw.githubusercontent.com/KrGil/TIL/main/Tistory/highLightJs.assets/image-20220305000638705.png)



## 3. 가설 확립 및 확인

이 때 언어를 `markup`일 경우 제대로 적용이 되지 않을 것이라는 가설을 세웠습니다. 다른 언어로 설정했을 경우는 xml과 같이 잘 적용될 것이고요.

블로그 포스팅을 여러번 해본 결과 가설이 확인되었습니다.



## 4. typora 확인

이 단계에서 typora의 언어 입력 창에 `markup`이 존재하지 않는다는 사실을 알게 되었습니다. 그리고 지원하는 언어가 `markdown`이라는 사실도요.

*사실 이 단계의 경우 [hljs의 github](https://github.com/highlightjs/highlight.js)에 글을 남기기 위해 확인하다 알게 되었습니다... 내 첫 contribute...*



음... 저는 이런 프로세스로 일처리를 하고 있는 중이었군요. 평소에는 의식하지 않았는데 제 문제 해결 프로세스를 세분화하고 점검해 보니 나름 합리적으로 움직이고 있는 듯 하네요.