package arrays;

public class SumOfAllConsecutiveNumInString {
    public static void main(String[] args) {
        char[] a = "123aa21bb33dd44".toCharArray();
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
        System.out.println(sum);
    }
}
