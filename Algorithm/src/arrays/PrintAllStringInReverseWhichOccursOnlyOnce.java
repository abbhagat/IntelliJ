package arrays;

public class PrintAllStringInReverseWhichOccursOnlyOnce {

    public static void main(String[] args) {

        char[] c = "aabdceaaabbbfcgd".toCharArray();
        int[] temp = new int[128];
        for (char x : c) {
            temp[x]++;
        }
        for (int i = c.length - 1; i >= 0; i--) {
            if (temp[c[i]] == 1) {
                System.out.print(c[i]);
                temp[c[i]] = 0;
            }
        }
    }
}
