package streamTest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class List_to_Stream {

    void test(){

        List<testDTO> arr = new ArrayList<>();
        arr.add(new testDTO("1"));
        Stream<testDTO> a = arr.stream();

    }

    @AllArgsConstructor
    class testDTO{
        String name;

    }
}

