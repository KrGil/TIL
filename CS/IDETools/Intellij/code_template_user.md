# [intellij] File and Code Templates에서 ${User} 변경하기

> 프로젝트를 시작하기에 앞서 `Code Template` 부분을 수정하려고 합니다. 기존에 작성되어 있던 코드의 경우 작성 되어 있는 것들이 있고 작성되어있지 않은 것들이 존재하여 하나씩 정리해 가면서 쌓여있는 레거시 코드들을 조금씩 걷어나갈 예정입니다. 

# Code Template 설정

> Code Template을 설정하지 않으신 분들은 아래의 링크를 참고해 주세요.
>
> [[IntelliJ] class 생성 시 자동 주석 달기(Comment template)](https://jjam89.tistory.com/222)

![image-20221221161245979](https://raw.githubusercontent.com/KrGil/TIL/8284a27edd3f9b0463357dd2bd37fc8b1a451346/CS/IDETools/Intellij/code_template_user.assets/image-20221221161245979.png)

위와 같이 설정을 했는데 `${USER}`로 기입한 부분에서 `admin` 으로 출력되는 문제가 생겼습니다.

![image-20221221162113550](https://raw.githubusercontent.com/KrGil/TIL/8284a27edd3f9b0463357dd2bd37fc8b1a451346/CS/IDETools/Intellij/code_template_user.assets/image-20221221162113550.png)

아래와 같이 `${USER}` 에 대해 설명이 되어 있습니다. system login 이라는 의미는 os(현재 windows를 사용하고 있습니다.)의 계정을 출력한다는 뜻입니다.

![image-20221221170316277](https://raw.githubusercontent.com/KrGil/TIL/8284a27edd3f9b0463357dd2bd37fc8b1a451346/CS/IDETools/Intellij/code_template_user.assets/image-20221221170316277.png)

window 계정을 변경하기에 이미 환경을 세팅한 부분이 많아 함부로 건들이기 껄끄럽더군요.(~~windows 진짜...~~) 그래서 intellij에서만 해당 부분을 변경하는 방법을 알아 보았습니다.

## Edit Custom VM Options

`cntr + shift + a`로 `Actions` 검색창을 활성화 하거나 `shift` 두번 연타로 검색창을 활성화 하신 후 `Action` 탭에서 `vm`을 검색하시면 아래와 같이 `Edit Custom VM` 옵션이 나옵니다.

![image-20221221161818097](https://raw.githubusercontent.com/KrGil/TIL/8284a27edd3f9b0463357dd2bd37fc8b1a451346/CS/IDETools/Intellij/code_template_user.assets/image-20221221161818097.png)

해당 화면에서 아래와 같이 `Duser.name=YOURNAME` 을 추가 작성해 주시면 됩니다.

```
-Duser.name=YOURNAME
```

![image-20221221161710982](https://raw.githubusercontent.com/KrGil/TIL/8284a27edd3f9b0463357dd2bd37fc8b1a451346/CS/IDETools/Intellij/code_template_user.assets/image-20221221161710982.png)

수정하신 후 intelliJ를 완전히 종료 후 재시작 한 후 class를 생성하게 되면 아래와 같이 `${USER}` 부분이 잘 출력되는 것을 확인하실 수 있습니다. 

![image-20221221162307390](https://raw.githubusercontent.com/KrGil/TIL/8284a27edd3f9b0463357dd2bd37fc8b1a451346/CS/IDETools/Intellij/code_template_user.assets/image-20221221162307390.png)

만약 `javadoc(/**)` 부분을 수정하고 싶으시다면 아래와 같이 `File and Code Templates` -> `Code`의 `Javadoc` 부분을 수정해 주시면 됩니다.

![image-20221221165633794](https://raw.githubusercontent.com/KrGil/TIL/8284a27edd3f9b0463357dd2bd37fc8b1a451346/CS/IDETools/Intellij/code_template_user.assets/image-20221221165633794.png)

감사합니다.



### Reference

https://stackoverflow.com/questions/33138979/how-to-change-user-variable-in-intellij-idea-without-changing-os-user-name



