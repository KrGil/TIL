Shell Command

```shell
$ git branch --merged | grep -v -P '(develop|master)' | xargs git branch -D
```

