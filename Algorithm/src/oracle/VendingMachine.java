package oracle;

public class VendingMachine {
    static boolean isValid(int n) {
        if (n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {
           return true;
        }
        n %= 7;
        if (n % 5 == 0 || n % 3 == 0) {
            return true;
        } else {
            n = n % 5;
        }
        return (n % 3 == 0) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isValid(37));
        System.out.println(isValid(32));
    }
}
