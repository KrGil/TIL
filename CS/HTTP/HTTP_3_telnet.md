# HTTP_3_telnet

### telnet을 이용하여 HTTP/1.0과 1.1 차이 알아보기(Centos) 



``` $ telnet <domain(DNS)> <port>```

google로 한번 요청을 보내 봅니다.

```bash
[jmocha@localhost.localdomain ~]# telnet google.com 80
telnet google.com 80
Trying 172.217.175.46...
Connected to google.com.
Escape character is '^]'.

```

__*google.com*__ 은 도메인명(DNS)입니다.

__*80*__ 은 포트 번호입니다.

구글의 ip는 172.217.175.46  입니다.

```Escape character is '^]'.```  ctrl + ]를 입력하면 telnet의 prompt가 뜹니다.

```bash
Escape character is '^]'.
^]

telnet>			// 이 상태에서 quit 명령어를 입력하면 연결이 종료됩니다.
```



### HTTP/1.0 으로 요청 보내기

```bash
$ GET / HTTP/1.0

HTTP/1.0 200 OK
Date: Wed, 25 Aug 2021 04:44:41 GMT
Expires: -1
Cache-Control: private, max-age=0
Content-Type: text/html; charset=ISO-8859-1
P3P: CP="This is not a P3P policy! See g.co/p3phelp for more info."
Server: gws
X-XSS-Protection: 0
X-Frame-Options: SAMEORIGIN
Set-Cookie: 1P_JAR=2021-08-25-04; expires=Fri, 24-Sep-2021 04:44:41 GMT; path=/; domain=.google.com; Secure
Set-Cookie: NID=222=Jlho5Sr822VZEIBRsStwQG6f5ZMQJJnPybP8d-trFdZfrH3NcpDuF7dYzvliiWfMS16otiO4MUEJF1JvS-QIdpn4IaBlxPEpFy2KwlBSNFFQaidrepA0QKQtxFEZaW-SWh7yJq2_WZkJLv0GtISspl-N4uNo_mgB_cAprqXpB-w; expires=Thu, 24-Feb-2022 04:44:41 GMT; path=/; domain=.google.com; HttpOnly
Accept-Ranges: none
Vary: Accept-Encoding

<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ko"><head><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="UQpPZgJVFNDPtJNuyJY4vQ==">(function(){window.google={kEI:'ucolYZmEE5L1hwOWjrygBA',kEXPI:'0,18167,184175,569873,1,530320,56873,954,5104,207,2414,2390,2316,383,246,5,1354,5251,1122515,1197719,564,302679,26305,51224,16114,17444,11240,17572,4859,1361,9291,3020,17588,4020,978,13228,3847,10622,14528,234,4282,2778,919,2372,2709,1593,1279,2212,239,291,149,1103,840,6297,108,4012,2023,2297,14670,2269,1,957,1989,856,7,4774,7580,5096,7539,5374,3409,906,2,941,2614,13142,3,576,6459,149,13975,4,1528,2304,1236,5226,577,4684,2014,4067,2506,7038,4764,2658,4242,2459,654,32,5664,5749,2215,2305,638,1494,5586,3772,7428,2521,3276,2560,4094,20,3118,6,908,3,3541,1,14710,1816,281,912,5994,16726,1344,371,2,3057,6166,4799,1337,594,1532,2377,1590,90,743,1275,1075,461,3042,1576,3,472,6652,623,460,677,774,386,1269,5138,293,2377,2722,4545,3,123,5350,4635,230,356,628,1962,401,9,2,6,4798,1039,1513,104,319,1932,190,2445,1385,2396,1917,555,10,1645,2000,1394,324,49,1216,270,545,2,1,78,948,6,708,49,539,720,2,290,245,257,684,2268,111,2169,159,1090,306,318,27,1112,12,499,393,114,277,158,9,503,880,229,22,540,46,337,79,74,95,52,110,455,1092,9,3,763,461,5590007,99,127,220,83,32,31,135,2,5996586,2800696,882,444,1,2,80,1,1796,1,9,2553,1,748,141,795,563,1,4265,1,1,2,1331,4142,2609,155,17,13,72,139,4,2,20,2,169,13,19,46,5,39,96,548,29,2,2,1,2,1,2,2,7,4,1,2,2,2,2,2,2,353,513,186,1,1,158,3,2,2,2,2,2,4,2,3,3,269,234,2,1,1,7,16,15,9,8,6,10,1,5,1,25,23954381,4041352,338,3,2414,445,2,459,7,172,406,9,2259,984,1534',kBL:'qA29'};google.sn='webhp';google.kHL='ko';})();(function(){
...
```

**start line**, **header**, **body** 로 구성된 소스들을 받을 수 있습니다.

**_start line_** : ```HTTP/1.0 200 OK```

**_header_** : 

```
Date: Wed, 25 Aug 2021 04:44:41 GMT
Expires: -1
Cache-Control: private, max-age=0
Content-Type: text/html; charset=ISO-8859-1
P3P: CP="This is not a P3P policy! See g.co/p3phelp for more info."
Server: gws
X-XSS-Protection: 0
X-Frame-Options: SAMEORIGIN
Set-Cookie: 1P_JAR=2021-08-25-04; expires=Fri, 24-Sep-2021 04:44:41 GMT; path=/; domain=.google.com; Secure
Set-Cookie: NID=222=Jlho5Sr822VZEIBRsStwQG6f5ZMQJJnPybP8d-trFdZfrH3NcpDuF7dYzvliiWfMS16otiO4MUEJF1JvS-QIdpn4IaBlxPEpFy2KwlBSNFFQaidrepA0QKQtxFEZaW-SWh7yJq2_WZkJLv0GtISspl-N4uNo_mgB_cAprqXpB-w; expires=Thu, 24-Feb-2022 04:44:41 GMT; path=/; domain=.google.com; HttpOnly
Accept-Ranges: none
Vary: Accept-Encoding
```

**_response body_** :

```
<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ko"><head><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="UQpPZgJVFNDPtJNuyJY4vQ==">(function(){window.google=
...
```

보시다시피 ``` GET / HTTP/1.0  ``` HTTP/1.0은 별다른 header 정보 없이 요청을 보낼 수 있습니다.

또한 ``` Connection closed by foreign host.```과 같이 요청을 한번 보내고 응답을 받으면 자동으로 위와 같은 문구를 볼 수 있습니다.



### HTTP/1.1 으로 요청 보내기

1.1은 1.0과 2가지의 큰 차이점이 존재합니다.

1. virtual host 기능 지원
2. stay-allive 기능 지원

- 구글에 HTTP/1.1요청을 보내 봅니다.

```
[jmocha@localhost.localdomain ~]# telnet google.com 80
Trying 172.217.175.46...
Connected to google.com.
Escape character is '^]'.
GET / HTTP/1.1
HOST: google.com

HTTP/1.1 301 Moved Permanently
Location: http://www.google.com/
Content-Type: text/html; charset=UTF-8
Date: Wed, 25 Aug 2021 04:55:34 GMT
Expires: Fri, 24 Sep 2021 04:55:34 GMT
Cache-Control: public, max-age=2592000
Server: gws
Content-Length: 219
X-XSS-Protection: 0
X-Frame-Options: SAMEORIGIN

<HTML><HEAD><meta http-equiv="content-type" content="text/html;charset=utf-8">
<TITLE>301 Moved</TITLE></HEAD><BODY>
<H1>301 Moved</H1>
The document has moved
<A HREF="http://www.google.com/">here</A>.
</BODY></HTML>
```

google이 더이상 HTTP/1.1의 해당 도메인을 지원하지 않는 듯 하네요. naver도 마찬가지인 듯 합니다. (확실하진 않으나 개인적인 뇌피셜로는 하나의 머신에 하나의 호스트만 사용(*다른 virtual host가 존재하지 않음*)하나 봅니다.)

따로 host를 적지 않으면 200코드를 정상적으로 보내주네요.

![image-20210825133256011](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP_3_telnet.assets/image-20210825133256011.png)

여기서 보여드리고 싶었던 부분은 HTTP/1.1은 ```GET / HTTP/1.1``` 뿐만 아니라 virtual host로 인하여 ``` HOST: <uri>``` 도 함께 작성해서 요청을 한다는 부분입니다.

- virtual host는 하나의 물리적 머신에 여러개의 서버가 존재할 수 있게 되면서 생겨난 개념입니다.(예전에는 사이트 하나를 더 만들고 싶으면 컴퓨터 한대가 더 필요했다고 합니다)

그리고 위 결과 코드의 마지막 부분을 보시면 HTTP/1.0과 다르게 ```Connection closed by foreign host.``` 이 코드가 출력되지 않습니다.

이 말은 1.1부터 일정시간동안 connection을 연결시켜 놓는 다는 것을 의미합니다.

##### [*HTTP의 connection에 대해 궁금하시다면 여기를 참고 바랍니다.*](https://jjam89.tistory.com/148)



### *Conferatur*

telnet을 활용한 HTTP2와 HTTP3의 연결은 불가능합니다. 대신 Wireshark를 사용한다면 가능합니다.

![image-20210825144315201](https://raw.githubusercontent.com/KrGil/TIL/main/CS/HTTP/HTTP_3_telnet.assets/image-20210825144315201.png)

https://http2.github.io/faq/

