package geeks;

public class StringPanagram {

    private static boolean isPanagram(String s) {
        int[] temp = new int[26];
        for (char c : s.toUpperCase().toCharArray()) {
            if (c >= 65 && c <= 90) {
                temp[c - 65]++;
            }
        }
        for (int x : temp) {
            if (x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPanagram("ABCDEFGhi^&#jKLMNO!@$%PQRSTUvwxyz") ? "Panagram" : "Not Panagram");
    }
}
