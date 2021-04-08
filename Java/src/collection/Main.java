package collection;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static {
        System.out.println("Static block called");
        System.exit(0);
    }

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        System.out.println(list);
    }
}
