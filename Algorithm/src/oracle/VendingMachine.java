package oracle;

public class VendingMachine {

    private static boolean isValid(int n) {
        return n % 3 == 0 || n % 5 == 0 || n % 7 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid(37));
        System.out.println(isValid(32));
    }
}
