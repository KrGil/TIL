# authorized_keys가 존재하는데도 비밀번호를 물어볼 경우

.ssh파일 생성, scp로 rsa_id.pub -> authorized_keys로 복사 /home/eisen/.ssh/authorized_keys에 파일이 존재하는데도

비밀번호 입력을 하라고 요구할 시 해결 방법입니다.



```ssh -v eisen@localhost``` 로 로그를 확인 했을 시 

```
❯ ssh -v jmocha@172.30.130.176
OpenSSH_8.5p1, OpenSSL 1.1.1k  25 Mar 2021
debug1: Reading configuration data /c/Users/Eisen/.ssh/config
debug1: Reading configuration data /etc/ssh/ssh_config
debug1: Connecting to 172.30.130.176 [172.30.130.176] port 22.
debug1: Connection established.
debug1: identity file /c/Users/Eisen/.ssh/id_rsa type 0
debug1: identity file /c/Users/Eisen/.ssh/id_rsa-cert type -1
debug1: identity file /c/Users/Eisen/.ssh/id_dsa type -1
debug1: identity file /c/Users/Eisen/.ssh/id_dsa-cert type -1
debug1: identity file /c/Users/Eisen/.ssh/id_ecdsa type -1
debug1: identity file /c/Users/Eisen/.ssh/id_ecdsa-cert type -1
debug1: identity file /c/Users/Eisen/.ssh/id_ecdsa_sk type -1
debug1: identity file /c/Users/Eisen/.ssh/id_ecdsa_sk-cert type -1
debug1: identity file /c/Users/Eisen/.ssh/id_ed25519 type -1
debug1: identity file /c/Users/Eisen/.ssh/id_ed25519-cert type -1
debug1: identity file /c/Users/Eisen/.ssh/id_ed25519_sk type -1
debug1: identity file /c/Users/Eisen/.ssh/id_ed25519_sk-cert type -1
debug1: identity file /c/Users/Eisen/.ssh/id_xmss type -1
debug1: identity file /c/Users/Eisen/.ssh/id_xmss-cert type -1
debug1: Local version string SSH-2.0-OpenSSH_8.5
debug1: Remote protocol version 2.0, remote software version OpenSSH_7.4
debug1: compat_banner: match: OpenSSH_7.4 pat OpenSSH_7.0*,OpenSSH_7.1*,OpenSSH_7.2*,OpenSSH_7.3*,OpenSSH_7.4*,OpenSSH_7.5*,OpenSSH_7.6*,OpenSSH_7.7* compat 0x04000002
debug1: Authenticating to 172.30.130.176:22 as 'jmocha'
debug1: load_hostkeys: fopen /c/Users/Eisen/.ssh/known_hosts2: No such file or directory
debug1: load_hostkeys: fopen /etc/ssh/ssh_known_hosts: No such file or directory
debug1: load_hostkeys: fopen /etc/ssh/ssh_known_hosts2: No such file or directory
debug1: SSH2_MSG_KEXINIT sent
debug1: SSH2_MSG_KEXINIT received
debug1: kex: algorithm: curve25519-sha256
debug1: kex: host key algorithm: ssh-ed25519
debug1: kex: server->client cipher: chacha20-poly1305@openssh.com MAC: <implicit> compression: none
debug1: kex: client->server cipher: chacha20-poly1305@openssh.com MAC: <implicit> compression: none
debug1: expecting SSH2_MSG_KEX_ECDH_REPLY
debug1: SSH2_MSG_KEX_ECDH_REPLY received
debug1: Server host key: ssh-ed25519 SHA256:qXB/ZXgs/y/NBhdMMtfHPO7fbjFPfDS/ZH3ZfMddKZw
debug1: load_hostkeys: fopen /c/Users/Eisen/.ssh/known_hosts2: No such file or directory
debug1: load_hostkeys: fopen /etc/ssh/ssh_known_hosts: No such file or directory
debug1: load_hostkeys: fopen /etc/ssh/ssh_known_hosts2: No such file or directory
debug1: Host '172.30.130.176' is known and matches the ED25519 host key.
debug1: Found key in /c/Users/Eisen/.ssh/known_hosts:12
debug1: rekey out after 134217728 blocks
debug1: SSH2_MSG_NEWKEYS sent
debug1: expecting SSH2_MSG_NEWKEYS
debug1: SSH2_MSG_NEWKEYS received
debug1: rekey in after 134217728 blocks
debug1: Will attempt key: /c/Users/Eisen/.ssh/id_rsa RSA SHA256:NGtFLCgokJedu4joKy4+P0MFFepGyBy5OQh0zy5x5ug
debug1: Will attempt key: /c/Users/Eisen/.ssh/id_dsa
debug1: Will attempt key: /c/Users/Eisen/.ssh/id_ecdsa
debug1: Will attempt key: /c/Users/Eisen/.ssh/id_ecdsa_sk
debug1: Will attempt key: /c/Users/Eisen/.ssh/id_ed25519
debug1: Will attempt key: /c/Users/Eisen/.ssh/id_ed25519_sk
debug1: Will attempt key: /c/Users/Eisen/.ssh/id_xmss
debug1: SSH2_MSG_EXT_INFO received
debug1: kex_input_ext_info: server-sig-algs=<rsa-sha2-256,rsa-sha2-512>
debug1: SSH2_MSG_SERVICE_ACCEPT received
debug1: Authentications that can continue: publickey,gssapi-keyex,gssapi-with-mic,password
debug1: Next authentication method: publickey
debug1: Offering public key: /c/Users/Eisen/.ssh/id_rsa RSA SHA256:NGtFLCgokJedu4joKy4+P0MFFepGyBy5OQh0zy5x5ug
debug1: Authentications that can continue: publickey,gssapi-keyex,gssapi-with-mic,password
debug1: Trying private key: /c/Users/Eisen/.ssh/id_dsa
debug1: Trying private key: /c/Users/Eisen/.ssh/id_ecdsa
debug1: Trying private key: /c/Users/Eisen/.ssh/id_ecdsa_sk
debug1: Trying private key: /c/Users/Eisen/.ssh/id_ed25519
debug1: Trying private key: /c/Users/Eisen/.ssh/id_ed25519_sk
debug1: Trying private key: /c/Users/Eisen/.ssh/id_xmss
debug1: Next authentication method: password
jmocha@172.30.130.176's password:
debug1: Authentications that can continue: publickey,gssapi-keyex,gssapi-with-mic,password
Permission denied, please try again.
jmocha@172.30.130.176's password:
```

위와 같이 키를 찾을 수 없어서 비밀번호 입력으로 넘어간 것을 알 수 있습니다.



### 해결 방법

#### 1. ```.ssh``` 파일 삭제 후 새로 생성 및 권한 설정.

1. 접속할 계정으로 로그인 (```ssh eisen@localhost```)
2. 기존에 있는 ```.ssh``` 파일 삭제 ``` rm -rf .ssh ```
3. 로그인 후 ```/home/eisen/.ssh``` 파일 생성
4. ```chmod 700 .ssh``` 로 ```.ssh```파일 권한 수정

![image-20210910091149601](https://raw.githubusercontent.com/KrGil/TIL/main/Linux/authorized_keys안먹힐시.assets/image-20210910091149601.png)

그럼 위와 같이 소유와 권한이 나타나는 것을 알 수 있습니다.



#### 2. authorized_key 파일 생성 및 권한 설정

##### 방법 1. 직접 생성 및 복사 붙여넣기.

1. .ssh 파일 들어간 후 touch authorized_keys 파일 생성

2. chmod 600 authorized_keys 파일 권한 수정

3. authorized_keys 파일 편집

    로컬에 존재하는 id_rsa.pub 파일 내용 복사 후 붙여넣기

    ``` echo [public_key_string] >> ~/.ssh/authorized_keys ``` 명령어로 작성해도 가능.

4. exit로 나온 후 ssh eisen@localhost로 접속 시도

5. 비밀번호를 물어보지 않으면 수정 성공.

##### 방법 2. scp 이용하여 생성하기

1. /c/Users/<USERNAME>/.ssh 로 들어가기 ``` cd /c/Users/<USERNAME>/.ssh ```
2. ``` scp id_rsa.pub eisen@localhost:/home/eisen/.ssh/authorized_keys ```  로 파일 전송
3. chmod 600 authorized_keys 파일 권한 수정
4. exit로 나온 후 ssh eisen@localhost로 접속 시도
5. 비밀번호를 물어보지 않으면 수정 성공.

##### 방법 3. ssh-copy-id 사용하기



1. ssh-copy-id eisen@localhost 명령어 실행

![image-20210910091854112](https://raw.githubusercontent.com/KrGil/TIL/main/Linux/authorized_keys안먹힐시.assets/image-20210910091854112.png)

2. 아래의 이미지와 같이 WARNING이 뜬다면

![image-20210910092046088](https://raw.githubusercontent.com/KrGil/TIL/main/Linux/authorized_keys안먹힐시.assets/image-20210910092046088.png)

ssh-copy-id -f eisen@localhost 를 사용하거나

서버의 .ssh폴더를 삭제한 후 다시 시도해 주시길 바랍니다.

### Result

해당 계정의 .ssh 파일 삭제 -> 새로 생성(해당계정으로) -> 600 권한 부여 -> authorized_keys 새로 생성



### References

https://blog.secuof.net/28