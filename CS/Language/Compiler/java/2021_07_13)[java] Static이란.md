# [java] Static이란?

> static이란 고정의, 정적의

# java의 Static

- 고정의, 정적의
- Statically Type Variable(정적 타입 변수)
- 예약어

> java의 Statically Type Variable(정적 타입 변수)

- 변수를 선언할 때 먼저 type을 정해준다.

```jsx
int x = 1;

// 변수 앞에 type(int)를 먼저 선언한다.
```

- javascript는 Dynamically Type Variable(동적 타입 변수)를 가진다.

var y = 1;

> 예약어

- 변수 앞에 static을 붙여줌으로 메모리에 먼저 적재 시킨다.

```jsx
public class TestClass{
	static public int a = 1;
	public int nonStatic = 2;
	static public void testMethod(){
  }
}
```

- class 앞에 static을 붙여줄 시 쓰려고 하는 .java파일에서 import static...을 하면

```jsx
// TestClass st = new TestClass();
TestClass.a;
TestClass.testMethod(); 
// TestClass.nonStatic; 은 사용할 수 없다.(static을 붙여주지 않음)
// 이렇게 사용할 수 있다.
```

> static을 예약어로 사용할 시

- 인스턴스 생성 없이 사용 가능.(new TestClass();)
- 불러온 method나 변수의 경우 새롭게 다른 객체가 생성되는것이 아니라 공통적으로 사용된다.

```jsx
public class TestClass{
	static public int a = 1;
	public int nonStatic = 2;
	static public void testMethod(){
		// noneStatic = 3;
		int insideSataticVar = 3;
  }
}
```

- 위와 같이 static Method 외부에서 인스턴스화된 변수를 static 내부에서 사용할 수 없다.
- 메모리 적재가 인스턴스화보다 먼저 실행되기 때문.