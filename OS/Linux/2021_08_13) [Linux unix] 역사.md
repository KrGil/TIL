# [Linux/unix] 역사

# Unix

- **Multics**
- **BSD**
    - 조이(Bill Joy)
    - 척 핼리(Chuck Haley)
- **Unix**
    - 켄 톰슨(Ken Thomson)
    - 데니스 리치(Dennis Ritchie) | C언어
    - 피터 뉴만(Peter Neumann)
- **GNU**
    - 리차드 스톨먼(Richard Stollman)
- **Linux**
    - 리누스 토발즈(Linus Torvald)

### Multics

- 1960s

```java
AT&T(AT&T의 연구소 Bell Laps), MIT 등 쟁쟁한 기업들이 MULTICS 라는 끊이지 않고 돌아갈 수 있는 다중 사용자, 
다중 프로세서 기반의 시스템을 만드는 프로젝트를 시작하였습니다.
```

- 결과적으로  해당 프로젝트는 실패했습니다만 이 프로젝트로 인해 현재의 linux가 탄생하게 됩니다.
- 15년 정도 프로젝트가 진행되었지만 너무 완벽한 프로젝트를 만들려는 시도로 인해 프로젝트 자체가 점점 무거워지고 방대해지고 종국에는...

### Unix

- 1969s

> Ken Thompson

```
AT&T(Bell Laps)의 연구원이자 MULTIX 프로젝트 참여자입니다.
당시 연구소에 안쓰는 PDP-7 컴퓨터가 있는 것을 보고는, 이 컴퓨터에다가멀틱스와 비슷한 개념을 가진 운영체제를 한번 구현하게 됩니다. 
당시 같은 연구소의 데니스 리치(Dennis Ritchie)와 피터 뉴만(Peter Neumann) 역시 같이 켄의 프로젝트에 동참하게 되고, 이 운영체제의 이름을 유닉스(Unix) 라고 부르게 되었습니다. 
```

- Multics와는 달리 unix는 프로그램을 실행 시키는것에만 집중을 하였습니다.
- 이때의 unix는 assembly language로 작성되었습니다.(추후에 c 언어로 교체됩니다)

이때 당시의 기술로는 하나의 프로그램을 짜면 다른 기종의 컴퓨터에서는 그 기종에 맞게 새로 프로그램을 짜야 했습니다.
왜냐하면 기계언어의 형태가 컴퓨터 기종마다 모두 달랐기 때문입니다.
그래서 PDP-7 외의 컴퓨터 기종 유닉스를 사용하려면 해당 컴퓨터에 맞게 프로그램을 다시 짜야했습니다.

- Multi + ics로 MULTICS가 되고 Unique + ics 로 Unix로 명명하게 되었다는 말이 있습니다.

```java
계속 AT&T 의 연구소인 Bell Laps 에서 사용되면서 unix는 점점 발전하게 됩니다. 그러던 중
데니스 리치(Dennis Ritchie)가 C언어를 개발하게 되고 Unix는 C 언어로 재구성됩니다.
Assembly Language와는 다르게 C 언어는 다른 컴퓨터 기종과의 포팅이 매우 쉬은 언어(당시)
이기에 이때부터 Unix가 외부로 엄청나게 퍼져나가기 시작합니다.
```

- 여러 대학들에서 많이 사용하는 프로그램이 되었고
- 이때 당시에는 대부분 격리된 장소였고 네트워크로의 접근이 힘든 시기였습니다.
- 그래서 각자 자신들만의 unix 버전을 사용하기 시작했습니다.

**이때의 AT&T사는 법적 제재를 받고 있어서 본업인 전화 외에는 다른 사업을 할 수 없는 상황이었습니다.

### BSD(Berkeley Software Distribution)

- 1970년대 말
- University of California at Berkeley에서 unix를 구매, 자체적으로 개발하게 됩니다.

```java
버클리대학의 조이(Bill Joy) 척 핼리(Chuck Haley)는 1978년에 자기들이 수정한 코드로 만든
유닉스와 유틸리티들을 포함해서 만든 프로그램을 50$의 가격으로 배포하게 됩니다.
최초의 BSD 버젼의 유닉스 시스템이 탄생하게 됩니다.
```

- BSD는 멀티태스킹을 지원했으며 4.2버전은 무려 네트워킹 기능이 추가되었습니다.
- 이로 인해 유닉스를 사용하여 근거리 통신망(LAN)을 구축하기 매우 간편해 졌으며 매우 광범위하게 사용되기 시작했습니다.

사실 네트워크 기능이 추가된 4.2 버전의 경우 5.x버전으로 명명되는것이 옳으나 이때 즈음에 AT&T사의 법적 제약이 풀리게 되었고 AT&T는 Unix에 대한 상표권 권리를 주장할 수 있게 되었습니다.
그리고 자신들만의 SystemV라는 표전버전을 공표하고 그 외의 버전은 "비표준"이라고 불렀습니다.

4.2 버전을 5.x버전이라 부르게 되면 BSD는 다른 대학와 회사에 판매하기 위해서 AT&T와 재계약을 해야 했습니다. 그래서 네트워크 기능이 추가된 버전을 5.x로 부르지 않고 4.2 버전으로 부르게 되었습니다. 

> 여타 많은 Unix 제품들

- 이렇게 SystemV, BSD 로 갈라지면서 또다시 SystemV와 BSD를 기반으로 하는 많은 시스템들이 파생되기 시작됩니다.

```java
NEXTSTEP    - Mach, BSD
FreeBSD     - BSD
BSD/OS      - BSD
SunOS       - BSD
Linux       - BSD, System V.3
DEC OSF/1   - BSD, OSF/1
AIX         - BSD, OSF/1, System V.4
HP-UX 10    - BSD, OSF/1, System V.4
Solaris     - BSD, System V.4
IRIX        - BSD, System V.3, System V.4
SCO Unix    - System V.3
```

- 여러 회사들이 서로의 호환성 문제로 인해 병합하려는 시도가 많이 일어났었습니다.
- 그리고 이러한 사업화 과정에서 unix는 더이상 오픈 소스로 존재하지 못하고 점점 폐쇄적으로 바뀌게 되었습니다.

### GNU(Gnu is Not Unix)

- 1984년

```java
MIT 인공지능 연구소의 연구원인 리차드 스톨먼(Richard Stollman)은 소스를 공개하지 못하도록 
하는 분위기와 기술을 상업화하려는 조류에 반감을 갖고 새로운 시스템을 구상하게 됩니다.
그 모델이 된 것은 UNIX였습니다. 그는 C로 작성된, 그리고 모두에게 공개된 UNIX 시스템을 위해 
GNU(GNU is Not Unix) 프로젝트를 시작하게 되었습니다. 
그는 GNU 프로젝트 MIT로부터 저작권과 관련한 어떤 제약을 받게 될 것을 우려하여, 
MIT 연구원 직을 사직할 만큼, 완전히 자유로운 운영체제를 원했습니다.
```

- GNU 프로젝트로 개발된 에디터인 Emacs에 대한 사용자들의 관심이 높아지면서, 스톨먼은 GNU프로젝트 운영을 위해 FSF(Free Software Foundation, 자유 소프트웨어재단)을 설립했습니다.
- GNU프로그램들의 배포 라이센스인 GPL(General Public License)하에서 판매되었습니다.(모든 소스는 반드시 공개되어야 한다.)
- GNU 프로젝트는 운영체제의 핵심이 되는 커널이 빠져 있는 상태였으며, 자체적인 'Hurd' 커널을 개발하기 시작했으나 좀처럼 진척이 되지 않고 있었습니다.
- 시간이 흘러 GNU와 Linux와의 합작으로 완전한 구조를 가지게 되었으나 Linux라고만 불리었기  때문에 GNU는 GNU/Linux라는 단어를 쓰길 원하고 있습니다.

[https://www.gnu.org/](https://www.gnu.org/)

### Linux

> Linus Torvalds (리누스 토발즈)

- 학습 목적의 MINIX를 사용하던 중 Linux 개발 계획 발표
- 초기 버전은 기본적인 커널만을 포함하고 있었으나 추후에 bash, gcc등을 지원하게 되었습니다.
- 리눅스는 GNU의 시스템 프로그램들을 포함하고 있으며 커널 부분을 독자적으로 개발하게 됩니다. 시간이 지나자 스톨먼과 FSF는 유닉스 커널과 호환 가능한 커널인 리눅스를 GNU시스템의 커널로 채택하기로 했습니다.
- 리눅스는 강력한 GNU C 컴파일러인 gcc로 컴파일된  많은 응용프로그램들을 가지게 되었고, 둘의 결합으로 GNU시스템은 완전한 구조를 갖추게 되었습니다.

> 발전 역사

![Untitled](%5BLinux%20unix%5D%20%E1%84%8B%E1%85%A7%E1%86%A8%E1%84%89%E1%85%A1%2036992fb7fcfc40e18aeaa7377be8b1a9/Untitled.png)

> ETC

- macOS는 (10버전부터) unix kernel(Darwin)을 사용하고 있습니다.
- Android는 Linx kernel을 사용하고 있습니다.
- Linux에는 RHEL / CentOS, Debian / Ubuntu 등이 있습니다.
- OS(운영체제)는 크게 Kernel(컴퓨터 제어 소프트웨어)과 System Program(shell, editor, compiler... 명령어와 같은 utility들)으로 돌아갑니다.

# References

- [http://coffeenix.net/doc/misc/unix-history.html](http://coffeenix.net/doc/misc/unix-history.html)
- [http://12bme.tistory.com/220](http://12bme.tistory.com/220)