package strings;

public class CreateStringByRemovingEmptySpacesFromCharArray {

    public static void main(String[] args) {

        String str = " abc d e    f ghi  j  k ";
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] != ' ') {
                System.out.print(c[i]);
            }
        }
        System.out.println();
        for (char x : str.toCharArray()) {
            if (x != ' ') {
                System.out.print(x);
            }
        }
        System.out.println();
    }
}
