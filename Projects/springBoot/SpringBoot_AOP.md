# SpringBoot에 AOP사용, Controller에서 특정 조건 만족 시 다른 view로 이동시키기

### Before

SpringBoot에서 Log를 찍기 위해 굳이 AOP를 사용할 필요는 없습니다.  (```application.properties``` 에 ```logging.level.root=info``` 를 작성하면 됩니다.)

AOP를 활용하여 controller의 특정 method를 제외한 모든 method를 실행 시켰을 때 특정 조건에 만족하게 되면 return되는 view를 index.html로 바꾸고 싶어 한번 작성해 보았습니다.(저처럼 return값을 변경하시길 원하시면 interceptor를 활용하는 방법을 추천합니다.)

### 목차

1. Aspects.java 생성
2. Custom Annotation 작성(원할시)
3. Aspects 작성

### Custom Annotation SkipChecking 생성

```
package com.tistory.eisen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * packageName   : com.tistory.eisen.annotation
 * fileName      : NoChecking
 * author        : Eisen
 * date          : 2021-10-05
 * description   :
 * ================================================
 * DATE            AUTHOR               NOTE
 * ------------------------------------------------
 * 2021-10-05       Eisen             최초 생성
 **/

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SkipChecking {

}
```

- AOP가 실행되고싶지 않은 메서드에 붙여주기 위한 용도입니다.
- 내부에는 아무런 내용도 존재하지 않고 그저 식별 용도로 사용합니다.



### Aspects

```
package com.tistory.eisen.config;

import com.tistory.eisen.login.controller.LoginUrlController;
import com.tistory.eisen.domain.Member;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class Aspects {
   private static final Logger logger = LoggerFactory.getLogger(Aspect.class);

   @Around("execution(* com.tistory.eisen.*.controller.*.*(..)) && !@annotation(com.tistory.eisen.annotation.SkipChecking)" )
   public Object idCheck(ProceedingJoinPoint joinPoint) throws Throwable {
      logger.info("### {}: before", joinPoint.getSignature().getName());
		
      Optional<Member> member =  LoginUrlController.member;
      if(!member.isPresent()){
         logger.info("member is not present. Go to login page");
         LoginUrlController.toLoginPage();
         return "redirect:/";
      }

      logger.info("### {}: after\n", joinPoint.getSignature().getName());
      Object result = joinPoint.proceed();
      return result;
   }
}
```

- ```@Aspect``` 추가 후 반드시 ```@Component```를 추가해야합니다.(그래야 ```Bean```에 등록됩니다.)
- ```@Around```를 사용한다면 반드시 첫번째 parameter로 ```ProceedingJoinPoint```가 와야합니다.
- 저처럼 특정 조건 만족 시 해당 method의 결과를 임의로 바꿔주시길 원한다면 ```ProceedingJoinPoint```와 ```Object```를 return합니다.
- ```ProceedingJoinPoint.proceed()```로 해당하는 메서드를 실행시킬 수 있습니다. .args로 해당 매서드의 parameter들 역시 가지고 올수 있습니다.

- ```@Around``` 뒤의 ```pointcut 표현식```으로 원하는 경로를 지정하여 해당하는 모든 메서드들이 실행 될 때 실행되도록 만들 수 있습니다. 또한 특정 어노테이션이 붙은 method 혹은 붙지 않은 method를 실행시킬 수 있습니다.
- 현재 Controller에 존재하는 Member에 값이 들어있지 않다면 index페이지(```"/"```)로 넘어가도록 구현하였습니다.



### Controller

```
package com.tistory.eisen.login.controller;

import com.tistory.eisen.annotation.SkipChecking;
import com.tistory.eisen.constant.HtmlEnum;
import com.tistory.eisen.domain.Member;
import com.tistory.eisen.login.service.MemberServiceImpl;
import com.tistory.eisen.utils.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * packageName   : com.tistory.eisen.login
 * fileName      : loginController
 * author        : Eisen
 * date          : 2021-09-27
 * description   :
 * ================================================
 * DATE            AUTHOR               NOTE
 * ------------------------------------------------
 * 2021-09-27       Eisen             최초 생성
 **/
@Controller
public class LoginUrlController {
	private static final Logger logger = LoggerFactory.getLogger(LoginUrlController.class);

	private final MemberServiceImpl service;
	public static Optional<Member> member;

	public LoginUrlController(MemberServiceImpl service, Optional<Member> member) {
		this.service = service;
		this.member = member;
	}

	private StringBuffer html;

	@SkipChecking
	@RequestMapping("/")
	public static String toLoginPage() {
		return "loginPage";
	}

	@GetMapping("loginCheck")
	public String loginCheck(Model model) {
		member.ifPresent(
			member1 -> {
				model.addAttribute("member", member);
			});
		return HtmlEnum.MAINPAGE.getHtml();
	}

	@SkipChecking		// custom annotation으로 aop 처리에 제외.
	@PostMapping("loginCheck")
	public String loginCheck(@RequestParam Optional<String> user_id, Model model, HttpServletResponse resp) {
		member = service.findById(user_id.get());
		
		if(member.isPresent()){
			saveMemberToCookie(model, resp);
		}else {
			model.addAttribute("fail", 1);
			return "/";
		}
		return "redirect:/loginCheck";
	}

	@GetMapping("memberManagement")
	public String memberManagement(Model model){
		return "memberManagePage";
	}

}

```

- ```@SkipChecking``` 을 활용하여 특정 메서드에만 적용시켜 보았습니다.
- 추후 member객체의 값을 비교하는것이 아니라 쿠키와 세션을 이용하여 클라이언트에서 페이지 이동 요청 시 cookie 값과 서버의 session 값을 비교하게끔 바꿀 예정입니다.

간단하게 AOP를 활용하여 페이지 이동 마다(Controller의 메서드 호출 시 마다) 특정한 로직을 돌려보는 코드를 짜 보았습니다.

궁금한 사항이나 혹 잘못된 부분이 있다면 댓글 달아주시길 바랍니다.

### Reference

https://aljjabaegi.tistory.com/278