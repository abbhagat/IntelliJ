package innerclass;

class ABC implements Cloneable {

    ABC() {
        System.out.println("Constructor");
    }

    int x;

    public Object clone() {
        Object cloneObj;
        try {
            cloneObj = super.clone();
        } catch (CloneNotSupportedException e) {
            return this;
        }
        return cloneObj;
    }

    void display() {
        System.out.println("display");
    }
}

public class CloneDemo {
    public static void main(String... args) {
        ABC a = new ABC();
        a.x = 10;
        System.out.println(a.x);
        ABC b = (ABC)a.clone();
        b.x = 20;
        System.out.println(a.x + "\t" + b.x);
        System.out.println(a.hashCode() + "\t" + b.hashCode());
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
