Shell Command

```shell
$ git branch --merged | grep -v -P '(develop|master)' | xargs git branch -D
```





## .bat 파일들 mv로 이동시키기

````shell
 ls | grep -P '(\.bat)' | xargs mv -t  ./batchfiles
````

```shell
echo '아래의 workspace 중 하나를 입력하세요'
echo `ls /d/sblm | grep -P '(workspace)'`
read workspace
echo `ls /d/sblm/$workspace`

antBuild="xargs -n 1 ant -f"

# 순서대로 ant -f build.xml 실행
ls /d/sblm/${workspace}| grep -P '(shared_webapp)' | awk '{print"/d/sblm/'${workspace}'/"$1 "/build.xml"}' | ${antBuild}
ls /d/sblm/${workspace}| grep -P '(rmzzmgr)' | awk '{print"/d/sblm/'${workspace}'/"$1 "/build.xml"}' | ${antBuild}
ls /d/sblm/${workspace}| grep -P '(rmzzmonmgr)' | awk '{print"/d/sblm/'${workspace}'/"$1 "/build.xml"}' | ${antBuild}
ls /d/sblm/${workspace}| grep -P '(rmzzapp)' | awk '{print"/d/sblm/'${workspace}'/"$1 "/build.xml"}' | ${antBuild}
ls /d/sblm/${workspace}| grep -P '(rmzzweb)' | awk '{print"/d/sblm/'${workspace}'/"$1 "/build.xml"}' | ${antBuild}

# *mgr -> *app -> *web 순으로 build.xml 파일 실행
ls /d/sblm/${workspace}| grep -P '(mgr)' | grep -P -v '(rmzz|shared)' | awk '{print"/d/sblm/'${workspace}/'"$1 "/build.xml"}' | ${antBuild}

ls /d/sblm/${workspace}| grep -P '(app)' | grep -P -v '(rmzz|shared)' | awk '{print"/d/sblm/'${workspace}/'"$1 "/build.xml"}' | ${antBuild}

ls /d/sblm/${workspace}| grep -P '(web)' | grep -P -v '(rmzz|shared)' | awk '{print"/d/sblm/'${workspace}/'"$1 "/build.xml"}' | ${antBuild}

```



