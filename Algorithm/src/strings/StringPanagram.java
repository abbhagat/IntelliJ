package strings;

import java.util.stream.IntStream;

public class StringPanagram {

    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";
        int[] temp = new int[26];
        for (char x : s.toLowerCase().toCharArray()) {
            if (x >= 97 && x <= 122) {
                temp[x - 97]++;
            }
        }
        IntStream.range(0, temp.length).forEach(i -> {
            if (temp[i] == 0) {
                System.out.println("String is not panagram");
                System.exit(0);
            }
        });
        System.out.println("String is panagram");
    }
}
