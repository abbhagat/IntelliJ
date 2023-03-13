package strings;

public class KStringAnagram {

    private static boolean isKStringAnagram(char[] c1, char[] c2, int kth) {
        if (c1.length == c2.length) {
            int[] temp = new int[128];
            for (int i = 0; i < c1.length; i++) {
                temp[c1[i]]++;
                temp[c2[i]]--;
            }
            int count = 0;
            for (int x : temp) {
                if (x != 0) {
                    count++;
                }
            }
            System.out.println(count);
            if (count <= kth) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isKStringAnagram("anagram".toCharArray(), "grammar".toCharArray(), 4) ? "K anagram" : "Not K anagram");
    }
}
