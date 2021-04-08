package strings;

public class HammingDistance {

    public static void main(String[] args) {
//        String s1 = "1011101";
//        String s2 = "1001001";
        String s1 = "geeksforgeeks";
        String s2 = "geeksandgeeks";
        int dis = 0;
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    dis++;
                }
            }
            System.out.println("Hamming Distance :" + dis);
        } else {
            System.out.println("String are of unequal length");
        }
    }
}
