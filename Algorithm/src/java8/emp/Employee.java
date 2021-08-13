package java8.emp;

public class Employee {

    private String name;
    private Integer id;

    public Employee(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
