package geeks;

public class StringSplitProblem {

    public static void main(String[] args) {
        String s1 = "spqrstrupvsqw";
        String s2 = "sprt";
        String s3 = "q";
        String[] str = s1.split(s3);
        boolean flag = false;
        for (String s : str) {
            if (s.length() < s2.length()) {
                continue;
            }
            int[] temp = new int[128];
            for (char c : s.toCharArray()) {
                temp[c]++;
            }
            for (int i = 0; i < s2.length(); i++) {
                flag = temp[s2.charAt(i)] != 0;
            }
            if (flag) {
                System.out.println(s);
            }
        }
    }
}
