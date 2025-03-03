package jpmorgan;

public class MinOperationToMakeStringAnagram {

    public static int minOperationToMakeStringAnagram(String s) {
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        int[] temp = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            temp[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            temp[s2.charAt(i)]--;
        }
        int count = 0;
        for (int x : temp) {
            if (x > 0) {
                count += x;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minOperationToMakeStringAnagram("123456"));
    }
}
