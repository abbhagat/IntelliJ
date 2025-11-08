package java8.stream;

import java8.emp.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {

    @SuppressWarnings("unused")
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
        mainList.add(new Employee("A", 10));

        Stream<Employee> stream = mainList.stream().filter(emp -> emp.getId() >= 70);
        System.out.println(stream.count());
        Map<Integer, String> result1 = mainList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));

        System.out.println("Result 1 : " + result1);

        Map<String, Integer> result2 = mainList.stream().collect(Collectors.toMap(Employee::getName, Employee::getId));

        System.out.println("Result 2 : " + result2);

        Map<Integer, String> result3 = mainList.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 3 : " + result3);

        for (Employee e : mainList) {
            Employee temp = new Employee(e.getName(), e.getId());
            // temp.setSalary(0);
            // empForHR.add(temp);
        }
    }

}
