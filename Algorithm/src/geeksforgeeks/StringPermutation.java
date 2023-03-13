package geeksforgeeks;

public class StringPermutation {

    public static boolean checkInclusion(char[] c1, char[] c2) {
        if (c1.length > c2.length) {
            return false;
        }
        int[] c1Data = new int[26];
        int[] c2Data = new int[26];
        for (int i = 0; i < c1.length; i++) {
            c1Data[c1[i] - 'a']++;
            c2Data[c2[i] - 'a']++;
        }
        for (int i = 0, j = c1.length; j < c2.length; i++, j++) {
            if (matches(c1Data, c2Data)) {
                return true;
            }
            c2Data[c2[j] - 'a']++;
            c2Data[c2[i] - 'a']--;
        }
        return matches(c1Data, c2Data) ? true : false;
    }

    public static boolean matches(int[] c1Data, int[] c2Data) {
        for (int i = 0; i < 26; i++) {
            if (c1Data[i] != c2Data[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("cat".toCharArray(), "retract".toCharArray()));
    }
}
