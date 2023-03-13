package arrays;

public class SumOfAllConsecutiveNumInString {
    public static void main(String[] args) {
        char[] c = "123aa21bb33dd44".toCharArray();
        int j = 0, sum = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] >= 48 && c[i] <= 57) {
                sum += (c[i] - 48) * Math.pow(10, j);
                j++;
            } else {
                j = 0;
            }
        }
        System.out.println(sum);
    }
}
