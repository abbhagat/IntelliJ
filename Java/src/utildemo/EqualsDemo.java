package utildemo;

final class A {

    private final int x;

    public A(int x) {
        this.x = x;
    }

    private int getX() {
        return x;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return this.getX() == ((A) obj).getX();
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        return result;
    }
}

public class EqualsDemo {
    public static void main(String[] args) {
        A a = new A(10);
        A b = new A(10);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
        System.out.println(a.equals(null));
        System.out.println(null == null);
        System.out.println(a.hashCode() + "\t" + b.hashCode());
    }
}
