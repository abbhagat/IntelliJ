package strings;

public class KDistanceApartString {

    public static void main(String[] args) {
        String s1 = "Ping";
        String s2 = "Paging";
        int[] temp = new int[128];
        for (char c : s1.toCharArray()) {
            temp[c]++;
        }
        for (char c : s2.toCharArray()) {
            temp[c]--;
        }
        int count = 0;
        for (int i = 0; i < 128; i++) {
            if (temp[i] != 0) {
                count++;
            }
        }
        System.out.println(s1 + " and " + s2 + " are " + count + " distance apart.");
    }
}
