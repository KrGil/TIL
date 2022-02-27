# 퀵 정렬(Quick Sort)

# 퀵 정렬(Quick Sort)

> 특정 원소를 기준으로 주어진 배열을 두 부분배열로 분할하고, 각 부분배열에 대해서 퀵 정렬을 순환적으로 적용하는 방식

- Pivot

  준어진 배열을 두 부분배열로 분할할 때 기준이 되는 특정 원소

  보통 주어진 배열의 첫 번째 원소로 지정.

- 피벗이 제자리를 잡도록 하여 정렬하는 방식.

![image-20220226185512755](/Users/eisen/Documents/Github/TIL/CS/Algorithm/Quick_Sort.assets/image-20220226185512755.png)

## 퀵 정렬의 전체적인 수행 과정

![image-20220226190043847](/Users/eisen/Documents/Github/TIL/CS/Algorithm/Quick_Sort.assets/image-20220226190043847.png)





## 수행 시간

최선 => O(nlogn)

최악 => O(n2)

피벗 선택의 임의성만 보장되면 평균 성능을 보일 가능성이 매우 높다.

​	배열에서 임의의 값을 선택한 후, 배열의 처음 원소와 서로 교호나한 후 정렬 수행

