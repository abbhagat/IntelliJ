package cisco;

public class PerfectSubstring {

    private static boolean checkPerfectSubstring(int[] a, int k) {
        for (int x : a) {
            if (x != 0 && x != k) {
                return false;
            }
        }
        return true;
    }

    public static int perfectSubstring(String s, int k) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] a = new int[10];
            for (int j = i; j < s.length(); j++) {
                if (j > i + (10 * k)) {
                    break;
                }
                char ch = s.charAt(j);
                a[ch - '0']++;
                if (checkPerfectSubstring(a, k)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(perfectSubstring("1102021222", 2));
    }
}
