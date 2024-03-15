package geeks;

public class StringSplitProblem {

    public static void main(String[] args) {
        String s1 = "spqrstrupvsqw";
        String s2 = "sprt";
        String s3 = "q";
        String[] str = s1.split(s3);
        boolean flag = true;
        for (String s : str) {
            if (s.length() < s2.length()) {
                continue;
            }
            int[] temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < s2.length(); i++) {
                if (temp[s2.charAt(i) - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(s);
            }
        }
    }
}
