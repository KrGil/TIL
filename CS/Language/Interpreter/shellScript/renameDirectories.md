# [bash] bash script를 활용하여 directory 이름 변경하기

> 문득 정신차리고 보니 디렉토리명을 잘못 짓고 있었더라구요. 그래서 변경을 해볼까 해서 한개 두개 바꾸다 보니 제가 뭐하고 있나 싶더군요. 그래서 자주 사용하는 bash로 변경할 수 있는 방법이 없을까 검색해 보았습니다. 파일명 변경은 많은데 디렉토리명 변경은 잘 없더군요ㅠ. 디렉토리 명 변경을 실행해보면서 한번 살펴보도록 하겠습니다.

# shell script

> command에서 한줄로 실행할 수 없을까 하여 검색해 보았지만 여러 디렉토리를 한번에 변경 시키는 커맨드는 찾기 힘들더군요. 그래서 shell script를 작성하여 실행해 보았습니다.

- '2023-01-01' 인 디렉토리명을 '20230101' 로 변경하고 싶은 경우입니다.

  디렉토리가 하나일 경우 단순히 `mv 2023-01-01 20230101`  커맨드로 변경해 주면 되지만 디렉토리 명이 여러개일 경우 곤란한 상황을 겪게 됩니다. 

## script

```bash
#!/bin/bash
# Takes directory entries specified and renames them using the pattern provided.

for directory in * */*
do
    if [ -d "$directory" ]
    then
      # directory 출력
      echo $directory
      # 2023-01-01 -> '-'를 ''로 replace -> 20230101 로 변경
      mv "${directory}" ${directory//[-]/} || echo 'Could not rename '"$directory"''
    fi
done
```

### 파일 생성

```bash
$ echo '#!/bin/bash
# Takes directory entries specified and renames them using the pattern provided.

for directory in * */*
do
    if [ -d "$directory" ]
    then
      # directory 출력
      echo $directory
      # 2023-01-01 -> '-'를 ''로 replace -> 20230101 로 변경
      mv "${directory}" ${directory//[-]/} || echo 'Could not rename '"$directory"''
    fi
done' > renameDirectories.sh
```

*`$`를 제외하고 copy 하시면 됩니다.*

echo 커맨드를 활용하여 ` renameDirectories.sh` 파일을 생성합니다.

 ![image-20230104165335466](https://raw.githubusercontent.com/KrGil/TIL/ad9ec160f7076b9a87b78b4ebb87f293e29d044e/CS/Language/Interpreter/shellScript/renameDirectories.assets/image-20230104165335466.png)



### sh 실행

```bash
sh renameDirectories.sh
```

`renameDirectories.sh` 파일을 실행시켜 디렉토리 명들을 한번에 변경시켜 보겠습니다.

![image-20230104165536858](https://raw.githubusercontent.com/KrGil/TIL/ad9ec160f7076b9a87b78b4ebb87f293e29d044e/CS/Language/Interpreter/shellScript/renameDirectories.assets/image-20230104165536858.png)

`directory` 들이 출력되고 test123 디렉토리 내부에 존재하는 파일까지 변경되는 것을 확인할 수 있습니다.

![image-20230104165549309](https://raw.githubusercontent.com/KrGil/TIL/ad9ec160f7076b9a87b78b4ebb87f293e29d044e/CS/Language/Interpreter/shellScript/renameDirectories.assets/image-20230104165549309.png)

`bash script`에 익숙해진다면 원하는 만큼 시간을 단축 시킬 수 있을 듯 합니다. 

### 번외

파일 내용 중 특정한 문자열을 변경시킬 목적이라면 `sed -i 's/<from>/<to>'` 를 활용하여 일괄적으로 변경시킬 수 있습니다. 

감사합니다.



### Reference

https://stackoverflow.com/questions/35252268/sed-comand-to-rename-folder-name-parts-contained-between

https://leehc257.tistory.com/33