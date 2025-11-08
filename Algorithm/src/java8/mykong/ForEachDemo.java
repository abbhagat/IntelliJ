package java8.mykong;

import java.util.*;

public class ForEachDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 65);
        map.put("B", 66);
        map.put("C", 67);
        map.put("D", 68);
        map.put("E", 69);
        map.put("F", 70);

        map.forEach((k, v) -> System.out.println("Key := " + k + "\t" + "Value := " + v));

        map.forEach((k, v) -> {
            if (k.equals("A")) {
                System.out.println("Key := " + k + "\t" + "Value := " + v);
            }
        });

        List<Employee> empList = Arrays.asList(new Employee("A", 65, new Date()), new Employee("B", 66, new Date()), new Employee("C", 67, new Date()));
        empList.forEach(System.out::println);
    }

}
