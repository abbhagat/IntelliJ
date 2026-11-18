package java8.stream;

import java8.emp.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringList {

  public static void main(String[] args) {

    List<Employee> mainList = new ArrayList<>();
    mainList.add(new Employee("A", 65));
    mainList.add(new Employee("B", 66));
    mainList.add(new Employee("C", 67));
    mainList.add(new Employee("D", 68));
    mainList.add(new Employee("E", 69));
    mainList.add(new Employee("F", 70));
    mainList.add(new Employee("G", 71));
    mainList.add(new Employee("H", 72));

    mainList.forEach(System.out::println); // Iterating the list using java 8

    System.out.println();

    mainList = mainList.stream().filter(line -> !"B".equals(line.getName())).collect(Collectors.toList()); // removing B from mainList
    mainList.forEach(System.out::println);

    List<Employee> cancelList = new ArrayList<>();
    cancelList.add(new Employee("A", 65));
    cancelList.add(new Employee("C", 67));
    cancelList.add(new Employee("D", 68));
    cancelList.add(new Employee("I", 73));
    cancelList.add(new Employee("J", 74));
    System.out.println();
    // We create a stream of elements from the first list.

    mainList = mainList
        .stream()
        .filter(line -> (cancelList.stream()
            .filter(cancelLine -> (line.getName().equals(cancelLine.getName())) && line.getId().equals(cancelLine.getId())).count()) < 1)
        .collect(Collectors.toList());
    System.out.println(mainList);
    List<Employee> list = mainList.stream()
        .filter(line -> cancelList.stream()
            .anyMatch(cancelLine -> cancelLine.getName().equals(line.getName()) && cancelLine.getId().equals(line.getId())))
        .collect(Collectors.toList());
    System.out.println(list);
    System.out.println();
    mainList = mainList
        .stream()
        .filter(line -> cancelList.stream().noneMatch(cancelLine -> (line.getName().equals(cancelLine.getName())) && line.getId().equals(cancelLine.getId())))
        .collect(Collectors.toList());
    mainList.forEach(System.out::println);
    System.out.println();
  }
}
