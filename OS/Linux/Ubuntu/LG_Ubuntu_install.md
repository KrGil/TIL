# LG노트북에 Ubuntu 설치하기

### Before

LG노트북에 설치하기 전에 알아두어야 할 사항이 있습니다. LG노트북은 일반 타 노트북과 달리 linux 설치에 다양한 조건이 필요합니다. 알아두어야 할 사항을 작성하도록 하겠습니다.

> 1. 노트북 사양 확인 및 grub 설정하기. 
> 2. USB 2.0(이건 제 노트북만 그런지는 확실하진 않네요.) 사용.
> 3. 부팅 USB 파티션 : gpt,  파일시스템 : ntfs



### 노트북 사양 확인 및 grub 설정

``` cat /proc/cpuinfo ``` 를 작성하시면 아래와 같이 본인의 노트북 사양을 확인할 수 있습니다.

```
ugs		: spectre_v1 spectre_v2 spec_store_bypass swapgs
bogomips	: 4838.40
clflush size	: 64
cache_alignment	: 64
address sizes	: 39 bits physical, 48 bits virtual
power management:

processor	: 7
vendor_id	: GenuineIntel
cpu family	: 6
model		: 140
model name	: 11th Gen Intel(R) Core(TM) i5-1135G7 @ 2.40GHz
```

Intel 11세대이시면 반드시 ubuntu 21.04 버전을 설치하셔야 합니다. 

21.04버전부터 11세대를 지원하기 때문입니다. 만약 그 전 버전을 LG에 사용하시고 싶으시다면 hdmi 나 허브를 사용하여 다른 다른 모니터와 연결해서 노트북을 닫고 사용하셔야 합니다...

참고 : https://okky.kr/article/952241

``` sudo vim /etc/default/grub``` 파일을 엽니다.

```GRUB_CMDLINE_LINUX_DEFAULT="quiet splash"```

```GRUB_CMDLINE_LINUX_DEFAULT="quiet splash i915.force_probe=4c8a- $vt_handoff"``` 로 옵션을 변경합니다.

*** 주의 ***

위의 링크대로 따라해도 모니터가 제대로 잡히지 않기에 저는 

```GRUB_CMDLINE_LINUX="i915.modeset=0"```을 추가해 주었습니다.(이렇게 했을 경우 노트북에는 제대로 화면이 작동하지만 듀얼 모니터 시 제대로 작동하는지는 확인해 보지 못했습니다. => 듀얼 모니터에서는 제대로 작동하지 않습니다. 듀얼모니터를 사용하시려면 다시 whitespace("")로 바꾸시길 바랍니다.)

이후 grub을 업데이트 합니다.

```bash
sudo update-grub
```

그 후 아래 명령어로 ```configuraion``` 에 driver=i915가 뜨는지 확인합니다.

```bash
sudo lshw -c video
```



```
$ sudo lshw -c video
[sudo] password for eisen: 
  *-display                 
       description: VGA compatible controller
       product: TigerLake GT2 [Iris Xe Graphics]
       vendor: Intel Corporation
       physical id: 2
       bus info: pci@0000:00:02.0
       logical name: /dev/fb0
       version: 01
       width: 64 bits
       clock: 33MHz
       capabilities: pciexpress msi pm vga_controller bus_master cap_list rom fb
       configuration: depth=32 driver=i915 latency=0 mode=1920x1080 visual=truecolor xres=1920 yres=1080
       resources: iomemory:600-5ff iomemory:400-3ff irq:149 memory:6003000000-6003ffffff memory:4000000000-400fffffff ioport:6000(size=64) memory:c0000-dffff memory:4010000000-4016ffffff memory:4020000000-40ffffffff

```

뜬다면 ```reboot``` 으로 재부팅 합니다.

### 추가설정

필자는 ```sudo lshw -c video```를 사용하여 ```cofiguration```에서 ```driver```가 i915로 잘 잡혔지만 재부팅시 여전히 노트북 display를 인식 못했습니다.

그래서 kernel 버전을 변경했습니다.

**참고**

https://webnautes.tistory.com/1500 



우선 부팅 시 ubuntu를 선택하지 말고 그 하단의 ubuntu 고급 설정을 선택, 최상단의 버전 이외의 버전을 선택합니다.(recovery mode 말고)

이렇게 kernel 버전을 변경 후 부팅하니 제대로 부팅이 되었습니다.

```grub-customizer```를 설치하여 ```/boot/grub/brub.cfg```를 편집합니다.

```bash
sudo apt install grub-customizer
```

 그 후 아래 명령어로 ```grub-customizer```를 실행합니다.

```
grub-customizer
```

![image-20211012114748712](/home/eisen/Documents/GitHub/TIL/OS/Linux/Ubuntu/LG_Ubuntu_install.assets/image-20211012114748712.png) 

잘 부팅 되는 5.11.0-16-generic으로 변경합니다.  Ubuntu 우클릭 후 edit

![image-20211012125436082](/home/eisen/Documents/GitHub/TIL/OS/Linux/Ubuntu/LG_Ubuntu_install.assets/image-20211012125436082.png)

![image-20211012125608339](/home/eisen/Documents/GitHub/TIL/OS/Linux/Ubuntu/LG_Ubuntu_install.assets/image-20211012125608339.png)

잘 부팅되는 5.11.0-16 으로 번호만 변경해 줍니다.



### References

https://okky.kr/article/952241

https://webnautes.tistory.com/1500