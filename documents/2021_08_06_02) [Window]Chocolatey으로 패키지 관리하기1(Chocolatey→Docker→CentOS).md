# [Window]Chocolatey으로 패키지 관리하기1(Chocolatey→Docker→CentOS)

# Window 패키지 관리자 Chocolatey 사용.

> Chocolatey 설치

[[Window] Chocolatey 설치하기](https://jjam89.tistory.com/120)

> 설치된 패키지 리스트 보기

```jsx
choco list --localonly
```

> 존재하는 패키지 살펴보기

[https://community.chocolatey.org/packages](https://community.chocolatey.org/packages)

### Openjdk8을 한번 검색해봅니다.

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled.png)

- openjdk8 패키지가 존재하네요. 제일 위에 있는 것을 클릭해 한번 살펴봅니다.

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%201.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%201.png)

- script가 어떻게 짜져 있는지 Url과 인코딩 방식, 등을 살펴 볼 수 있습니다.

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%202.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%202.png)

```jsx
$ **choco install openjdk8**
```

- 위의 명령어를 입력해서 한번 설치해 봅니다. **(chocolately는 항상 관리자 권한으로 cmd를 실행해야 합니다!)**

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%203.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%203.png)

- 중간에 a를 눌러 모든 스크립트를 동작하겠다 답하고 나면 잘 설치되는것을 볼 수 있습니다.

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%204.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%204.png)

- 보시는바와같이 JAVA_HOME path도 알아서 잡아주게끔 script가 짜져 있네요.

> Docker 설치하기

그럼 이제 본격적으로 docker를 설치해 보겠습니다.

위의 링크를 통해 설치를 하시거나 그냥 docker 홈페이지에서 설치하셔도 상관없습니다.

- chocolately

[https://community.chocolatey.org/packages/docker-desktop#upgrade](https://community.chocolatey.org/packages/docker-desktop#upgrade)

- docker 공홈.

[https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/)

 **docker를 설치하셨다면 머신(컴퓨터)를 재부팅 합니다.**

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%205.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%205.png)

- 재부팅 하고 나면 이렇게 docker가 실행됩니다.

```jsx
$ docker -v
$ docker version
```

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%206.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%206.png)

- 이렇게 잘 설치되어있는 것을 알 수 있습니다.

> CentOS 설치하기

[https://hub.docker.com/_/centos](https://hub.docker.com/_/centos)

```jsx
docker pull centos:7
```

위의 사이트에 알려준 명령어를 사용해 봅니다.

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%207.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%207.png)

설치가 완료되었네요. docker를 한번 살펴 봅니다.

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%208.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%208.png)

이렇게 docker에 centos가 깔려져 있네요.

혹은 아래 명령어를 통해 설치된 image list를 볼 수 있습니다.

> 설치된 Image List 보기

```jsx
$ docker images
```

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%209.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%209.png)

> Images status 보기

```jsx
$ docker ps -a
```

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%2010.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%2010.png)

> CentOS 실행시키기

```jsx
$ docker run -i -t centos:7 /bin/bash
```

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%2011.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%2011.png)

- 실행이 됩니다.

![%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%2012.png](%5BWindow%5DChocolatey%E1%84%8B%E1%85%B3%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B51(Chocolate%20e435f33c16954b539fb0bc1ee4c7736b/Untitled%2012.png)

- docker에서도 실행이 잘 되고 있다는 것을 알 수 있습니다.

> container 종료하기

```jsx
$ exit
```

만약 백그라운드에서 실행이 계속 되고 있다면 아래 명령어로 재접속

```jsx
$ docker attatch {names}
```

exit 를 하면 됩니다.

- 다음에는 mariadb 설치 등을 해보도록 하겠습니다.

## 느낀점

- docker에 centos를 깔던 centos에 docker를 깔던 크게 상관이 없는 듯 합니다.
- docker에 대한 개념이 부족한 듯 하네요. 조금 더 공부해야겠습니다.
- chocolately 사용이 상당히 어색한 듯 하네요. homebrew는 조금 더 익숙하게 사용했었는데...
- 익숙해 지도록 chocolately를 자주 사용해 보아야 겠습니다.

# References

[https://skypacific.github.io/2019/01/24/kang.heehun@dev-env-setting.html](https://skypacific.github.io/2019/01/24/kang.heehun@dev-env-setting.html)

[https://hello-bryan.tistory.com/152](https://hello-bryan.tistory.com/152)

[http://wiki.rockplace.co.kr/pages/viewpage.action?pageId=3216627](http://wiki.rockplace.co.kr/pages/viewpage.action?pageId=3216627)

[https://here4you.tistory.com/267#:~:text=진입했던 컨테이너를 종료,려면 exit 명령어를 이용한다.&text=이 때 주의할 점,수 있으니 주의해야한다](https://here4you.tistory.com/267#:~:text=%EC%A7%84%EC%9E%85%ED%96%88%EB%8D%98%20%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88%EB%A5%BC%20%EC%A2%85%EB%A3%8C,%EB%A0%A4%EB%A9%B4%20exit%20%EB%AA%85%EB%A0%B9%EC%96%B4%EB%A5%BC%20%EC%9D%B4%EC%9A%A9%ED%95%9C%EB%8B%A4.&text=%EC%9D%B4%20%EB%95%8C%20%EC%A3%BC%EC%9D%98%ED%95%A0%20%EC%A0%90,%EC%88%98%20%EC%9E%88%EC%9C%BC%EB%8B%88%20%EC%A3%BC%EC%9D%98%ED%95%B4%EC%95%BC%ED%95%9C%EB%8B%A4).