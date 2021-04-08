package javaa.stream;

import javaa.emp.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListToUpperCaseDemo {

	public static void main(String[] args) {

		List<Employee> mainList = Arrays.asList(new Employee("A", 65), new Employee("B", 66), new Employee("C", 67),
				new Employee("D", 68), new Employee("E", 69), new Employee("F", 70), new Employee("G", 71),
				new Employee("H", 72));

		List<String> names = mainList.stream().map(Employee::getName).filter(name -> name.startsWith("C"))
				.collect(Collectors.toList());
		names.forEach(System.out::print);
		System.out.println();
		List<String> list = mainList.stream().map(Employee::getName).map(s -> s.toLowerCase())
				.collect(Collectors.toList());
		list.forEach(System.out::print);
		System.out.println();
		list = mainList.stream().map(Employee::getName).map(String::toUpperCase).collect(Collectors.toList());
		list.forEach(System.out::print);
		System.out.println();
	}

}
