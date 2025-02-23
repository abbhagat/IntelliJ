package java8.equals;

import java8.emp.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DeepEqualsDemo {

    public static void main(String[] args) {
        List<Employee> list1 = Arrays.asList(new Employee("A", 65),
                                             new Employee("B", 66),
                                             new Employee("C", 67),
                                             new Employee("D", 68),
                                             new Employee("E", 69),
                                             new Employee("F", 70),
                                             new Employee("G", 71),
                                             new Employee("H", 72)
                                           );
        List<Employee> list2 = Arrays.asList(new Employee("C", 67), new Employee("D", 68), new Employee("I", 73));
        List<Employee> list3 = Arrays.asList(new Employee("C", 67), new Employee("D", 68), new Employee("I", 73));

        System.out.println("Objects.deepEquals(list1,list2) --> " + Objects.deepEquals(list1, list2));
        System.out.println("Objects.deepEquals(list2,list3) --> " + Objects.deepEquals(list2, list3));
        System.out.println("list2.equals(list3) --> " + list2.equals(list3));
    }
}
