# Git 다른 email 등록하기

### Before

오늘 git contribution을 확인해 보니 이제껏 commit한 내역이 보여지지 않았습니다.

이유를 알고 보니 원래는 개인이 사용하는 email계정으로 항상 commit을 했었는데 몇달동안은 회사에서 사용하는 이메일 계정으로 commit이 이루어져 있어서 그런 듯 하더군요. ssh에 등록이 따로 되어있지 않아서 외부계정으로 인식한 듯 합니다.

이를 해결하는 방법에 대해 간략하게 설명하도록 하겠습니다.

![image-20211005095206889](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git/Git_email.assets/image-20211005095206889.png)



### 내 email 확인하기

``` git log``` 명령어를 사용하여 Author의 email을 확인해봅니다.

저처럼 두개인 경우 각 email들을 github에 등록하고 이 email로 commit한 내역이 본인이 맞다는 것을 github에 알려 주어야 합니다.

![image-20211005095622721](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git//Git_email.assets/image-20211005095622721.png)





### Github에 email 등록되어 있는지 확인하기

settings -> Emails 에 들어가셔서 본인이 등록되어 있는 email 주소를 확인합니다. 

만약 없다면 ```Add``` 버튼을 눌러 등록하신 후 이메일 인증을 하시면 됩니다.

![image-20211005095822535](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git//Git_email.assets/image-20211005095822535.png)



사실 여기까지만 등록해도 push 등을 해도 본인이라는 것을 잘 인식합니다만... ssh key 역시 등록해 줘 보겠습니다.

### SSH 등록하기

settings -> SSH and GPG keys르 들어가 본인의 ssh(email)가 등록되어 있는지 확인합니다.

![image-20211005103043848](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git//Git_email.assets/image-20211005103043848.png)

등록되어있지 않다면 아래 명령어를 통해 본인이 현재 사용하는 email을 넣고 ssh keygen을 사용하여 rsa타입의 sshkey를 생상하면 됩니다.

```ssh-keygen -t rsa -C "<EMAIL@putYourEmailHere.com>"```

```
$ ssh-keygen -t rsa -C "eisen@isAwsome.com"
Generating public/private rsa key pair.
Enter file in which to save the key (/c/Users/Eisen/.ssh/id_rsa):
/c/Users/Eisen/.ssh/id_rsa already exists.
Overwrite (y/n)? y
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /c/Users/Eisen/.ssh/id_rsa
Your public key has been saved in /c/Users/Eisen/.ssh/id_rsa.pub
The key fingerprint is:
...
...

$ cat id_rsa.pub
```

그 후 ```cat id_rsa.pub``` 명령으로 ssh 키들을 복사한 후 github 페이지에서 ```New SSH key```버튼을 클릭해 붙여넣으시면 됩니다.

![image-20211005103849715](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git//Git_email.assets/image-20211005103849715.png)

![image-20211005103618894](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Git//Git_email.assets/image-20211005103618894.png)

그러면 git config에 등록되어있는 다른 email을 github에서 인식하여 같은 계정이 등록했다는 것을 알려주었고 해당 email로 ssh키까지 등록해 보았습니다.(github의 ssh 쓰임새에 대해선 추후 다시 공부해 보아야겠습니다. 혹여 아시는분들은 댓글 달아주시면 감사합니다.)

