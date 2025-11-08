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

        Comparator<Employee> byName = (e1, e2) -> e1.getName().compareTo(e2.getName()); // Comparator.comparing(Employee::getName);
        Comparator<Employee> byId = (e1, e2) -> e1.getId().compareTo(e2.getId());    // Comparator.comparingInt(Employee::getId);

        mainList.sort(byId);
        System.out.println(mainList);

        mainList.sort(byName);
        System.out.println(mainList);

        Collections.sort(mainList, byId.thenComparing(byName));
        mainList.sort(byId.thenComparing(byName));
        System.out.println(mainList);
    }
}
