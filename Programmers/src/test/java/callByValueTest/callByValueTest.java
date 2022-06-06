package callByValueTest;

import org.junit.jupiter.api.Test;

/**
 * packageName :  callByValueTest
 * fileName : callByValueTest
 * author :  eisen
 * date : 2022/06/06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/06/06                eisen             최초 생성
 */

public class callByValueTest {
    Human 뱅타 = new Human("뱅타", 34);
    Human msg = new Human("MSG", 29);
    Human temp = new Human("temp", 0);

    @Test
    public void 뱅타와msg나이확인() {

        changePerson(뱅타, msg);
        System.out.println("뱅타 = " + 뱅타);

        changeName(뱅타, "msg");
        System.out.println("뱅타 = " + 뱅타);
        System.out.println("msg = " + msg);

    }

    private static void changePerson(Human 뱅타, Human msg) {
        뱅타 = msg;
        뱅타.age = 50;
    }

    private static void changeName(Human 뱅타, String name) {
        뱅타.name = name;
    }


    static public class Human {
        String name;
        int age;

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
