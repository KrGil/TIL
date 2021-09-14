# [Container]Docker & Kubernates

# Why?

---

이력서를 작성한 곳의 기술 스택에 처음보는 kubernates라는 단어를 접하게 됨.

이게 무엇인고 하고 구글링 해 봄.

[https://kubernetes.io/ko/docs/concepts/overview/what-is-kubernetes/](https://kubernetes.io/ko/docs/concepts/overview/what-is-kubernetes/)

한글화된 사이트인데도 무슨말인지 모르겠음. 그래서 유튜브에서 검색해 봄.

kubernates란 개념을 알기 위해선 docker에 대한 기본적인 지식이 필요함.

docker에 대해서도 간단하게 검색해 봄.

# Docker

---

- environment disparity를 해겷해줌
- local을 window  |  server는 renux와 같은 다른 환경일 경우.
- docker를 통하면 다른 머신에서도 같은 환경을 구현할 수 있다.

1. local에 docker 설치
2. server에 docker 설치
3. docker 파일 생성( python, git... 등을 설정)
4. local과 server에 docker 파일 주기 

- docker에 다 양한 환경들이 독립적으로 존재하기 때문에 원하는 무슨 환경이든 모듈식으로 관리 가능하다.

# Kubernates

---

- Tool to manage Containers
- Container가 많이 존재할 때 활용.

1. 동시에 컨테이너들을 서버에 올릴 경우(하나의 컨테이너가 죽으면 해당 컨테이너를 재시동 해줘야함.)
    - 최소한 5개 이상의 컨테이너들을 항상 돌리고 하나의 컨테이너가 죽게 된다면 바로 다시 재시동시켜 줌.
2. 동시에 많은 접속자들이 발생했으나 웹/앱이 제대로 준비되어있지 않을 경우
    - 해당 서비스의 니즈에 맞게 새로운 컨데이너들을 자동으로 생성.
    - 만일 접속자의 숫자가 줄어든다면 컨테이너 역시 같이 줄어든다.
3. 새로운 업데이트를 서버에 올려져 있는 컨테이너에 적용시켜야할 경우
    - kube가 자동으로 컨테이너 하나씩 올려줌.(웹사이트가 정지되는 것 없이)

출처 : 

[https://www.youtube.com/watch?v=S3FVcdZcZnA&list=RDCMUCUpJs89fSBXNolQGOYKn0YQ&index=1](https://www.youtube.com/watch?v=S3FVcdZcZnA&list=RDCMUCUpJs89fSBXNolQGOYKn0YQ&index=1)

# Summary

---

- server에 대해 너무 모르고 잇는 듯 함.
- container란 개념이 아직까지도 낯설다.
- docker에 대해서 아주 조금 사용해 보았었지만(mac sqldeveloper를 실행할 때 필요)
- 제대로된 원리에 대해선 아직 잘 모르겠음.