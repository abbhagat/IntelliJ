package searching;

public class MissingCharacter {
    public static void main(String[] args) {
        String s = "ecAfD";
        char[] c = s.toLowerCase().toCharArray();
        char min = c[0], max = c[0];
        int sum1 = 0, sum2 = 0;
        for (char x : c) {
            max = max < x ? x : max;
            min = min > x ? x : min;
            sum2 += x;
        }
        for (int i = min; i <= max; i++) {
            sum1 += (char) i;
        }
        System.out.println("Missing character :" + (char) (sum1 - sum2));
    }
}
