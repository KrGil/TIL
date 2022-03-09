# [python] pip install 했음에도 import 오류 나는 경우

> pip install requests 로 모듈을 설치했는데도 계속해서 import 오류를 내뱉더군요.
>
> 문제 부분만 알고 있으면 어렵지 않은 부분이었는데 오래걸렸네요 ㅠㅠ
>
> 혹여나 install 했는데도 import 오류가 생긴다면 위의 방법을 한번 시도해 보시길 바랍니다.





아래 두 명령어로 pip가 어디로 잡혀있는지 확인

```
which pip
```



```
which pip3
```



둘 모두 brew로 잡혀있음.

필자는 brew로  python을 설치했었음.

Homebrew를 통해 python을 설치하면서 자동으로 pip의 경로가 `/opt/homebrew/bin/pip` 경로를 잡아주게됨.(python 설치시 함께 설치되는것으로 알고 있음)

pyenv에 따른 pip 설치를 하려면 .pyenv 내부에 있는 pip로 경로를 잡아주어야함.



.pyenv로 잡아주자.

echo "alias pip=/Users/eisen/.pyenv/versions/3.9.4/bin/pip" >> ~/.zshrc



성공...

![image-20220309004411391](/Users/eisen/Documents/Github/TIL/CS/Language/Interpreter/python/pip_path_error.assets/image-20220309004411391.png)





`pip search` command에 대하여







원인

```
export PYENV_ROOT="$HOME/.pyenv/shims"
export PATH="$PYENV_ROOT:$PATH"
export PIPENV_PYTHON="$PYENV_ROOT/python"
```

`~/.zshrc` 에 해당 명령어를 집어넣지 않아서 발생.

경로 설정을 해주지 않고 설치하게 된다면 `pyenv which pip` 명령어 시 brew의 pip를 참조.

/Users/eisen/.pyenv/shims/versions/common_3.9.4/bin/pip

![image-20220309182109451](/Users/eisen/Documents/Github/TIL/CS/Language/Interpreter/python/pip_path_error.assets/image-20220309182109451.png)

경로 추가 후 

![image-20220309182134445](/Users/eisen/Documents/Github/TIL/CS/Language/Interpreter/python/pip_path_error.assets/image-20220309182134445.png)

재설치.





https://status.python.org/incidents/grk0k7sz6zkp