# [javaScript] prop() vs attr()

### Before we go

> 예전에 prop()와 attr()을 사용함에 있어 존재하는 차이점에 대해서 찾아본 적이 있습니다. 그런데 이번에 다시 사용하려고 하니 기억이 안나더군요.
>
> 그래서 후에 또다시 기억이 나지 않을 때 다시 볼 수 있도록 간략하게 정리하려 합니다.



### 버전에 따른 사용법 차이

 #### jquery 1.6  이전

​	1.6버전 이전에는 attr()을 사용합니다. 이 때에는 property와 attribute가 구분되지 않는 형태로 결과값이 제공되었다고 합니다.



#### jquery 1.6 이후

​	1.6버전 이후부터는 attr()은 속성 그 자체의 값을 반환하고 있으며, prop()는 속성값을 명시적으로 찾아낼 수 있는 방법을 제공합니다.

#### https://api.jquery.com/attr/

> As of jQuery 1.6, the `.attr()` method returns `undefined` for attributes that have not been set. **To retrieve and change DOM properties such as the `checked`, `selected`, or `disabled` state of form elements, use the [.prop()](https://api.jquery.com/prop/) method.**



### 실제 코드 및 결과값

#### html

```
<input type="checkbox" id="test1" checked="checked"> test1
<input type="checkbox" id="test2"> test2
```

#### javascript

```
$("#test1").attr("checked"); // checked
$("#test2").prop("checked"); // true
```

로 결과값이 출력됩니다.



### 특정 속성 추가하기

만약 ```$("#test1")```에 ```readonly```라는 속성값을 주고자 할 때에는 아래와 같이 사용하여야 합니다.



### true or false

#### jQuery < 1.9

```
$("#inputId").attr("readonly", true);
```



#### jQuery 1.9 +

```
$("#inputId").prop("readonly", true);
```

or

```
$("#inputId").attr("readonly", "readonly");
```

#### remove

```
$("#descrip").removeAttr("readonly");
```



### Result

간단하게 정리하자면 

.attr()을 통해서는 ```element```가 가지는 __속성값이나 정보__(checked, selected)를 조회하거나 세팅을,

.prop()를 통해서는 ```element```가 가지는 __실제적인 상태__(활성화, 체크, 선택여부 등 *true, false*)의 제어를 할 때 사용하면 됩니다.





### References

https://stackoverflow.com/questions/1306708/how-to-add-a-readonly-attribute-to-an-input

https://ojava.tistory.com/133









