# System Monitoring을 위한 Linux 명령어  

### 관찰대상 파악

물리적소스(하드웨어)
- CPU(Central Process Unit) 중앙처리장치
    - Core(듀얼, 쿼드 등)
    - CPU 자체가 여러개도 가능.
- MEMORY
    - RAM( Random Access Memory )
        - DRAM (SRAM)
    - ROM( ReadOnlyMemory )
- IO( Disk, Network )
    - Disk
        - HDD (자기장)
        - SDD (반도체)
    - Network



## CPU

> ``` lscpu```

```
[jmocha@jmail.kaoni.com eisen]$ lscpu
Architecture:          x86_64
CPU op-mode(s):        32-bit, 64-bit
Byte Order:            Little Endian
CPU(s):                8
On-line CPU(s) list:   0-7
Thread(s) per core:    2
Core(s) per socket:    4
Socket(s):             1
NUMA node(s):          1
Vendor ID:             GenuineIntel
CPU family:            6
Model:                 94
Model name:            Intel(R) Xeon(R) CPU E3-1240 v5 @ 3.50GHz
Stepping:              3
CPU MHz:               900.165
BogoMIPS:              6999.82
Virtualization:        VT-x
L1d cache:             32K
L1i cache:             32K
L2 cache:              256K
L3 cache:              8192K
NUMA node0 CPU(s):     0-7

```

**CPU** : 8

- Sockets * Core * Thread

**Thread(s) per core** : 2

- 최대 두개의 쓰레드가 동시에 구동 가능하다는 의미입니다.
- hyperThread 라고 불리며 최대 2개까지 가능하며 일반적으로 cloud 시스템에서 자주 사용, vcpu라고 표현합니다.

**Core(s) per socker** : 4

- cpu 당 core 갯수를 의미합니다.

**Socket()** : 1

- motherboard()에 cpu 꽃혀있는 갯수를 의미합니다.

**Hypervosor** (가상화가 가능하게하는 소프트웨어) : 

- 표시되어 있으면 가상환경이라는 뜻입니다.

##### 참고

2core vs 2Thread 

- 2Thread는 약 1.5 core 성능을 냅니다.

**HyperThread** 

- 최대 2개의 쓰레드가 한 코어에서 돌아가게 만든 기술(intel)
- 클라우드에 주로 사용(AWS, Azure,,) 
- 1.5코어의 효율을 냅니다.



## Memory

> ``` free -h```

         		      total        used        free        shared 	 buff/cache   available
    Mem:           31G         14G        858M        1.4G         15G         13G
    Swap:           63G        3.3G         60G


``` -h``` 는 human의 약자로 사람이 읽기 쉽게 변환해 줍니다.(G, M 처럼 단위를 읽기 쉽게 변환)

사용 가능한 memory를 보시려면 ```free``` 탭이 아니라 ```available```탭에 표시되어 있습니다.



#### 참고

OS의 Kernel이 IO를 담당합니다. (**buff**)

그래서 모든 userprogram이 disk나 network에 요청할 때 kernel에게 요청, kernel이 대신 요청을 담당해 줍니다. 따라서 kernel전용 버퍼 메모리가 필요하기에 위의 buff에 메모리를 할당해 놓습니다.

```userProgram(vsCode, eclipse,,,) -> Kenel -> disk/network,,```

**cache**

외부에서 요청을 할 때 저장소나 disk에 접근하여 데이터를 가지고오게되면 퍼포먼스가 떨어지기 때문에 cache 저장소를 두고 자주 사용하는 데이터를 보관, LRU(Least Recently Used) 알고리즘을 사용하여 데이터를 관리합니다.



## Disk

> ``` df -hT ```
>
> ```T ```command는 Type을 보기 위함입니다.

```
[jmocha@jmail.kaoni.com eisen]$ df -hT
Filesystem     Type      Size  Used Avail Use% Mounted on
devtmpfs       devtmpfs   16G     0   16G   0% /dev
tmpfs          tmpfs      16G     0   16G   0% /dev/shm
tmpfs          tmpfs      16G   74M   16G   1% /run
tmpfs          tmpfs      16G     0   16G   0% /sys/fs/cgroup
/dev/sdb3      ext4      487G  379G   84G  82% /
/dev/sda1      ext4      118G   67G   46G  60% /volumes/ssd
/dev/sdc1      xfs       559G  511G   49G  92% /volumes/disk3
/dev/sdb2      ext4      477M  180M  268M  41% /boot
/dev/sdb1      vfat      200M  9.5M  191M   5% /boot/efi
overlay        overlay   559G  511G   49G  92% /volumes/disk3/docker/overlay2/77ac4d991e011eec84db354b5bb3ded11588b8a0c92a149bdebe7c2e05c8210f/merged
overlay        overlay   559G  511G   49G  92% /volumes/disk3/docker/overlay2/99467609a54305d40c9edc8c9ef22aee50c8f6f8f3aa1fb4ceb400c5ce174c04/merged
tmpfs          tmpfs     3.2G     0  3.2G   0% /run/user/1006
tmpfs          tmpfs     3.2G     0  3.2G   0% /run/user/1000
```

### Type 

- Windows :``` NTFs```(다른  OS에서는 읽기만 가능합니다.), ```FAT32```(ms-dos부터 존재했기에 범용성이 좋습니다.) 

- Linux : ```ext4```, ```xfs```(최근 많이 사용되고 있습니다.)

*Mount는 formatting(fileSystem) 이후에 가능합니다.*



### ```-l``` long command를 추가하여 sda2 자세히 살펴보기

``` ls -l /dev/sda2 ```

```
brw-rw---- 1 root disk <span style="color:red">8, 19</span> Aug 26 16:15 /dev/sdb3
```

<span style="color:red">8, 19</span> major N, minor N라고 부릅니다.

위의 숫자의 경우 Device Driver의 majorNumber <8>와 minorNumber <19>를 의미합니다.



driver의 갯수는 여러개일 수 있습니다. 따라서 해당 드라이버에 번호를 부여합니다.(major number) ***8***

driver는 여러번 사용할 수 있습니다. 따라서 해당 드러이버가 한번 사용될 때마다 번호를 부여합니다.(minor number) ***19***



#### 참고

##### disk name

- disk를 추가할 때마다 sda, sdb, sdc 등으로 추가됩니다.

##### disk partition

- 해당 disk의 파티션을 나눌 때마다 sda1, sda2, sda3 이 됩니다.

- 보통 disk 자체로 사용하지 않고 파티션 하나에 모든 용량을 할당해서 사용합니다

```
sda

	sda1

sdb

	sdb1 
```

##### disk 작동 flow

- ```disk```(마우스, 키보드, usb 등) ->  ```sda``` -> 파티션나누기  ```sda1```, ```sda2``` -> Device Driver 설치(major number, minor number) 

##### device driver 작동 flow

- mouse -> Device Driver -> Kernel -> disk, network ,, 



#### block 단위로 disk 파악하기

> ``` lsblk```

```
NAME   MAJ:MIN RM   SIZE RO TYPE MOUNTPOINT
sdb      8:16   0 558.9G  0 disk
├─sdb4   8:20   0    64G  0 part [SWAP]
├─sdb2   8:18   0   500M  0 part /boot
├─sdb3   8:19   0 494.2G  0 part /
└─sdb1   8:17   0   200M  0 part /boot/efi
sdc      8:32   0 558.9G  0 disk
└─sdc1   8:33   0 558.9G  0 part /volumes/disk3
sda      8:0    0 119.2G  0 disk
└─sda1   8:1    0 119.2G  0 part /volumes/ssd
```

```/boot``` 의 경우 kernel이 적재되어 있어(vmlinuz...) 따로 살펴볼 필요는 없습니다.

#### Result

System Monitoring을 위해선 sdb3, sdc, sda를 주로 살펴보면 됩니다.

## Network

> ```ifconfig```

```
eth0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 10.0.100.58  netmask 255.255.0.0  broadcast 10.0.255.255
        inet6 fe80::f24f:a93f:ca15:b87f  prefixlen 64  scopeid 0x20<link>
        ether 00:15:5d:66:69:08  txqueuelen 1000  (Ethernet)
        RX packets 18416182  bytes 3247619571 (3.0 GiB)
        RX errors 0  dropped 1259497  overruns 0  frame 0
        TX packets 311309  bytes 21949216 (20.9 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

lo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536
        inet 127.0.0.1  netmask 255.0.0.0
        inet6 ::1  prefixlen 128  scopeid 0x10<host>
        loop  txqueuelen 1000  (Local Loopback)
        RX packets 335600  bytes 196785417 (187.6 MiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 335600  bytes 196785417 (187.6 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

virbr0: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        inet 192.168.122.1  netmask 255.255.255.0  broadcast 192.168.122.255
        ether 52:54:00:e9:ce:68  txqueuelen 1000  (Ethernet)
        RX packets 0  bytes 0 (0.0 B)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 0  bytes 0 (0.0 B)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
```

```eth0``` : ethernet (ZEROX PARK Lab에서 만듦.) 

- 외부 ip, linux는 eth0이라는 이름을 자주 사용. 

```lo``` : loopback adapter (127.0.0.1) local 전용 네트워크 전용 인터페이스.



```NIC(Network Interface Card)``` : LAN Card 

- machine에 NIC가 설치되어 있어야 LAN 선을 연결해도 internet 연결이 됩니다.



*__Network__* 이후의 부분은 다음에 작성하도록 하겠습니다.



## 참고

**Virtual Cloud Servers**

- 대부분의 cloud 서비스를 하는 회사들은 사용자에게 vm으로 서버를 제공합니다.

- aws(amazon), gcp(google), azure(microsoft)

- ```2vCPU``` - 하이퍼쓰레드가 적용되었다는 뜻입니다. core가 2개라는 뜻이 아닙니다.



__*buffer & cache*__ 

- 임시 메모리들을 의미합니다.

​	*buffer*

​		- IO 시 사용됩니다. byte 배열로 이루어져 있고 임의로 크기를 조정할 수 있습니다.

​	*cache*

​		- 복사본을 저장하는 임시공간입니다.

​		- ```block```으로 구성되어 있습니다. 각각의 블록은 각각의 데이터를 담고 있으며, 주소값을 키로 접근할 수 있습니다.

​		- 보통 한 block은 512byte로 이루어져 있습니다.		

​		- ```LRU(Least Recently Used)``` 알고리즘으로 cache 메모리를 다룹니다.

​			*LRU : 가장 최근에 사용한 데이터가 맨 앞에 위치, 가장 최근에 사용되지 않은 항목은 가장 뒤에 위치해 리스트에서 삭제시키는 알고리즘 입니다.* 



**DISK 구조(file System)**

Windows

- disk 추가 시 C: D: E: 로 mount(mnt)가 됩니다.

Linux 

- disk 추가 시 /addDisk/diska .. 처럼 ```path```가 mount(mountPoint) 됩니다.		

- Linux의 mount point는 unmount 후 다시 mount 시켜 변경할 수 있습니다.

- ```root(/)```에 mount 되어 있는 directory를 ```root volume(OS volume)```이라고 부릅니다.



 ### 의문

fileSystem과 device Driver의 연관 관계가 이해가 잘 안가네요.

usb는 이해가 가는데...

마우스나 키보드는 이해가 가지 않네요.

마우스를 연결시키면 device Driver를 설치하는데 Windows는 ntc? 파일 시스템을 따르니 마우스가 ntc 파일 시스템이 되는거?????????

