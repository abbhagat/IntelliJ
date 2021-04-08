package access;

class SubMain extends OverridingMainMethod {
    public static void main(String[] args) {
        System.out.println("SubMain class Main Method called");
    }
}

public class OverridingMainMethod {
    public static void main(String[] args) {
        System.out.println("OverridingMainMethod Main Method called");
    }
}
