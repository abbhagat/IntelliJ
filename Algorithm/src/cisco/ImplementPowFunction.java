package cisco;

public class ImplementPowFunction {

    private static double pow(double x, int n) {
        return n < 0 ? 1 / (power(x, -n)) : power(x, n);
    }

    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = power(x, n / 2);
        return n % 2 == 0 ? v * v : v * v * x;
    }

    public static void main(String[] args) {
        System.out.println(pow(3, 2));
        System.out.println(pow(9, -2));
    }
}
