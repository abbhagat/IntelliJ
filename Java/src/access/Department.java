package access;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Department {

    private final int id;
    private final Date date;
    private final String name;

    public Department(int id, Date date, String name) {
        this.id = id;
        this.date = date;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return (Date) date.clone();
    }

    public boolean equals(Object obj) {
        Department d = (Department) obj;
        if (d == this) {
            return true;
        }
        if (d == null || d.getClass() != this.getClass()) {
            return false;
        }

        return this.getId() == d.getId() && d.getName().equals(this.getName()) && this.getDate().equals(d.getDate());
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (result * prime) + this.id;
        result = (result * prime) + (this.name == null ? 0 : this.name.hashCode());
        result = (result * prime) + (this.date == null ? 0 : this.date.hashCode());
        return result;
    }

    public static void main(String[] args) {
        int id = 10;
        String name = "Java";
        Date date = new Date("07-OCT-1986");
        Department d1 = new Department(id, date, name);
        Department d2 = new Department(id, date, name);
        Department d3 = new Department(id, date, name);
        System.out.println(d1.equals(d2) + "\t" + d2.equals(d3) + "\t" + d3.equals(d1));
        System.out.println(d1.hashCode() + "\t" + d2.hashCode() + "\t" + d3.hashCode());
        Map<Department, Integer> map = new HashMap<>();
        map.put(d1, 1);
        map.put(d2, 2);
        map.put(d3, 3);
        System.out.println(map.size());
        System.out.println(map.get(d1));
        System.out.println(map.get(d2));
        System.out.println(map.get(d3));
        map.forEach((k, v) -> {
            System.out.println(k.getName() + "\t" + v);
        });
    }

}
