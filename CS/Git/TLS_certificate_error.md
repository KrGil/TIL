# [Git] <warning>  TLS certificate verification has been disabled! 해결



```
warning: ----------------- SECURITY WARNING ----------------
warning: | TLS certificate verification has been disabled! |
warning: ---------------------------------------------------
```

위와 같은 오류는 `git config --global http.sslVerify` 설정이  `false`로 되어 있기에 발생하는 warning입니다. 



보통 `true`로 변경하게 되면 해결되지만 변경하고 `pull`을 다시 했을 시 아래와 같은 오류가 난다면 



```
fatal: unable to access 'https://10.181.5.55:8443/r/moswms.git/': SSL certificate problem: self signed certificate in certificate chain
```

`git config --global http.sslCAInfo` 를 확인해 보아야 합니다.