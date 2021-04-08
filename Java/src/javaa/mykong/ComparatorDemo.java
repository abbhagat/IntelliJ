package javaa.mykong;

import java.util.*;

public class ComparatorDemo {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(new Employee("Abhinaw", 1, new Date("07-OCT-1986")),
                new Employee("Nikita", 2, new Date("26-APR-1986")), new Employee("Kritika", 3, new Date("18-AUG-1993")),
                new Employee("Richaa", 4, new Date("12-AUG-1985")),
                new Employee("Indrasan", 5, new Date("12-SEP-1982")));

        Comparator<Employee> byName = (e1, e2) -> e1.getName().compareTo(e2.getName());
        Collections.sort(empList, byName);
        empList.forEach(System.out::println);
        System.out.println();

        Collections.sort(empList, (e1, e2) -> e2.getId() - e1.getId());
        empList.forEach(System.out::println);
        System.out.println();

        Collections.sort(empList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getDob().compareTo(e2.getDob());
            }
        });
        empList.forEach(System.out::println);
        System.out.println();
    }

}
