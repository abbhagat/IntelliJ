package arrays;

public class BestStringAnagramSoln {

    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "aJva";
        boolean isAnagram = true;
        int[] temp = new int[128];
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                temp[s1.charAt(i)]++;
                temp[s2.charAt(i)]--;
            }
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != 0) {
                    isAnagram = false;
                    break;
                }
            }
            System.out.println(isAnagram ? "Anagram" : "Not Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }
}
