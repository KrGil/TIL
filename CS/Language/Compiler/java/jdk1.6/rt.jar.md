# [Java] com.sun.image.codec.jpeg(jdk1.6) 를 jdk 1.8에서 적용하기(ImageIO, maven)

> 인수받은 프로젝트에서 pom.xml에서 maven compile 시 jdk 1.6을 참조하게끔 되어 있더군요. 확인해보니 1.8에서는 deprecated 된 `com.sun.image.codec.jpeg` 라이브러리를 import하고 있는 소스를 발견했습니다. jdk 1.6 의존을 삭제하고, deprecated 된 `com.sun.image.codec.jpeg` 소스를 jdk 1.8에 맞게 수정해보겠습니다.

## 분석

`com.sun.image.codec.jpeg` 라이브러리를 확인해 보니 `rt.jar` 에 포함되어 있는 라이브러리입니다. jdk 1.8로 버전업 되면서 deprecated 되었습니다.

구글링을 해 보니 stackoverflow에 해결책이 존재하더군요. 생각보다 많이 간단했습니다.



## 코드

~~*실제 코드와는 다르지만 비슷하게 구현해 보았습니다.*~~

### 기존(1.6) / com.sun.image.codec.jpeg

#### pom.xml

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.1</version>
    <configuration>
        <source>${java-version}</source>
        <target>${java-version}</target>
        <compilerArguments>
            <verbose />
            <bootclasspath>${java6-home}/jre/lib/rt.jar${path.separator}${java6-home}/jre/lib/jce.jar</bootclasspath>
        </compilerArguments>
        <showWarnings>true</showWarnings>
        <showDeprecation>true</showDeprecation>
    </configuration>
</plugin>
```

위와 같이 <build> 태그 내부에 필요없는 설정이 들어가 있습니다. 

#### .java

```java
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

FileOutputStream fos = new FileOutputStream(output); // 경로
JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(fos);
JPEGEncodeParam param = jpeg.getDefaultJPEGEncodeParam(bufferedImage);
jep.setQuality(1, false);
jpeg.encode(bufferedImage, param);
```

위와 같이 작성되어 있습니다. output으로 받은 경로를 stream으로 변환, JPEGEncoder를 활용하여 

jpeg로 변환하여 저장하는 소스인 듯 합니다.(BufferedImage는 width, height, imageType을 받는 기본 생성자로 생성할 수 있습니다.)

위의 코드들이 ImageIO를 사용하여 아래와 같이 변경할 수 있습니다.



### 변경(1.8) / javax.imageio.ImageIO

```java
import javax.imageio.ImageIO;
ImageIO.write(bufferedImage, "jpg", new file(output));
```

위와 같이 단 두줄로 변경할 수 있습니다. 또한 기존 `pom.xml`에 존재하는 설정을 삭제하여 build 하면 제대로 돌아가는 것을 확인할 수 있습니다.



### after

수정하고 나니 버전업을 왜 하는지 이해가 가는 듯 합니다. 1.6버전에서 



### References

https://stackoverflow.com/questions/8015291/how-to-replace-com-sun-image-codec-jpeg-jpegimageencoder-in-this-code