package strings;

public class CreateStringByRemovingEmptySpacesFromCharArray {

    private static StringBuilder removeEmptyChar(String str) {
        StringBuilder sb = new StringBuilder();
        for (char x : str.trim().toCharArray()) {
            if (x != ' ') {
                sb.append(x);
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(removeEmptyChar(" abc d e    f ghi  j  k "));
    }
}
