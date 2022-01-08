package corejava;

class A implements Cloneable {

    int x, y;

    A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneDemo {
    public static void main(String[] args) {
        A a = new A(10, 20);
        A b = null;
        try {
            b = (A) a.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //a=b;
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.x + "\t" + a.y);
        System.out.println(b.x + "\t" + b.y);
        a.x = 100;
        a.y = 200;
        System.out.println(a.x + "\t" + a.y);
        System.out.println(b.x + "\t" + b.y);
    }
}
