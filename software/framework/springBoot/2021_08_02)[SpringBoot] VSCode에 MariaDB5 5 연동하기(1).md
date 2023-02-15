# [SpringBoot] VSCode에 MariaDB5.5 연동하기(1)

> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(1)](https://jjam89.tistory.com/121)
>
> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(2)](https://jjam89.tistory.com/123)
>
> [[SpringBoot] VSCode에 MariaDB5.5 연동하기(3)](https://jjam89.tistory.com/124)



> pom.xml

```jsx
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.3</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>thymeleaf</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>thymeleaf</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>11</java.version>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-slf4j-impl</artifactId>
			<version>2.10.0</version>
		</dependency>

		<!--mariaDB--> 
		<dependency>
			<groupId>org.mariadb.jdbc</groupId>
			<artifactId>mariadb-java-client</artifactId>
		</dependency>
		<dependency> 
			<groupId>org.mybatis.spring.boot</groupId> 
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.2.0</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

> TestMapper.java

```jsx
package com.example.thymeleaf.test.mapper;

import java.util.List;

import com.example.thymeleaf.test.vo.TestVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    List<TestVo> selectTest();
}
```

> TestService.java

```jsx
package com.example.thymeleaf.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.thymeleaf.test.mapper.TestMapper;
import com.example.thymeleaf.test.vo.TestVo;

@Service
public class TestService {
    
    @Autowired
    public TestMapper mapper;
    
    public List<TestVo> selectTest() {
        return mapper.selectTest();
    }
}
```

> TestVo.java

```jsx
package com.example.thymeleaf.test.vo;

public class TestVo {
    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
```

> main/resources/mybatis/testMapper/testMapper.xml

```jsx
<?xml version="1.0" encoding="UTF-8"?> 
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="com.example.thymeleaf.test.mapper"> 
    <select id="selectTest" resultType="TestVo">
      select * from user
    </select> 
 </mapper>
```

> application.properties

- resultType에 alias를 사용하기 위해  typeAliases를 설정.

```jsx
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://10.0.100.58:3306/testBoard?characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=eisen 
spring.datasource.password=kaoni123!@#

# mybatis 매핑 type을 짧게 쓰기 위한 설정 
# mapper.xml에서 resultType을 지정할 때 com.god.bo.test.vo.TestVo 대신 TestVo로 간략히 할 수 있다. 
mybatis.type-aliases-package=com.example.thymeleaf.test.vo

# mapper.xml 위치 지정 # **은 하위 폴더 레벨에 상관없이 모든 경로를 뜻하며, *는 아무 이름이나 와도 된다는것을 뜻합니다. 
mybatis.mapper-locations=mybatis/**/*.xml
```

> TestController.java

```jsx
package com.example.thymeleaf.controller;

import java.util.List;

import com.example.thymeleaf.test.service.*;
import com.example.thymeleaf.test.vo.TestVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController{

     @Autowired 
     TestService testService; 
     
     @RequestMapping(value = "/test")
     public ModelAndView test() throws Exception{ 

          ModelAndView mav = new ModelAndView("testPage"); 
          
          List<TestVo> testList = testService.selectTest(); 
          mav.addObject("list", testList); 
          return mav; 
     }
}
```

# Error

---

1. 3306 port 개방

   ![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-02/Untitled.png?raw=true)
    vsCode에서도  동일한 오류 발생.

    > Solution

    [https://myjamong.tistory.com/7](https://myjamong.tistory.com/7)

    - 모든 포트 개방하기

    ```jsx
    sudo iptables -F
    ```

    ** 필자는 먹히지 않았었음.  그래서 아래의 코드를 작성함.

    ```jsx
    $ sudo firewall-cmd --zone=public --add-port=3306/tcp --permanent
    $ sudo firewall-cmd --reload
    $ sudo firewall-cmd --list-ports
    ```

    - 오픈중인 port 목록이 나옴. 아래 이미지처럼 나오면 해결.

    ![alt text](https://raw.githubusercontent.com/KrGil/TIL/main/software/framework/springBoot/2021-08-02/Untitled1.png?raw=true)
    - 이미지는 없지만 다시 연결하니 연결이 잘 됨.

2. Current charset is UTF-8. If password has been set using other charset, consider using option 'passwordCharacterEncoding'] with root cause
- 이제 연결해서 [localhost:80/test](http://localhost:80/test) 에 연동된 데이터가 뜨나 싶었는데 해당 오류가  발생.
- 내일 해당 문제에 대해 고찰해 보고 해결하려고 함.

# References

---

[https://myjamong.tistory.com/7](https://myjamong.tistory.com/7)

[https://goddaehee.tistory.com/205](https://goddaehee.tistory.com/205)