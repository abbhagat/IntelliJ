package java8.stream;

import java8.emp.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilteringListUsingObjectNonNull {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", null, "", "D", null, "E");
		list = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
		list.forEach(System.out::println);
		
		List<Employee> empList = Arrays.asList(new Employee("A", 65), new Employee("B", 66), new Employee("C", 67),
				new Employee("D", 68),null, new Employee("E", 69), new Employee("F", 70), new Employee("G", 71),
				new Employee("H", 72),null);
		
		empList = empList.stream().filter(Objects::nonNull).collect(Collectors.toList());
		empList.forEach(System.out::println);
	}

}
