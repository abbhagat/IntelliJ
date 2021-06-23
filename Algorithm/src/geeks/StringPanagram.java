package geeks;

public class StringPanagram {

    public static void main(String[] args) {
        String s = "ABCDEFGhi^&#jKLMNO!@$%PQRSTUvwxyz";
        int[] temp = new int[26];
        boolean isPanagram = true;
        for (char c : s.toUpperCase().toCharArray()) {
            if (c >= 65 && c <= 90) {
                temp[c - 65]++;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                isPanagram = false;
                break;
            }
        }
        System.out.println(isPanagram ? "Panagram" : "Not Panagram");
    }
}
