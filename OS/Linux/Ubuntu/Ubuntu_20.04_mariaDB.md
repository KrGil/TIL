# Ubuntu 20.04에 mariaDB 설치 및 설정하기

### 설치 전 apt 업데이트 시키기

````
sudo apt update && sudo apt-get -y upgrade
````



### mariadb 설치하기

```
sudo apt-get install -y mariadb-server
```



### mariadb 접속하기

```
sudo mysql
```

기존의 ```mysql -u root -p```로 접속하면 버전에 따라 안되는 경우가 존재합니다(10.0+)

```
use mysql
```

```
update user set plugin='' where User='root';
set password = password('YOUR PASSWORD');
flush privileges;
```

위의 명령어들을 사용하여 root의 비밀번호를 지정해 줍니다.

이제 아래의 명령어 위에 설정한 비밀번호를 입력하시면 됩니다.

```
mysql -u root -p
```



### 시간 설정하기

```
sudo timedatectl set-timezone 'Asia/Seoul'
date
```

터미널에서 위의 명령으로 시간을 서울 시간으로 설정합니다. 그 후 아래 명령어로 mysql을 재시작 시킵니다.

```
sudo systemctl restart mysqld
```

그 후 mysql에 접속하여 아래 명령어를 통해 시간을 확인하실 수 있습니다.

```
select now();
```







### References

https://m.blog.naver.com/6116949/221992559683

https://blog.naver.com/6116949/221991858055

https://www.nemonein.xyz/2019/07/2254/

