package threads;

public class ThreadDeadlock {

    void method1() {
        synchronized (Integer.class) {
            System.out.println("Lock On Integer class");
            synchronized (String.class) {
                System.out.println("Lock On String class");
            }
        }
    }

    void method2() {
        synchronized (String.class) {
            System.out.println("Lock On String class");
            synchronized (Integer.class) {
                System.out.println("Lock On Integer class");
            }
        }
    }

    public static void main(String[] args) {

    }
}
