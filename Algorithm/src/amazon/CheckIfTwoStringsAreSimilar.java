package amazon;

public class CheckIfTwoStringsAreSimilar {

    private static boolean isSimilar(String s1, String s2) {
        if (s1.length() == s2.length()) {
            int[] temp = new int[128];
            for (int i = 0; i < s1.length(); i++) {
                temp[s1.charAt(i)]++;
                temp[s2.charAt(i)]--;
            }
            for (int x : temp) {
                if (x != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String... args) {
        System.out.println(isSimilar("xyz", "yxz") ? "Similar" : "Not Similar");
    }
}
