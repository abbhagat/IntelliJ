package java8.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreateMapFromList {

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Employee {
        private int id;
        private String deptName;
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee(1, "D1");
        Employee emp2 = new Employee(2, "D2");
        Employee emp3 = new Employee(3, "D3");
        Employee emp4 = new Employee(4, "D1");
        Employee emp5 = new Employee(5, "D2");

        List<Employee> employeeList = List.of(emp1, emp2, emp3, emp4, emp5);
        Map<Employee, String> result = employeeList.stream().collect(Collectors.toMap(Function.identity(), Employee::getDeptName));
        System.out.println(result);
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        employeeList.forEach(emp -> {
            List<Integer> list = map.containsKey(emp.getDeptName()) ? map.get(emp.getDeptName()) : new ArrayList<>();
            list.add(emp.getId());
            map.put(emp.getDeptName(), list);
        });
        System.out.println(map);
    }
}
