package singleton;

public class Student implements Cloneable {
    private String name;
    private int marks;

    Student() {
    }

    Student(int x) {

    }

    public void display1() {
        this.display2();
    }

    public void display2() {
        synchronized (this) {

        }
        System.out.println("display2");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton s = Singleton.getInstance();
        System.out.println(s);
        Singleton s1 = (Singleton) s.clone();
        System.out.println(s1);
        System.out.println(s.hashCode() + "\t" + s1.hashCode());
        System.out.println(s.equals(s1));
        new Student().display1();
    }
}
