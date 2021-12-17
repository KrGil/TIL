# [jBoss] 

> 현재 프로젝트의 개발 서버는 wildfly, 운영 서버는 jBoss를 사용하는 중입니다. 이에 wildfly와 jboss의 차이점에 대해 궁금증이 생겨 검색 및 정리해 보았습니다. 만약 다르거나 잘못된 정보가 기입되어 있다면 언제든지 글을 남겨주시기 바랍니다.

### 개요

apache-tomcat과 같은 자바를 기반으로 하는 미들웨어의 총칭이며 JBoss에는 기본적으로 Tomcat이 내장되어 있고 EJB나 JMS를 사용한 애플리케이션도 가능합니다.

1999년 Marc Fleury에 의해 jBoss라는 이름의 작은 오픈소스 프로젝트로 시작되었습니다.

2006년 4월에 RedHat에 인수되고 jBoss는 RedHat이 제작하는 모든 미들웨어 제품(jBoss datagrid, jBoss Fuse 등)들에 대한 상표가 됩니다. 

### 종류

> JBoss-AS
>
> JBoss-EAP
>
> WildFly

![jboss_eap_intro_1](https://raw.githubusercontent.com/KrGil/TIL/main/CS/documents/jBoss_wildFly.assets/jboss_eap_intro_1.png)

*위의 이미지와 같이 2004년 RedHat에 인수되어 JBoss EAP가 따로 출시되었고 2014년에 JBoss AS 8이 아닌 WildFly 8로 이름이 바뀐것을 알 수 있습니다.*

### JBoss-AS

JBoss.org 라는 인터넷 커뮤니티에서 제공하는 JavaEE 6 표준을 지원하는 오픈소스 Application Server입니다.

Community에서 주로 기능 개발을 목적으로 제공되는 제품입니다. 여타 오픈 소스들이 그렇지만 유지보수를 지원하지 않으므로 사용자 개개인이 코드를 수정을 해야합니다.



### JBoss-EAP

RedHat에서 제공하는 제품으로 JBoss Enterprise Application Platform을 뜻합니다.

상업 서비스 제품으로 사용자가 요청한 버그 수정 또는 보안 등 안정성과 품질 등에 대한 호환성 테스트를 거쳐 출시하는 제품입니다.

그러므로 JBoss-EAP의 경우 JBoss-AS의 안정된 버전으로 패키징 한다고 할 수 있습니다.



### WildFly

JBoss-AS 7버전 이후의 버전이라 생각하시면 됩니다.

2014년 11월 20일 레드헷은 jBoss-EAP를 지칭하게 하기 위해 jBoss-AS 8 부터 WildFly 8 로 이름을 변경하였습니다.(커뮤니티 사이트 역시 jBoss.org -> wildFly.org로 변경되었습니다. 현재 jboss.org는 redhat에서 운영하고 있습니다.)





### References

https://www.slideshare.net/dandreadis/jboss-as-eap-and-java-ee6

https://www.jboss.org/

https://www.wildfly.org/

http://www.opennaru.com/jboss/jboss-eap-origin-and-history/

https://beom3.tistory.com/30

https://ko.wikipedia.org/wiki/%EC%99%80%EC%9D%BC%EB%93%9C%ED%94%8C%EB%9D%BC%EC%9D%B4