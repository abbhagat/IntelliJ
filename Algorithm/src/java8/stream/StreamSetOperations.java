package java8.stream;

import java8.emp.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamSetOperations {

    public static void main(String[] args) {

        List<Employee> mainList = Arrays.asList(
                new Employee("A", 65), new Employee("B", 66),
                new Employee("C", 67), new Employee("D", 68),
                new Employee("E", 69), new Employee("F", 70),
                new Employee("G", 71), new Employee("H", 72)
        );

        List<Employee> cancelList = Arrays.asList(
                new Employee("C", 67),
                new Employee("D", 68),
                new Employee("I", 73)
        );

        // Set A intersection Set B
        List<Employee> commonList = mainList
                .stream()
                .filter(mList -> cancelList.stream().anyMatch(cList -> mList.getName().equals(cList.getName())))
                .toList();
        commonList.forEach(System.out::println);
        System.out.println();

        // Set B - Set A
        List<Employee> onlyInCancelList = cancelList
                .stream()
                .filter(cList -> mainList.stream().noneMatch(mList -> mList.getName().equals(cList.getName())))
                .toList();
        onlyInCancelList.forEach(System.out::println);
        System.out.println();

        // Set A - Set B
        List<Employee> onlyInMainList = mainList
                .stream()
                .filter(mList -> cancelList.stream().noneMatch(cList -> mList.getName().equals(cList.getName())))
                .toList();
        onlyInMainList.forEach(System.out::println);
        System.out.println();

        System.out.println(Collections.disjoint(mainList, cancelList));
        Set<String> set = mainList.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(set);
    }

}
