# [Git_Error] remote: HTTP Basic: Access denied and fatal Authentication 에러를 해결하기

자격증명관리자

```shell
git config --system --unset credential.helper
```

위의 로직 실행 시 

```shell
error: could not lock config file [C:/Program Files/Git/etc/gitconfig: Permision denied]
```

윈도우 권환 설정으로 안됨.



자격증명관리자 실행으로 해결.

