package patterns.factory_pattern.after;

/**
 * packageName :  patterns.factory_pattern.after
 * fileName : AnimalType
 * author :  eisen
 * date : 2022/04/17
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/17                eisen             최초 생성
 */
public enum AnimalType {
        CAT("cat"), DOG("dog"), NONE("none");

        private final String value;
        AnimalType(String value) {
            this.value = value;
        }
        public String getValue(){
            return value;
        }

}

