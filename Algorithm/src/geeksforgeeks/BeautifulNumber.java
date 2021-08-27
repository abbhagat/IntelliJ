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

    public static void main(String[] args) {
        System.out.println(isBeautiful(31) ? "Beautiful" : "Not Beautiful");
        System.out.println(isBeautiful(32) ? "Beautiful" : "Not Beautiful");
    }
}
