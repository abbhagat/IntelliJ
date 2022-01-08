package singleton;

public class Doubleton {

    private static Doubleton instance1, instance2;
    private static int index;

    private Doubleton() {
    }

    public static Doubleton getInstance() {
        if (instance1 == null) {
            instance1 = new Doubleton();
            return instance1;
        }
        if (instance2 == null) {
            instance2 = new Doubleton();
            return instance2;
        }
        return index++ % 2 == 0 ? instance1 : instance2;
    }

    public static void main(String[] args) {
        Doubleton obj1 = Doubleton.getInstance();
        Doubleton obj2 = Doubleton.getInstance();
        Doubleton obj3 = Doubleton.getInstance();
        Doubleton obj4 = Doubleton.getInstance();
        Doubleton obj5 = Doubleton.getInstance();
        Doubleton obj6 = Doubleton.getInstance();
        System.out.println("Printing the hashcodes to check memory addresses");
        System.out.println("obj1.hashCode() : " + obj1.hashCode());
        System.out.println("obj3.hashCode() : " + obj3.hashCode());
        System.out.println("obj5.hashCode() : " + obj5.hashCode());
        System.out.println("obj2.hashCode() : " + obj2.hashCode());
        System.out.println("obj4.hashCode() : " + obj4.hashCode());
        System.out.println("obj6.hashCode() : " + obj6.hashCode());
        System.out.println("Printing the Object's Attributes");
        System.out.println("obj1 : " + obj1);
        System.out.println("obj2 : " + obj2);
        System.out.println("obj3 : " + obj3);
        System.out.println("obj4 : " + obj4);
        System.out.println("obj5 : " + obj5);
        System.out.println("obj6 : " + obj6);
        System.gc();
    }
}