# Docker
# [Docker] Docker 컴포넌트

책 "완벽한 IT 인프라 구축을 위한 Docker" 를 읽고 작성한 것입니다.

### 종류

- Docker Engine
- Docker Registry
- Docker Compose
- Docker Machine
- Docker Swarm

### Docker Engine(Docker의 핵심 기능)

---

> Docker **이미지를 생성**하고 **컨테이너를 기동**시키기 위한 Docker의 핵심 기능.
> Docker의 명령 실행이나 Dockerfile에 의한 이미지도 생성합니다.

### Docker Registry(이미지 공개 및 공유)

---

> 컨테이너의 바탕이 되는 Docker **이미지를 공개 및 공유**하기 위한 레지스트리 기능.
> Docker의 공식 레지스트리 서비스인 Docker Hub도 이 Docker Registry를 사용하고 있습니다.

### Docker Compose(컨테이너 일원? 관리)

---

> **여러 개의 컨테이너** 구성 정보를 코드로 정의, 명령을 실행함으로써 어플리케이션의 실행 환경을 구성하는 컨테이너들을 일원? 관리하기 위한 툴입니다.(한번에 관리하기 위한 툴인 듯 합니다.)

- 여러 서버를 컨테이너로 띄우는 경우 매번 각각의 명령어를 통해 실행시키고, 종료 시킬 경우에도 각각을 종료시켜야하는 불편함이 존재하는데, docker-compose.yml 파일에 여러번 중복되는  docker 명령어를 미리 적어두고 docker-compose를 키고 끄는 명령어로 명시된 컨테이너들을 한번에 키고 끌 수 있는 기능입니다.

### Docker Machine(Docker 실행 환경 구축)

---

> 로컬 호스트용인 VirtualBox를 비롯하여 AWS(Amazon Web Services) EC2나 Microsoft Azure와 같은 **클라우드 환경**에 Docker의 **실행 환경을 명령으로 자동 생성**하기 위한 툴입니다.

### Docker Swarm(클러스터 관리)

---

> Docker Swarm은 **여러 Docker 호스트를 클러스터화**하기 위한 툴. docker Swarm에서는 클러스터를 관리하거나 API를 제공하는 역할은 Manager가, Docker 컨테이너를 실행하는 역할을 Node가 담당합니다. 또한 오픈소스인 Kubernetes도 이용할 수 있습니다.

- 

ocker-compose scale 옵션으로 컨테이너 스케일링이 가능한데,

코드를 업데이트하고 컨테이너를 교체하고 싶을 때, 전체를 껐다 켜야하는 단점이 있다.

swarm을 이용하면 이런 부분에서 좀 더 유연한데,

컨테이너가 k 개 떠있을 때,

1개 씩만 차례대로 교체함으로써(rolling update) 서버 애플리케이션을 실행하는 컨테이너의 경우

업데이트와 동시에 유저의 요청을 계속 받을 수 있는 장점이 있다.

Link: [쇼핑몰 사례로 알아보는 Docker Swarm과 Compose의 차이점](https://code-machina.github.io/2019/08/06/Difference-between-Docker-Composer-N-Swarm.html)

Link: [Docker-compose와 Swarm](https://aimaster.tistory.com/7)

### Docker 사양

---

> macOS : OSX Yosemite 10.10.3 이상
> Windows : Microsoft Windows 10 Professional 또는 Enterprise 64-bit

> 그 외의 환경에서는 Docker ToolBox를 이용할 수 있습니다.

# References

[https://code-machina.github.io/2019/08/06/Difference-between-Docker-Composer-N-Swarm.html](https://code-machina.github.io/2019/08/06/Difference-between-Docker-Composer-N-Swarm.html)

[https://aimaster.tistory.com/7](https://aimaster.tistory.com/7)