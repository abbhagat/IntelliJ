package package1;

public class Class4 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Inside run method");
            }
        };
        r.run();
    }
}
