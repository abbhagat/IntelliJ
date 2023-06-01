package strings;

public class HammingDistance {
    private static int findHammingDistance(String s1, String s2) {
        int dis = 0;
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    dis++;
                }
            }
            return dis;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findHammingDistance("geeksforgeeks", "geeksandgeeks"));
        System.out.println(findHammingDistance("1011101", "1001001"));
    }
}
