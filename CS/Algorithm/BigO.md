# Big O

## Linear Algorithm

>  O(N)

![image-20220203215535981](/Users/eisen/Documents/Github/TIL/CS/Algorithm/BigO.assets/image-20220203215535981.png)

## Constant time(상수 시간)

> O(1)

```java
public void print_first(arr){
	System.out.println(arr[0])
}
```

It doesn't matter how big the input is this function will tate the same amout of steps to finish.

![image-20220203215502607](/Users/eisen/Documents/Github/TIL/CS/Algorithm/BigO.assets/image-20220203215502607.png)



## Quadratic Time (제곱근)

> O(n^2)

```java
public void print_twice(arr){
	for(int n: arr){
		for(int x: arr){
			print(x, n);
		}
	}
}
```

![image-20220203220510692](/Users/eisen/Documents/Github/TIL/CS/Algorithm/BigO.assets/image-20220203220510692.png)

## Logarithmic Time (log)

> O(log n)

![image-20220203220903188](/Users/eisen/Documents/Github/TIL/CS/Algorithm/BigO.assets/image-20220203220903188.png)

ex) binary search

Logarithm is the opposite of exponents.

### Exponents (지수)

> 2^n = 32
>
> what is 'n' ?

2 * 2 * 2 * 2 * 2 = 32

n = 5

### Logarithm

> n = log2(32)
>
> what is 'n' ?

32 / 2 = 16

16 / 2 = 8

8 / 2 = 4

4 / 2 = 2

2 / 2 = 1

So n = 5



### References

https://www.youtube.com/watch?v=BEVnxbxBqi8

https://medium.com/swlh/time-complexity-javascript-c572e3cbd269