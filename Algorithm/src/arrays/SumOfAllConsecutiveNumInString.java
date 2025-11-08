package arrays;

public class SumOfAllConsecutiveNumInString {

    private static int sumOfAllConsecutiveNumInString(char[] a) {
        int sum = 0, n = 0;
        for (char c : a) {
            if (Character.isDigit(c)) {
                n = n * 10 + c - '0';
            } else {
                sum += n;
                n = 0;
            }
        }
        sum += n;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfAllConsecutiveNumInString("123aa21bb33dd44".toCharArray()));
        System.out.println(sumOfAllConsecutiveNumInString("123aa21bb33dd".toCharArray()));
    }
}
