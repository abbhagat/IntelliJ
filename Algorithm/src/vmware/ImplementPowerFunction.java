package vmware;

public class ImplementPowerFunction {

    private static double powers(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= x;
        }
        return result;
    }

    private static double pow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return power(x, n);
    }

    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = power(x, n / 2);
        return n % 2 == 0 ? v * v : v * v * x;
    }

    public static void main(String[] args) {
        System.out.println(pow(2.00000, 10) + "\t" + powers(2.00000, 10));
        System.out.println(pow(2.10000, 3)  + "\t" + powers(2.10000, 3));
        System.out.println(pow(2.00000, -2) + "\t" + powers(2.00000, -2));
        System.out.println(pow(2.00000, 0)  + "\t" + powers(2.00000, 0));
    }
}
