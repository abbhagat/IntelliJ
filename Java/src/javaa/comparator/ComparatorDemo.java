package javaa.comparator;

import javaa.emp.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
	
}

public class ComparatorDemo {

	public static void main(String[] args) {

		List<Employee> mainList = new ArrayList<>();

		mainList.add(new Employee("A", 10));
		mainList.add(new Employee("X", 7));
		mainList.add(new Employee("C", 15));
		mainList.add(new Employee("D", 68));
		mainList.add(new Employee("Z", 23));
		mainList.add(new Employee("F", 12));
		mainList.add(new Employee("G", 56));
		mainList.add(new Employee("Y", 18));

		Comparator<Employee> byName = (e1, e2) -> e2.getName().compareTo(e1.getName());
		Comparator<Employee> byId = Comparator.comparingInt(Employee::getId);

		Collections.sort(mainList, byId);
		mainList.forEach(list -> System.out.println(list.getName()));
		
		Collections.sort(mainList, byName);
		mainList.stream().forEachOrdered(System.out::println);

		System.out.println();

		Collections.sort(mainList, byId);
		mainList.forEach(System.out::println);
		
		Collections.sort(mainList, (Employee e1, Employee e2) -> e1.getId() - e2.getId());
		mainList.forEach(System.out::println);

		Collections.sort(mainList, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		System.out.println();
		mainList.forEach(System.out::println);
		System.out.println();
		Collections.sort(mainList, (e1, e2) -> e1.getId() - e2.getId());
		mainList.forEach(System.out::println);
	}
}
