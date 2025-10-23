package java8.stream;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateMapFromList {

  private record Employee(int id, String deptName) {
  }

  public static void main(String[] args) {

    Employee emp1 = new Employee(1, "D1");
    Employee emp2 = new Employee(2, "D2");
    Employee emp3 = new Employee(3, "D3");
    Employee emp4 = new Employee(4, "D1");
    Employee emp5 = new Employee(5, "D2");
    Employee emp6 = new Employee(6, "D8");

    List<Employee> employeeList = List.of(emp1, emp2, emp3, emp4, emp5, emp6);
    Map<Integer, String> result = employeeList
        .stream()
        .collect(Collectors.toMap(Employee::id, Employee::deptName));
    System.out.println(result);
    Map<String, List<Integer>> deptToIdsMap = employeeList
        .stream()
        .collect(
            Collectors.groupingBy(Employee::deptName, Collectors.mapping(Employee::id, Collectors.toList()))
        );
    System.out.println(deptToIdsMap);
    Map<String, List<Integer>> map = new LinkedHashMap<>();
    employeeList.forEach(emp -> {
      List<Integer> list = map.containsKey(emp.deptName()) ? map.get(emp.deptName()) : new ArrayList<>();
      list.add(emp.id());
      map.put(emp.deptName(), list);
    });
    System.out.println(map);
  }
}
