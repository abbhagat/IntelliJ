package java8.emp;

public final class Employee {

    private final String name;
    private final int id;

    public Employee(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return this.name + " " + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj || this.getClass() != obj.getClass()) {
            return false;
        }
        Employee emp = (Employee) obj;
        return this.getName().equals(emp.getName()) && this.getId() == emp.getId();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        final int prime = 31;
        hashCode = prime * hashCode + this.getId();
        hashCode = prime * hashCode + (null == this.getName() ? 0 : this.getName().hashCode());
        return hashCode;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Abhinaw", 1);
        Employee e2 = new Employee("Abhinaw", 1);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode() == e2.hashCode());
    }
}
