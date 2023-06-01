package strings;

public class StringPanagram {

    private static boolean isPanagram(char[] c) {
        int[] temp = new int[26];
        for (char x : c) {
            if (x >= 'a' && x <= 'z') {
                temp[x - 'a']++;
            }
        }
        for (int x : temp) {
            if (x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";
        System.out.println(isPanagram(s.toLowerCase().toCharArray()) ? "Panagram" : "Not Panagram");
    }
}
