package jpmorgan;

public class ToDecimalFromBinary {

    static int toDecimal(int n) {
        int sum = 0;
        int k, i = 0;
        while (n != 0) {
            k = n % 10;
            sum += k * Math.pow(2, i);
            n /= 10;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(toDecimal(1111));
    }
}
