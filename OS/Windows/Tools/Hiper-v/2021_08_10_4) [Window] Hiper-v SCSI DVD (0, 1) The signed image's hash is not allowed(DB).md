# [Window] Hiper-v SCSI DVD (0, 1) The signed image's hash is not allowed(DB)

> 설치 후 실행 시 오류.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10_4/Untitled.png?raw=true)

보안에 걸려서 이런 메시지가 뜬다고 합니다.

밑에 써져있는 과정을 따라하면 된다고 하니 따라해 보겠습니다.

[https://port135.com/solved-unsigned-images-hash-is-not-allowed-db/](https://port135.com/solved-unsigned-images-hash-is-not-allowed-db/)

> 1. In Hyper-V Manager, make sure the virtual machine is turned off
2. Select the virtual machine. Right click and select “Settings”
3. Go to “Security”
4. Uncheck “Enable Secure Boot”
5. Restart the machine and try to boot from the ISO file

- 우선 VM을 끈 상태에서 우클릭 후 설정을 눌러 줍니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10_4/Untitled1.png?raw=true)

- 체크 해지하기

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10_4/Untitled2.png?raw=true)
- VM을 재시작 하게 되면

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_08_10_4/Untitled3.png?raw=true)

이렇게 설치할 수 있습니다.

자세한 설치 방법은 아래 링크 글의 하단부에 작성되어 있습니다. 참고해 주시기 바랍니다.

- [[Window]CentOS 설치하기(Visual Box 사용)](https://jjam89.tistory.com/130)

# References

[https://port135.com/solved-unsigned-images-hash-is-not-allowed-db/](https://port135.com/solved-unsigned-images-hash-is-not-allowed-db/)
