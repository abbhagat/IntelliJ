package strings;


// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
public class HammingDistance {

    private static int hammingDistance(String s1, String s2) {
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

    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance("geeksforgeeks", "geeksandgeeks"));
        System.out.println(hammingDistance("1011101", "1001001"));
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(3, 1));
    }
}
