package geeksforgeeks;

public class BeautifulNumber {

    private static boolean isBeautiful(int num) {
        if (num == 1) {
            return true;
        }
        int sum = 0;
        while (num != 0) {
            int k = num % 10;
            sum += Math.pow(k, 2);
            num = num / 10;
        }
        return sum > 1 && sum < 10 ? false : isBeautiful(sum);
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int m = n;
        while (true) {
            n = sum(sum(n));
            m = sum(m);
            if (m == 1 || n == 1) {
                return true;
            }
            if (m == n && n != 1) {
                return false;
            }
        }
    }

    private static int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int k = n % 10;
            sum += k * k;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isBeautiful(31) ? "Beautiful" : "Not Beautiful");
        System.out.println(isBeautiful(32) ? "Beautiful" : "Not Beautiful");
        System.out.println(isBeautiful(33) ? "Beautiful" : "Not Beautiful");
        System.out.println(isHappy(31) ? "Beautiful" : "Not Beautiful");
        System.out.println(isHappy(32) ? "Beautiful" : "Not Beautiful");
        System.out.println(isHappy(33) ? "Beautiful" : "Not Beautiful");
    }
}
