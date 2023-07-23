package vmware;

public class ReverseWordsInString {

    private static String reverseWords(String str) {
        StringBuilder sb = new StringBuilder();
        String[] a = str.trim().split(" ");
        for (int i = a.length - 1; i >= 0; i--) {
            if (!a[i].isEmpty()) {
                sb.append(a[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
