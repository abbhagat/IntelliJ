package java8.comparator;

import java8.emp.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }

}

public class ComparatorDemo {

    public static void main(String[] args) {

        List<Employee> mainList = new ArrayList<>();

        mainList.add(new Employee("Abhinaw", 4));
        mainList.add(new Employee("Kumar", 5));
        mainList.add(new Employee("Bhagat", 1));

        Comparator<Employee> byName = (e1, e2) -> e2.getName().compareTo(e1.getName());
        Comparator<Employee> byId = Comparator.comparingInt(Employee::getId).reversed();

        Collections.sort(mainList, byId);
        mainList.forEach(System.out::println);

        Collections.sort(mainList, byName);
        mainList.stream().forEachOrdered(System.out::println);

        System.out.println();
        Collections.sort(mainList, byId.thenComparing(byName));
        mainList.forEach(System.out::println);
    }
}
