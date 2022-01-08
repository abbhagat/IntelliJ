package amazon;

public class CheckIfBothHalfStringsHaveSameSetOfCharacters {

    private static boolean hasSameSetOfChars(String s) {
        if (s.length() == 1) {
            return true;
        }
        int[] a = new int[26];
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            a[s.charAt(i) - 'a']++;
            a[s.charAt(j) - 'a']--;
        }
        for (int x : a) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasSameSetOfChars("abccab".toLowerCase()));
        System.out.println(hasSameSetOfChars("abbaab".toLowerCase()));
    }
}
