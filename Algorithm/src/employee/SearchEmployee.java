package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchEmployee {

    public static void main(String[] args) {
        List<Employee> al = new ArrayList<>();
        al.add(new Employee(1, "A", 25f));
        al.add(new Employee(3, "E", 15f));
        al.add(new Employee(6, "F", 15f));
        al.add(new Employee(2, "C", 05f));
        al.add(new Employee(7, "G", 25f));
        al.add(new Employee(4, "B", 75f));
        al.add(new Employee(5, "D", 55f));
        Collections.sort(al, (e1, e2)-> e1.getName().compareTo(e2.getName()));
        Employee e1 = new Employee(0, "Q", 15f);
        Employee e2 = new Employee(1, "A", 25f);
        System.out.println(Collections.binarySearch(al, e1, new NameComparator()));
        System.out.println(Collections.binarySearch(al, e2, new NameComparator()));

    }
}
