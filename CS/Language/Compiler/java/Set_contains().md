# [java] Set<>의 contains() 파헤치기

> Set<Double> 의 `contains()` 함수를 사용하여 값을 비교하던 도중 기대했던 결과와 다른 결과가 출력되는 것을 확인할 수 있었습니다. 이에 왜 이렇게 다른 결과값이 나왔는지 살펴보았고 그에 대한 것들을 정리해 볼까 합니다.

## 문제

### Set의 contains()

```java
double a = 0.0;
Set<Double> c = new HashSet<Double>();
c.add(a);
System.out.println(c.contains(0d));
System.out.println(a == -0d);

for (Double aDouble : c) {
	System.out.println(aDouble == -0d);
}
```

아래 이미지와 같이 위의 코드를 실행시켜 보았습니다.

저는 모든 결과가 `true`로 반환될 것이라 기대했었지만 아래와 같이 `System.out.println(c.contains(0d));` 부분의 결과값이 `false`인 것을 확인할 수 있습니다.

![image-20230109151127833](https://raw.githubusercontent.com/KrGil/TIL/bfa6fe5538f8110eb606972d5b73a7e05634529a/CS/Language/Compiler/java/java%EC%8B%A4%EC%88%98%ED%91%9C%ED%98%84.assets/image-20230109151127833.png)

그 이유가 무엇일까 싶어 `Set`의 `contains()` 내부를 확인해 보았습니다.

```java
    /**
     * Implements Map.get and related methods.
     *
     * @param key the key
     * @return the node, or null if none
     */
    final Node<K,V> getNode(Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n, hash; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & (hash = hash(key))]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```

몇 번 타고 들어가면 위와 같은 로직이 구현되어 있는 것을 확인할 수 있습니다. 한 줄 씩 상세히 해석하긴 어렵지만 `parameter`로 넘어오는 `key` 값의 `value` 뿐만 아니라 `hash`  값도 함께 비교하는 것을 확인할 수 있습니다.

`System.out.println(a == -0d);` 부분으로 `value` 값은 동일하다는 것을 확인할 수 있습니다.

그렇다면 `0.0`과 `-0.0`의 hash 값이 다르다는 뜻인데 아래의 코드로 확인을 해 보았습니다.

```java
System.out.println(new Double(-0d).hashCode());
System.out.println(new Double(0d).hashCode());
```

![image-20230109152712824](https://raw.githubusercontent.com/KrGil/TIL/bfa6fe5538f8110eb606972d5b73a7e05634529a/CS/Language/Compiler/java/java%EC%8B%A4%EC%88%98%ED%91%9C%ED%98%84.assets/image-20230109152712824.png)

이렇게 해쉬값이 다른 것을 확인할 수 있습니다.

그렇다면 `Double`은 어떻게 hash값을 저장하길래 0d와 -0d의 값이 다른 것일까요?

## 원인

### Double의 hashCode()

![image-20230109153206227](https://raw.githubusercontent.com/KrGil/TIL/bfa6fe5538f8110eb606972d5b73a7e05634529a/CS/Language/Compiler/java/java%EC%8B%A4%EC%88%98%ED%91%9C%ED%98%84.assets/image-20230109153206227.png)

위의 이미지와 같이 `doubleToLongBits()` 함수를 사용해서 저장하는 것을 확인할 수 있습니다.

![image-20230109153417677](https://raw.githubusercontent.com/KrGil/TIL/bfa6fe5538f8110eb606972d5b73a7e05634529a/CS/Language/Compiler/java/java%EC%8B%A4%EC%88%98%ED%91%9C%ED%98%84.assets/image-20230109153417677.png)

다시 타고 들어가면 위와 같이 `IEEE 754` 방식을 사용한다는 것을 알 수 있습니다.

이 `IEEE 754` 방식은 컴퓨터가 실수를 표현하는 방식 중 `부동 소수점` 에 속합니다.



![image-20230109153551360](https://raw.githubusercontent.com/KrGil/TIL/bfa6fe5538f8110eb606972d5b73a7e05634529a/CS/Language/Compiler/java/java%EC%8B%A4%EC%88%98%ED%91%9C%ED%98%84.assets/image-20230109153551360.png)

*출처: http://www.tcpschool.com/java/java_datatype_floatingPointNumber*

위의 이미지를 보면 알 수 있듯 첫번째 1비트는 부호를 저장하는 것을 알 수 있습니다.

따라서 `Double`의 `0d`와 `-0d`의 `hash`가 다르게 저장되고, `Set`의 `contains()`에서 확인할 때 `value` 값 뿐만 아니라 `hash` 값을 함께 비교하기 때문에 `System.out.println(c.contains(0d));`의 결과가 `false`가 되었던 것입니다.



### 결론

1. java에서 `Double의 hashCode()`는 `IEEE 부동 소수점 방식`을 사용합니다.
2. `IEEE 부동 소수점 방식` 의 처음 1bit는 부호를 저장합니다.
3. `contains()`는 `value`와 `hash`를 함께 비교합니다.
4.  위의 이유로 0d와 -0d의 hash값은 다릅니다.



긴 글 읽어주셔서 감사합니다. 모두 즐거운 코딩 되시길 바랍니다



### References

http://www.tcpschool.com/java/java_datatype_floatingPointNumber