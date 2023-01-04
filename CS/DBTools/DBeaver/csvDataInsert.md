# [DBeaver] 특정 테이블에 csv 파일로 데이터 insert하기

> 작업을 하다보니 excel로 되어 있는 파일의 데이터들을 특정 table에 insert 해야하는 상황이 왔습니다. 저는 현재 DBeaver를 사용하고 있어 확인해 보았더니 .csv 파일의 데이터는 insert 할 수 있더군요. 그래서 기존 excel 파일을 .csv 파일로 내보내어 특정 테이블에 데이터들을 insert 시켜 주었습니다. 어렵지 않으나 이 기능을 모른다면 일일이 값을 insert 해 줘야 하니 간단하게 작성해 보겠습니다.

# Insert 실행시키기

![image-20230104113029638](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104113029638.png)

- 값을 넣고자 하는 table을 찾아 `우클릭` -> `데이터 가져오기`를 클릭합니다.

![image-20230104113050963](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104113050963.png)

- 위의 이미지와 같은 팝업창이 뜨면 csv를 선택합니다.

![image-20230104113144552](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104113144552.png)

- 불러올 파일의 경로를 선택 하면 호출 시 import되는 setting들을 확인할 수 있습니다.



![image-20230104113349457](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104113349457.png)

- csv 파일을 불러왔다면 위의 이미지와 같이 Mapping 될 column들이 존재하는지 확인해 줍니다.



![image-20230104113404018](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104113404018.png)



![image-20230104113459852](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104113459852.png)

- 진행 버튼을 누르게 되면 .csv 파일에 작성된 값들이 table에 해당하는 column들에 맞춰 insert 되는 것을 확인할 수 있습니다.



## 번외

### [DBeaver] select 결과값을 insert 문으로 변환하기

- column이 5개 이하면 상관 없지만 10개, 20개일 경우 insert 문을 일일이 작성하기 상당히 힘이 듭니다. 
- select 문으로 가져온 결과값을 insert 문으로  변환시키는 방법을 간략하게 작성해 보겠습니다.

![image-20230104131908659](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104131908659.png)

- 위의 이미지와 같이 select 결과 값을 드래그 후 `우클릭` -> `데이터 추출`을 클릭합니다.

![image-20230104132222941](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104132222941.png)



![image-20230104132313945](https://raw.githubusercontent.com/KrGil/TIL/fdf6debbbe0033577a6fb9191640d0602adf719d/CS/DBTools/DBeaver/csvDataInsert.assets/image-20230104132313945.png)

저장할 경로를 지정한 후 선택하시면 select로 조회된 값들로 insert문이 작성된 것을 확인할 수 있습니다.

감사합니다.

### References

https://s-yun.tistory.com/entry/csv-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%A5%BC-%EC%A7%81%EC%A0%91-%EB%94%94%EB%B9%84%EC%97%90-insert-DBeaver