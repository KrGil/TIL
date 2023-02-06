# [BuildTool] Ant vs Maven vs Gradle 비교

> 지금 관리하는 프로젝트의 build가 Ant를 사용하고 있습니다. Ant를 처음 사용해 보아서 저에게는 모든게 낯설더군요. 그래서 Ant와 Maven, gradle의 기본적인 차이점부터 살펴보려고 합니다. 
>
> 그리고 현재 화자가 되고 있는 ChatGPT를 활용하여 해당 질문들을 물어보았습니다. 답변들과 제가 찾아본 자료들을 조합해서 작성해 보았습니다. chatGPT에게 처음으로 이런 주제에 대해 물어보았는데 앞으로 chatGPT를 훨씬 많이 활용해야할 듯 합니다.

# Ant vs Maven vs Gradle 

## chatGPT

### build tool

chatGPT에게 Ant, Maven, gradle의 차이점에 대해서 설명해 달라고 물었습니다.

> Q: tell me what are diffrences with ANT, mavne, gradle.
>
> A: ANT, Maven, and Gradle are all build tools used for Java development. Here's a brief comparison:
>
> 1. ANT: It's an older build tool and relies on XML to define builds. It provides a lot of flexibility in terms of customizing build process but requires a lot of manual effort to maintain build scripts.
> 2. Maven: Maven is a convention-over-configuration tool that uses XML to define builds. It enforces a standard directory structure, provides central repository for jars, and has a lot of plugins available to handle common build tasks.
> 3. Gradle: Gradle is a build tool that uses Groovy-based domain specific language (DSL) for defining builds. It's more flexible than Maven and provides a lot of features like incremental builds, support for multi-project builds and caching, faster build time, etc.
>
> In summary, ANT provides maximum flexibility with manual effort, Maven provides a standard structure and easy to learn, while Gradle provides a balance of flexibility and ease of use.

간단히 정리하자면 ant와 maven은 XML을, gradle은 groovy를 기본으로 사용하는군요. 또한 ant는 매우 유연하지만 스크립트를 짜는데 노력이 많이 필요하며, maven은 디렉토리 구조 등을 제공하고 설정에 특정한 Convention을 따른다는 것을 알 수 있습니다. gradle의 경우 maven보다는 유연하며 다중프로젝트에 보다 빠르게 build 할 수 있다는 군요. *세부적인 정리는 하단에 같이 하도록 하겠습니다.*



### project management tool

그런데 제가 알기로는 Ant는 build만을 담당하는 build 전용 tool이고 나머지 maven, gradle의 경우 project manage tool이라고 알고 있었습니다. 그래서 다시 한번 물어보았습니다.

> Q: i thought maven and gradle is more like project manage tool. is it true? if true tell me more specific information about it.
>
> A: Yes, Maven and Gradle are often considered as project management tools, in addition to build tools. They provide features to manage dependencies, version control, reporting, and documentation of a project.
>
> 1. Maven: Maven provides a standard structure for a Java project, managing dependencies, building, testing and deploying a project. It also integrates with other tools like JavaDoc, JUnit and Surefire for reporting and documentation.
> 2. Gradle: Gradle is a flexible build tool that also provides features for project management. It can handle multi-project builds, manage dependencies and plugins, provide reporting and documentation. Gradle also provides options for creating custom tasks, and integrates with other tools like JUnit, Jacoco, and SonarQube for reporting and testing.
>
> Both Maven and Gradle provide a high level of abstraction and automation for project management, making it easier for developers to focus on coding and testing, rather than worrying about build and deployment.

maven과 gradle은 dependencies, version 등의 관리를 같이 해주기 때문에 build tool에 더해 project manage tool이라고 불리는군요. ~~제 얄팍한 지식이 잘못 저장된건 아니었군요.~~ maven 과 gradle은 공통적으로 개발자들이 build나 배포 보다 coding과 testing에 신경을 쓸 수 있도록 해준다고 합니다. 

다만 아까부터 gradle만 multi-project가 가능하다고 나오는데 그러면 maven은 multi-project가 힘들다는 뜻인지 물어보았습니다.

> Q: you said gradle can handle multi-project builds. is that maven can not handle multi-project builds?
>
> A: Maven can handle multi-project builds as well, but it requires a different approach compared to Gradle.
>
> In Maven, multi-module builds are achieved by creating a parent project that contains multiple child projects, where each child project is a separate module. The parent project manages the build order and dependencies between the modules.
>
> In Gradle, multi-project builds are achieved by defining multiple projects within a single build script. Gradle provides an easy-to-use syntax for defining dependencies between projects and also provides options for defining custom tasks and plugins.
>
> Both Maven and Gradle can handle multi-project builds, but the approach and syntax for doing so is different in each tool.

maven은 부모 프로젝트에서 각각의 다른 자식 프로젝트들을 관리할 수 있게 되어 있으나 gradle은 하나의 build script로 여러개의 프로젝트들을 쉽게 관리할 수 있다고 나오는군요.

#### multi-projects sample code

sample 코드를 보여달라고 해 보았습니다.

- maven

```sh
Parent Project
|-- pom.xml
|-- module1
|   |-- pom.xml
|-- module2
|   |-- pom.xml
```

```xml
<!-- Parent Project pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>parent-project</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>

  <modules>
    <module>module1</module>
    <module>module2</module>
  </modules>
</project>

<!-- module1 pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.example</groupId>
    <artifactId>parent-project</artifactId>
    <version>1.0-SNAPSHOT</version>
  </parent>
  <groupId>com.example</groupId>
  <artifactId>module1</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>
</project>

<!-- module2 pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.example</groupId>
    <artifactId>parent-project</artifactId>
    <version>1.0-SNAPSHOT</version>
  </parent>
  <groupId>com.example</groupId>
  <artifactId>module2</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>
</project>
```

- gradle

```
Root Project
|-- settings.gradle
|-- build.gradle
|-- project1
|   |-- build.gradle
|-- project2
|   |-- build.gradle
```

```groovy
// Root Project settings.gradle
rootProject.name = 'root-project'
include 'project1', 'project2'

// Root Project build.gradle
plugins {
  id 'java'
}

allprojects {
  repositories {
    mavenCentral()
  }
}

// project1 build.gradle
plugins {
  id 'java'
}

dependencies {
  implementation project(':project2')
}

// project2 build.gradle
plugins {
  id 'java'
}
```

## Conclusion

## Ant

> https://ant.apache.org/
>
> 최신버전:  Apache Ant 1.10.13 (2023-01-10)

#### 특징

1. 매우 유연합니다. (코딩규칙이나 레이아웃을 부과하지 않습니다.)
2. XML에 의지합니다.
3. build 스크립트를 짜는데 많은 시간이 걸립니다.(개발자가 대부분을 구현해야합니다.)
   - Ant는 따로 convention이 정해져 있지 않습니다. 따라서 개발자마다 구현하는 방식이 달라 프로젝트마다 매번 다시 분석해야합니다.

## maven

> https://maven.apache.org/what-is-maven.html

#### 특징

1. ant, gradle과 비교했을 때 가장 딱딱합니다.
2. Ant와 같이 XML에 의지합니다.
3. 배우기 쉽습니다.(비슷한 디렉토리 구조와 레이아웃을 사용합니다.)
   - maven의 경우 Ant와 다르게 제공하는 convention이 존재해서 다른 프로젝트를 접해도 분석에 시간이 많이 걸리지 않습니다. 
4. project의 life cycle을 관리(build, deploy)하여 개발자로 하여금 coding과 testing에 집중할 수 있도록 도와줍니다.

## gradle

> https://docs.gradle.org/current/userguide/what_is_gradle.html

### 특징

1. ant와 gradle 중간 정도로 유연합니다.
2. groovy를 사용합니다.
3. 하나의 build script로 multi-projects 들을 관리할 수 있습니다.
4. project의 life cycle을 관리(build, deploy)하여 개발자로 하여금 coding과 testing에 집중할 수 있도록 도와줍니다.



이번 Article은 chatGPT와 google, 각 홈페이지를 기반으로 작성되었습니다. chatGPT의 성능에 다시 한번 놀라게 되네요.

긴 글 읽어주셔서 감사합니다.



### References

https://www.javatpoint.com/difference-between-ant-and-maven

https://blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=rorean&logNo=222236619759&categoryNo=1&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView		