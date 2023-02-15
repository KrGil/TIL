# [SpringBoot] SpringBoot에 mariadb와 mybatis 연결시키기

## Note

여러 글들을 살펴 보았지만 하나의 글만을 따라해서 제대로 실행되는것이 없어 따로 기록용으로 글을 작성합니다.

글을 시작하기에 앞서 간략하게 어떤 파일들을 생성해야하고 설정해야하는지 흐름을 적어보겠습니다.

1. build.gradle파일에 dependencies 추가하기.(mybatis, jdbc, mariadb)
2. domain(vo) 생성하기
3. service 파일 생성하기(@Service)
4. controller.java 파일 생성하기(@Controller)
5. application.java 실행파일 -> @MapperScan(value = {"com.tistory.eisen"})
6. application.properties 파일에 mybatis 설정값 넣기(선택에 따라 mybatis-config.xml)
7. mapper.java 생성하기(@Repository, @Mapper)
8. resources/mapper/mapper.xml 파일 생성 및 sql 작성.





### dependencies 추가하기

```
    implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0'
    implementation 'org.springframework.boot:spring-boot-starter-jdbc'
    implementation group: 'org.mariadb.jdbc', name: 'mariadb-java-client' // mariadb
```

### Member 생성(vo)

```
@Data
public class Member {
	String userId;
	String userPass;
	String userName;
	Date joinDate;
	String isAdmin;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
}
```



### Service를 생성합니다.

````
public interface MemberService {

	/*
		전체 회원 조회
	 */
	public List<Member> findAll();

	/*
		회원 조회
		@param user_id
		@return String, illigalstate exception 발생.
	 */
	public Optional<Member> findById(String userId);
}
````

interface와 구현체로 설계하겠습니다.

```
@Service
public class MemberServiceImpl implements MemberService{

	private final MemberMapper memberMapper;

	@Autowired // 한개면 생략 가능
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	/*
		회원 조회
	 */
	@Override
	public Optional<Member> findById(String userId) {
		validateExistMember(userId);
		return memberMapper.selectById(userId);

	}
	public void validateExistMember(String user_id){
		memberMapper.selectById(user_id)
			.ifPresentOrElse(member -> {},
								() -> {throw new IllegalStateException("아이디가 존재하지 않습니다.");});
	}

	/*
		모든 회원 조회
	 */
	@Override
	public List<Member> findAll() {
		return new ArrayList<>(memberMapper.selectAll());
	}
}
```



### Controller를 생성합니다.

```
@Controller
public class LoginController {
   private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

   private final MemberServiceImpl service;
   private Optional<Member> member;

   public LoginController(MemberServiceImpl service, Optional<Member> member) {
      this.service = service;
      this.member = member;
   }

   @RequestMapping("/")
   public String toLoginPage(@RequestParam(required = false, value = "user_id") String user_id, Model model){
      model.addAttribute("user_id", user_id);
      return "loginPage";
   }

   @PostMapping("loginCheck")
   public Map<String, Object> loginCheck(@RequestParam(required = false, value = "user_id") String user_id, Model model){
      Map<String, Object> result = new HashMap<>();
      member = service.findById(user_id);
      result.put("member", member);
      return result;
   }
}
```



### application.properties 추가

#### driver 및 db 연결 정보 설정 추가하기

```
## DataSource
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mariadb://<localhost>:3306/<DatabaseName>?serverTimeZone=UTC&CharacterEncoding=UTF-8
spring.datasource.username=스키마계정
spring.datasource.password=비밀번호
```

<localhost> 에 본인의 db ip 정보를 기입합니다.

<DatabaseName> 에 본인의 database 이름을 기입합니다.

#### mapper 위치 및 간단한 설정 추가

```
# mybatis 매핑 type을 짧게 쓰기 위한 설정
# mapper.xml에서 resultType을 지정할 때 class명으로 간략히 쓸 수 있습니다. 
mybatis.type-aliases-package=com.Eisen.tistory.domain
# mapper.xml 위치 지정 # **은 하위 폴더 레벨에 상관없이 모든 경로를 뜻하며, *는 아무 이름이나 와도 된다는것을 뜻합니다.
# mybatis.mapper-locations=classpath:mapper/userMapper.xml
mybatis.mapper-locations=classpath:mapper/**/*.xml
```

### mybatis path 설정 및 config 설정.

#### 1. application 실행 파일에 @bean으로 등록 후 mybatis-config.xml 사용

#### 2. application.properties 파일에 등록(여기서도 mybatis-config.xml 로 mybatis 설정만 따로 빼줄 수 있습니다.)

---

1. @bean등록 후 사용

    ```
    package com.kaoni.library_manage_system;
    
    import org.apache.ibatis.session.SqlSessionFactory;
    import org.mybatis.spring.SqlSessionFactoryBean;
    import org.mybatis.spring.annotation.MapperScan;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.context.annotation.Bean;
    import org.springframework.core.io.Resource;
    import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
    
    import javax.sql.DataSource;
    
    
    @MapperScan(value = {"com.eisen.tistory.mapper"})
    @SpringBootApplication
    public class testApplication {
    
    	public static void main(String[] args) {
    		SpringApplication.run(LibraryManageSystemApplication.class, args);
    	}
    
    	@Bean
    	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    		sessionFactory.setDataSource(dataSource);
    		//PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    		Resource configLocation = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
    
    		sessionFactory.setConfigLocation(configLocation);
    		//sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
    		return sessionFactory.getObject();
    	}
    }
    ```

    application 실행 파일에 ```SqlSessionFactory```를 ```@Bean```으로 등록후 Resource를 사용하여 mybatis-config.xml 경로를 지정해 줍니다.

    ```@MapperScan``` : 지정한 경로 아래로 ```@Mapper``` 를 검색합니다.

    

2. application.properties에 설정 등록하기

    ```
    # camel case
    mybatis.configuration.map-underscore-to-camel-case=true
    # Mybatis mapper path
    mybatis.mapper-locations=classpath:mapper/userMapper.xml
    # Mybatis alias
    mybatis.type-aliases-package=com.kaoni.library_manage_system.login.domain
    ```

    application 실행 파일에는 @Bean을 등록하지 않으셔도 됩니다.



### Resources에 mapper/userMapper.xml 생성

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.eisen.tistory.login.mapper.MemberMapper">

	<select id="selectById" parameterType="String" resultType="com.eisen.tistory.login.domain.Member">//alias 등록으로 Member 사용 가능.
		SELECT id AS userId
			 , pass AS userPass
			 , name AS userName
			 , join_date AS joinDate
			 , admin AS  isAdmin
		FROM user
		WHERE id = #{userId};
	</select>
</mapper>
```

앞에서 설정한 mapper-locations과 같은 경로에 파일을 생성 합니다.



### MemberMapper 생성

```
@Repository
@Mapper
public interface MemberMapper {
	public Optional<Member> selectById(String userId);

	public List<Member> selectAll();
}
```

userMapper.xml의 namespace에 맞는 경로에 MemberMapper를 생성합니다.

