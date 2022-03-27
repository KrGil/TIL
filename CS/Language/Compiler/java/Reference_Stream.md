# [LeetCode] Remove Element문제의 Reference에 관하여

> 오랜만에 leetCode easy 단계를 푸는 도중에 stream에 관련한(stream인지 .toArray인지 모르겠군요.) 재밌있는 사실(~~저만 몰랐겠죠..?~~ )을 발견했습니다.
>
> 이에 관해 글을 작성해 보겠습니다. 
>
> [leetcode 문제 링크입니다.](https://leetcode.com/problems/remove-element/solution/)



## 문제

```java
class Solution {
  public void static main(String[args){
    int nums[] = new int[]{3,2,2,3};
    int val = 3;
    removeElement(nums, val);
    ... // nums 검사
		for (int i = 0; i < expectedNums[i].length; i++) {
    assert nums[i] == expectedNums[i];
		}
  }
	// logic 구현
  public int removeElement(int[] nums, int val) {
		...
  }
}
```

위의 코드와 같이 `int[]`인 nums를 메서드 실행 이후에 재검사하는 로직을 작성하는 문제입니다.

처움 제가 푼 로직은 아래와 같습니다.

```java
public int removeElement(int[] nums, int val) {
	nums = Arrays.stream(nums).filter(num -> num != val).toArray();
  return nums.length;
}

```

이 후 Run Code 를 해보니 기존에 있는 nums의 값이 변경되지 않더군요.

그래서 결국 아래의 방법으로 문제를 해결했습니다.(해당 페이지의 Solution 탭에 존재합니다.)

```java
public int removeElement(int[] nums, int val) {
	// nums = Arrays.stream(nums).filter(num -> num != val).toArray();
  // return nums.length;
  int i = 0;
  for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
          nums[i] = nums[j];
          i++;
      }
  }
  return i;
  }
}
```

이 해결방법과 위의 stream을 사용한 방법의 차이점에 대해 궁금증이 들더군요.

그래서 실행 전과 실행 후의 reference를 비교하는 몇가지 test를 진행해 보았습니다.

### Stream을 활용한 방법

#### Code

```java
class Solution {
    public static void main(String[] args) {
        int nums[] = new int[]{3,2,2,3};
        int val = 3;
				// method 호출 전 original nums의 reference 출력
        System.out.println("Nums = " + nums+" Original");
        RemoveElement.removeElement(nums, val);
      	// method 호출 후 original nums의 reference 출력
        System.out.println("Nums = " + nums+" After Original");

    }
    public static int removeElement(int[] nums, int val) {
 		    // method 내의 처리 '전' parameter로 받은 nums의 reference 출력
        System.out.println("nums = " + nums+" InMethod1");
        nums = Arrays.stream(nums).filter(num -> num != val).toArray(); 		    
      	// method 내의 처리 '후' parameter로 받은 nums의 reference 출력
      	// 이 부분의 reference가 다름!
        System.out.println("nums = " + nums+" InMethod2");
        return nums.length;
    }
```

#### Result

![image-20220327182512261](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/java/Reference_Stream.assets/image-20220327182512261.png)

보시는바와 같이 처리된 nums 의 reference만 다른 것을 알 수 있습니다.



###  forLoop 방법(index에 값 직접 입력)

```java
class Solution {
    public static void main(String[] args) {
        int nums[] = new int[]{3,2,2,3};
        int val = 3;
				// method 호출 전 original nums의 reference 출력
        System.out.println("Nums = " + nums+" Original");
        RemoveElement.removeElement(nums, val);
      	// method 호출 후 original nums의 reference 출력
        System.out.println("Nums = " + nums+" After Original");

    }
    public static int removeElement(int[] nums, int val) {
 		    // method 내의 처리 '전' parameter로 받은 nums의 reference 출력
        System.out.println("nums = " + nums+" InMethod1");
        int i = 0;
				for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
      	// method 내의 처리 '후' parameter로 받은 nums의 reference 출력
      	// 이 부분의 reference가 다름!
        System.out.println("nums = " + nums+" InMethod2");
        return nums.length;
    }
```



#### result

![image-20220327182927513](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/java/Reference_Stream.assets/image-20220327182927513.png)

이렇게 `forLoop`을 사용하여 nums 배열의 index에 직접적으로 값을 입력 할 시 해당 reference가 변경되는 것을 알 수 있습니다.



## java8 documentation

java8의 stream.toArray의 doc을 확인 해 보았습니다.

https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#toArray--

![image-20220327183721245](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/java/Reference_Stream.assets/image-20220327183721245.png)

Parameters 부분의 generator에서 a new Array를 생성한다고 나와 있군요.

...?

생각해보니 기존의 배열에 다른 배열을 할당하는 순간 reference가 변경되었던것 같은데....? 라는 의문이 들더군요!

```java
public static void  test(int[] n){
    System.out.println("n = " + n);
    int[]m = {1,2,3};
    n = m.clone();
    System.out.println("n = " + n);
}
```



![image-20220327184159596](/Users/eisen/Documents/Github/TIL/CS/Language/Compiler/java/Reference_Stream.assets/image-20220327184159596.png)

네... 그렇네요ㅎㅎ

java의 reference에 대한 정확한 이해가 부족해서 발생한 문제였습니다 ㅠㅠ

reference가 변하지 않게 값을 수정해 주려면 reference를 가리키고 있는 값을 직접 바꿔야 한다는 것을 망각했었네요.

아직도 배울것들, 기억해야 할 것들이 많이 남아 있네요. 

긴 글 읽느라 고생하셨습니다~ 모두 즐거운 프로그래밍 하시길 바랍니다~