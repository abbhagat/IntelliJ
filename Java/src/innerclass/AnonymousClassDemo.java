package innerclass;

public class AnonymousClassDemo implements I {

    public static void main(String[] args) throws java.io.IOException {
        I i = new I() {
            public void cook() {
                System.out.println("Cook Food");
            }
        };
        i.cook();
        System.out.println(args.length);
        Runtime.getRuntime().exec("Notepad");
    }

    public void cook() {
        System.out.println("Interface Cook method");
    }
}
