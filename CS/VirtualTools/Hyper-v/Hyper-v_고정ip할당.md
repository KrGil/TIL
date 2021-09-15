# :Hyper-v 고정 ip 

### ip 변동

잘 사용하다 한번씩 ip가 변동되어서 config(alias)에 설정한 ip들을 계속 바꿔 주어야 하더군요.

몇번 변경하다 ~~~귀찮아서~~~ 이번에 검색을 한번 해 보았습니다.



### 가상 스위치 설정 변경

#### 현재 컴퓨터에 연결된 랜선, 와이파이 등을 공유 설정으로 생성한 스위치가 사용할 수 있도록 연결.

- 저는 스위치의 이름을 CentOS라고 지었습니다.

![image-20210906110645340](https://raw.githubusercontent.com/KrGil/TIL/main/VirtualTools/Hyper-v/Hyper-v_고정ip할당.assets/image-20210906110645340.png)



#### 생성한 switch 설정하기.

- 보통 연결하면 192.168.137.1로 설정이 잡히는 듯 하더군요.

![image-20210906111352867](https://raw.githubusercontent.com/KrGil/TIL/main/VirtualTools/Hyper-v_고정ip할당.assets/image-20210906111352867.png)



### OS 설정 변경

#### 유선 설정 변경

centos에 접속해 설정을 바꿔 줍니다.(우측 상단의 유선 네트워크 설정)

![image-20210906133017981](https://raw.githubusercontent.com/KrGil/TIL/main/VirtualTools/Hyper-v_고정ip할당.assets/image-20210906133017981.png)

그 후 설정 버튼을 클릭한 후 IPv4를 아래 이미지와 같이 변경해줍니다.

![image-20210906133119837](https://raw.githubusercontent.com/KrGil/TIL/main/VirtualTools/Hyper-v_고정ip할당.assets/image-20210906133119837.png)



아래 코드를 통해 잘 연결 되어있는지 확인합니다.

``` 
ip route show
```

![image-20210906133230737](https://raw.githubusercontent.com/KrGil/TIL/main/VirtualTools/Hyper-v_고정ip할당.assets/image-20210906133230737.png)



## 치명적인 결함

사용한지 10분만에 치명적인 결함을 발견했습니다. 

**이더넷의 공유 설정을 수정하면**

모바일 핫스팟 설정이 죽어버리더군요.

회사에서는 따로 와이파이가 없어서(~~~이게 말이 됩니까!?~~~) 노트북으로 사용하는 중인데 말이죠...

... 어쩔 수 없이 다른 방법을 찾아보아야 할 듯 합니다.



이때 네트워크의 지식에 대해 한계를 느껴 네트워크에 대해 공부를 좀 하고 다시 도전...

결론적으로 이더넷 공유 설정을 빼고 위의 과정을 그냥 진행 해봤습니다.

### 현재 사용하고 있는 Switch 분석(Default Switch)

### Default Switch 분석

![image-20210906152457280](https://raw.githubusercontent.com/KrGil/TIL/main/VirtualTools/Hyper-v_고정ip할당.assets/image-20210906152457280.png)

#### CentOS 접속 후 ip route show 실행 시

![image-20210906152534483](https://raw.githubusercontent.com/KrGil/TIL/main/VirtualTools/Hyper-v_고정ip할당.assets/image-20210906152534483.png)

- Default Switch에서 설정한 ip를 기반으로 eth0가 172.25.24.14 로 가지를 친 것을 볼 수 있습니다.
- 14 -> 13으로 변경해 보도록 하겠습니다.

 

게이트웨이로 잡아준 Default Switch의 ip가 변하지 않는다면 centOS 내부에서 고정 ip를 할당 시키면 될 듯 하네요.

![image-20210906162035303](https://raw.githubusercontent.com/KrGil/TIL/main/VirtualTools/Hyper-v_고정ip할당.assets/image-20210906162035303.png)



#### CentOS 접속 후 설정 변경

주소 : 원하는 주소(172.25.16 까지는 동일하게 설정해야 합니다. 그렇지 않으면 동일한 네트워크를 사용한다고 인식하지 못해 centos에서 인터넷 연결이 안됩니다.)

네트마스크 : 위 이미지의 서브넷 마스크로 동일하게 작성합니다.

게이트웨이 : 위 이미지의 ip 주소를 작성합니다. 

유선 연결을 끊었다가 다시 연력합니다.



```
$ ip route show
default via 172.25.16.1 dev eth0 proto static metric 100
172.25.16.0/20 dev eth0 proto kernel scope link src 172.25.16.13 metric 100
192.168.122.0/24 dev virbr0 proto kernel scope link src 192.168.122.1.
```

ssh 172.25.16.13으로도 잘 들어가집니다.



컴퓨터를 껐다 키니 Default Switch의 IP가 달라지네요 ㅠㅠ



이더넷에 직접 공유해 ip를 받아와 사용하는 방법이 제일 현실적 인 듯 하네요. 단지

제가 컴퓨터로 와이파이를 공유하는지라... 



만약 고정 ip를 원하시는 분들은 맨 처음의 방법을 사용해 보시길 바랍니다. 



Switch는 하나의 게이트웨이처럼 되는 듯 합니다.

> switch  ip -> centos 게이트웨이
>
> switch 서브넷마스크 -> centos 네트마스크



### References

- 우분투 설정

    https://itsandtravels.blogspot.com/2020/07/ip-pc-hyper-v-ip.html

- 참고

    https://open-infra.tistory.com/14
    
    https://seokbeomkim.github.io/posts/static-ipaddr-for-hyper-v/
    
    https://www.altaro.com/hyper-v/the-hyper-v-virtual-switch-explained-part-1/
    
- 라우터, 네트워크 등 기초

    https://www.youtube.com/watch?v=Av9UFzl_wis&list=PL0d8NnikouEWcF1jJueLdjRIC4HsUlULi