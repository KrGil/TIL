# [Test] Mock vs Stub

https://minslovey.tistory.com/97

https://martinfowler.com/articles/mocksArentStubs.html

https://charming-kyu.tistory.com/41

https://martinfowler.com/bliki/TestDouble.html



- 상태검증은 메서드가 수행된 후 SUT나 협력객체의 `상태`를 살펴봄으로써 올바로 동작했는지를 판단하게 된다

  ```
  SomeClass someClass = new SomeClass();
  someClass.someMethod();
  
  assertThat(someMethod.someStatus()).isEqualTo(true);
  ```

  > someStatus값이 true인지 `상태` 검사

- 행위검증은 상태검증과는 다르게 SUT가 협력객체의 특정 메서드가 호출되었지 등의 `행위`를 검사함으로써 올바로 동작했는지 판단하게 된다

  ```
  SomeClass someClass = new SomeClass();
  
  verify(someClass).someMethod();
  ```

  > someClass의 someMethod가 실행되었는지 `행위` 검사



- mock만 행위검증. verify()