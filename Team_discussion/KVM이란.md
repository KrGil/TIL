# KVM이란?

KVM(Kernel-based Virtual Machine)은 Linux에 구축되는 오픈소스 가상화 기술입니다.

KVM을 통해 Linux를 _**하이퍼바이저**_로 전환하여 호스트 머신이 게스트 혹은 VM 등 독립된 가상 환경 여려개를 실행할 수 있습니다.

KVM은 Linux를 _**타입1(베어메탈)**_ 하이퍼바이저로 전환하여 구동합니다.



### 하이퍼바이저란?

가상머신을 생성하고 구동하는 소프트웨어입니다.

호스트 컴퓨터에서 다수의 운영 체제를 동시에 실행하기 위한 논리적 플랫폼입니다.

가상머신 모니터(Virtual Machine Monitor, VMM)라고도 불립니다.

단일 하드웨어에서 여러 다른 가상 머신을 호스팅할 수 있는 프로그램입니다.

![image-20211029095355763](/home/eisen/Documents/GitHub/TIL/Team_discussion/KVM이란.assets/image-20211029095355763.png)

​																	출처 : [위키](https://ko.wikipedia.org/wiki/%ED%95%98%EC%9D%B4%ED%8D%BC%EB%B0%94%EC%9D%B4%EC%A0%80)

#### 하이퍼바이저 타입 1(native, bare-metal)

하이퍼바이저가 해당 하드웨어에서 직접 실행되며 게스트 운영 체제는 하드웨어 위에서 2번째 수준으로 실행됩니다.

의견종류:  KVM, Xen, Hyper-v



#### 하이퍼바이저 타입 2(hosted)

일반 프로그램과 같이 호스트 운영 체제에서 실행. VM 내부에서 동작되는 게스트 운영 체제는 하드웨어에서 3번째 수준으로 실행됩니다.

종류:  virtual box, QEMU, VMware Server

 

### Result

> KVM은 하이퍼바이저 중 하나이다.



### References

http://cloudrain21.com/hypervisor-types

