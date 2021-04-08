package collection;

class A implements Comparable<A> {

    private String name;
    private int salary;

    A(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(A a) {
        return this.salary - a.salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        A a = new A("A", 500000);
        A b = new A("B", 100000);
        int x = a.compareTo(b);
        if (x == 0) {
            System.out.println("Equal Salary");
        } else if (x < 0) {
            System.out.println(a.getName() + " has less salary than " + b.getName());
        } else {
            System.out.println(a.getName() + " has more salary than " + b.getName());
        }
    }
}
