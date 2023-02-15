# [SpringBoot]TestCase 작성하기(jUnit)



### source code

```
package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

/**
 * packageName   : hello.hellospring.repository
 * fileName      : MemoryMemberRepository
 * author        : Eisen
 * date          : 2021-09-23
 * description   :
 * ================================================
 * DATE            AUTHOR               NOTE
 * ------------------------------------------------
 * 2021-09-23       Eisen             최초 생성
 **/

public class MemoryMemberRepository implements MemberRepository{
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				.filter(member -> member.getName().equals(name))
				.findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

	public void clearStore() {
		store.clear();
	}
}
```





### test code

```
package hello.hellospring.Repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName   : hello.hellospring.Repository
 * fileName      : MemoryMemberRepositoryTest
 * author        : Eisen
 * date          : 2021-09-23
 * description   :
 * ================================================
 * DATE            AUTHOR               NOTE
 * ------------------------------------------------
 * 2021-09-23       Eisen             최초 생성
 **/

public class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	public void afterEach(){
		repository.clearStore();
	}

	@Test
	public void save(){
		Member member = new Member();
		member.setName("spring");

		repository.save(member);
		Member result = repository.findById(member.getId()).get();

//		System.out.println("result = " + (result == member));
//		Assertions.assertEquals(member, result);
		assertThat(result).isEqualTo(member);
	}

	@Test
	public void findByName(){
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		Member result = repository.findByName("spring1").get();

		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll(){
		Member member1 = new Member();
		member1.setName("spring");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		List<Member> members = repository.findAll();
		Assertions.assertThat(members.size()).isEqualTo(2);
	}
}
```



### Assertions

junit과 assertj가 존재합니다.

#### junit

```
Assertions.assertEquals(member, result);
```



assertj

```
Assertions.assertThat(result).isEqualTo(member);
```

개인적으로 assertj가 조금 더 좋은 읽기 좋은 듯 합니다.



### test코드를 class단위로 돌릴 시 주의점

test 코드는 순서에 상관없이 실행이 됩니다.

항상 테스트가 끝나면(메서드) 공통적으로 사용한 코드를 비워주는 작업을 해야합니다.

#### source code

```
public void clearStore() {
		store.clear();
}
```

#### test code

```
@AfterEach
public void afterEach(){
		repository.clearStore();
}
```

#### 참고

test를 먼저 만들어 두고 개발하는 것을 TDD방식이라고 부릅니다.