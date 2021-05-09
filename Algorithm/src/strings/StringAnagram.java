package strings;

public class StringAnagram {

    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "vaJa";
        boolean isAnagram = true;
        int[] temp = new int[128];
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                temp[s1.charAt(i)]++;
                temp[s2.charAt(i)]--;
            }
            for (int i = 0; i < 128; i++) {
                if (temp[i] != 0) {
                    isAnagram = false;
                    break;
                }
            }
        } else {
            isAnagram = false;
        }
        System.out.println(isAnagram ? "Anagram" : "Not Anagram");

    }
}
