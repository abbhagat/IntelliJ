package geeksforgeeks;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class StringPermutation {

    public static boolean checkInclusion(char[] c1, char[] c2) {
        if (c1.length > c2.length) {
            return false;
        }
        int[] c1Data = new int[128];
        int[] c2Data = new int[128];
        for (int i = 0; i < c1.length; i++) {
            c1Data[c1[i]]++;
            c2Data[c2[i]]++;
        }
        if (matches(c1Data, c2Data)) {
            return true;
        }
        for (int i = 0, j = c1.length; j < c2.length; i++, j++) {
            c2Data[c2[j]]++;
            c2Data[c2[i]]--;
            if (matches(c1Data, c2Data)) {
                return true;
            }
        }
        return matches(c1Data, c2Data);
    }

    public static boolean matches(int[] c1Data, int[] c2Data) {
        for (int i = 0; i < 128; i++) {
            if (c1Data[i] != c2Data[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("cat".toCharArray(), "retract".toCharArray()));
        System.out.println(checkInclusion("cat".toCharArray(), "tacretw".toCharArray()));
    }
}
