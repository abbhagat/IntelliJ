package corejava;

class SuperStatic {

    static int x = 10;

    static SuperStatic display() throws java.io.IOException {
        System.out.println("Super :" + x);
        return null;
    }
}

class SubStatic extends SuperStatic {

    static int x = 20;

    static SubStatic display() throws java.io.IOException { // error for ClassNotFoundException
        System.out.println("Sub :" + x);
        return null;
    }
}

public class StaticOverride {
    public static void main(String[] args) throws java.io.IOException {
        SuperStatic sup = new SubStatic();
        sup.display();
        int[] a = { 1, 2, 3 };
        int i = 0;
        while (i < a.length) {
            System.out.println(a[i++]);
        }
        System.out.println(i);
    }
}
