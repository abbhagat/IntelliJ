package arrays;

public class UglyNumber {

    static boolean isUgly(int n) {
        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);
        return (n == 1) ? true : false;
    }

    static int maxDivide(int a, int b) {
        while (a % b == 0) {
            a /= b;
        }
        return a;
    }

    public static void main(String[] args) {
        int count = 0;
        int i = 1;
        while (true) {
            if (isUgly(i)) {
                count++;
            }
            if (count == 7) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
