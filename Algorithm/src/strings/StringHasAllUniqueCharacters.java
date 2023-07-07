package strings;

public class StringHasAllUniqueCharacters {

    private static boolean hasAllUniqueChar(String s) {
        int[] temp = new int[26];
        char[] c = s.toLowerCase().toCharArray();
        for (char x : c) {
            temp[x - 'a']++;
        }
        for (int x : temp) {
            if (x > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAllUniqueChar("ABCDE") ? "Unique" : "Not Unique");
        System.out.println(hasAllUniqueChar("ABCDA") ? "Unique" : "Not Unique");
        System.out.println(hasAllUniqueChar("aBCdE") ? "Unique" : "Not Unique");
    }
}
