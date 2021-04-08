package access;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Employee {

    private final int id;
    private final Date dob;

    public Employee(int id, Date dob) {
        this.id = id;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public Date getDob() {
        return (Date) dob.clone();
    }

    public boolean equals(Object obj) {
        Employee e = (Employee) obj;
        if (e == this) {
            return true;
        }

        if (e == null || e.getClass() != this.getClass()) {
            return false;
        }

        return this.id == e.id && this.getDob().equals(e.getDob());
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + (this.dob == null ? 0 : dob.hashCode());
        result = result * prime + id;
        return result;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, new Date("07-OCT-1986"));
        Employee e2 = new Employee(1, new Date("07-OCT-1986"));
        Map<Employee, String> map = new HashMap<>();
        map.put(e1, "1");
        map.put(e2, "2");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(e1.getDob() + "\t" + e2.getDob());
    }
}
