package geeksforgeeks;

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
        int windowStart = 0;
        int windowEnd = c1.length;
        while (windowEnd < c2.length) {
            if (matches(c1Data, c2Data)) {
                return true;
            }
            c2Data[c2[windowEnd]]++;
            c2Data[c2[windowStart]]--;
            windowStart++;
            windowEnd++;
        }
        return matches(c1Data, c2Data) ? true : false;
    }

    public static boolean matches(int[] c1Data, int[] c2Data) {
        for (int i = 0; i < 127; i++) {
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
