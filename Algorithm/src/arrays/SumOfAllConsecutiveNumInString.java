package arrays;

public class SumOfAllConsecutiveNumInString {
    public static void main(String[] args) {
        String s = "11aa220bb33dd44";
        int n = 0, sum = 0;
        for (char x : s.toCharArray()) {
            if (x >= 48 && x <= 57) {
                n = n * 10 + x - 48;
            } else {
                sum += n;
                n = 0;
            }
        }
        System.out.println(sum);
    }
}
