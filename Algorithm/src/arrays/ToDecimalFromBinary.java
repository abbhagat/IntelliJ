package arrays;

public class ToDecimalFromBinary {

    private static int toDecimal(int n) {
        int sum = 0;
        for (int i = 0; n != 0; i++) {
            int k = n % 10;
            sum += k * (int) Math.pow(2, i);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(toDecimal(111));
        System.out.println(toDecimal(1111));
    }
}
