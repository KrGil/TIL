# [AndroidStudio] <Error> Error while waiting for device: Illegal char <*> at index 0: *.lock 오류 해결

> 모바일 어플리케이션 관리를 인수인계 받은지 2주 정도 지났습니다. 보라는 업무 흐름이나 내부 소스는 들여다보지 않은 채로 세팅을 이것저것 건들이는 도중 에뮬레이터를 실행하여 테스트를 해볼 수 있다는 사실을 알았습니다. AVD(Android Virtual Device) Manager를 통하여 생성한다는 사실을 알아 실행하던 도중 `Error while waiting for device: Illegal char <*> at index 0: *.lock` 에러를 겪게 되었고 이를 해결하는 간단한 방법을 작성하려 합니다.

# 오류

> 안드로이드 어플리케이션을 실행 시키면 아래의 이미지와 같이 오류 문구가 출력됩니다.(~~잘 되던게 왜 안될까...~~)

![image-20221222153645953](https://raw.githubusercontent.com/KrGil/TIL/b810b18b8722249cf4a3027a79f34993fb65dde7/CS/IDETools/AndroidStudio/avd_manager.assets/image-20221222153645953.png)

구글링을 통해 여러 방법을 알아 보았고 제가 사용했던 방법은 아주 간단한 방법입니다.

# 해결

> android studio(혹은 intellij)에서 `Device Manager` 을 활성화 합니다
>
> `Actions` 탭에서 우측의 설정 탭을 클릭, `Show on Disk`를 클릭합니다.

![image-20221222153726811](https://raw.githubusercontent.com/KrGil/TIL/b810b18b8722249cf4a3027a79f34993fb65dde7/CS/IDETools/AndroidStudio/avd_manager.assets/image-20221222153726811.png)



클릭 후 아래의 창이 열리면 `hardware-qemu.ini.lock` 폴더를 삭제합니다.

![image-20221222153814647](https://raw.githubusercontent.com/KrGil/TIL/b810b18b8722249cf4a3027a79f34993fb65dde7/CS/IDETools/AndroidStudio/avd_manager.assets/image-20221222153814647.png)



그 후 안드로이드 프로그램을 실행시키면 아래와 같이 잘 작동하는 것을 확인하실 수 있습니다.

![image-20221222154012006](https://raw.githubusercontent.com/KrGil/TIL/b810b18b8722249cf4a3027a79f34993fb65dde7/CS/IDETools/AndroidStudio/avd_manager.assets/image-20221222154012006.png)



감사합니다.

### reference

https://stackoverflow.com/questions/27014901/android-studio-emulator-is-already-running/63734419#63734419