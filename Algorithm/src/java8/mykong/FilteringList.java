package java8.mykong;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringList {

    public static void main(String[] args) {

        List<Employee> list1 = Arrays.asList(
                new Employee("Abhinaw", 1, new Date("07-OCT-1986")),
                new Employee("Nikita", 2, new Date("26-APR-1986")),
                new Employee("Kritika", 3, new Date("18-AUG-1993")),
                new Employee("Richa", 4, new Date("12-AUG-1985")),
                new Employee("Indrasan", 5, new Date("12-SEP-1982"))
        );

        List<Employee> list2 = Arrays.asList(
                new Employee("Abhinaw", 1, new Date("07-OCT-1986")),
                new Employee("Nikita", 2, new Date("26-APR-1986")),
                new Employee("Kritika", 3, new Date("18-AUG-1993"))
        );

        // List1 - List2

        List<Employee> result;

        result = list1.stream().filter(l1 -> list2.stream().filter(l2 -> l1.getName().equals(l2.getName())).count() == 0)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
        System.out.println();

        result = list1.stream().filter(l1 -> list2.stream().filter(l2 -> l1.getName().equals(l2.getName())).count() != 0)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
        System.out.println();

        List<String> l = Arrays.asList("A", "B", "C", "D");
        long count = l.stream().count();
        System.out.println(count);
    }

}
