package arrays;

public class RunLengthEncodedString {

    public static void main(String[] args) {
        String s = "wwwwaaadexxxxxxq";
        int[] temp = new int[26];
        for (char c : s.toCharArray()) {
            temp[c - 97]++;
        }
        for (char c : s.toCharArray()) {
            if (temp[c - 97] > 0) {
                System.out.print(c + "" + temp[c - 97]);
                temp[c - 97] = 0;
            }
        }
    }
}
