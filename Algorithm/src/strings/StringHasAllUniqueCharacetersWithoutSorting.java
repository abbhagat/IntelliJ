package strings;

public class StringHasAllUniqueCharacetersWithoutSorting {

    static boolean hasAllUniqueChars(String s) {
        int[] a = new int[128];
        for (char x : s.toCharArray()) {
            a[x]++;
        }
        for (int x : a) {
            if (x > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAllUniqueChars("ABCDEF") ? "All characters Unique" : "All characters not Unique");
    }
}
