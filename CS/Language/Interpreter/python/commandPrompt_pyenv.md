# Command prompt에 pyenv 띄우기



![image-20220309183914081](/Users/eisen/Documents/Github/TIL/CS/Language/Interpreter/python/commandPrompt_pyenv.assets/image-20220309183914081.png)

https://gist.github.com/loganasherjones/bd9b7614f80b96cf700fd60e9e256f41#file-agnoster-pyenv

받아도 되고 아래 이미지처럼 직접 코드를 추가해 주어도 됩니다.

경로

```
vi /Users/eisen/.oh-my-zsh/themes/agnoster.zsh-theme
```



```
prompt_pyenv() {
  if [[ -n $PYENV_SHELL ]]; then
    local version
    version=${(@)$(pyenv version)[1]}
    if [[ $version != system ]]; then
      prompt_segment green black "$version"
    fi
  fi
}
...
...
## Main prompt
build_prompt() {
  RETVAL=$?
  prompt_status
  prompt_virtualenv
  prompt_pyenv						// 이 부분
  ...
}
```



![image-20220309184011121](/Users/eisen/Documents/Github/TIL/CS/Language/Interpreter/python/commandPrompt_pyenv.assets/image-20220309184011121.png)



### References

