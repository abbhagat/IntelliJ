package geeks;

public class ToBinaryFromDecimal {

    public static String toBinary(int n) {
        String s = "";
        while (n != 0) {
            s += n % 2;
            n = n / 2;
        }
        return new StringBuffer(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toBinary(12));
    }
}
