package strings;

public class CreateStringByRemovingEmptySpacesFromCharArray {

    public static void main(String[] args) {
        String str = " abc d e    f ghi  j  k ";
        for (char x : str.trim().toCharArray()) {
            if (x != ' ') {
                System.out.print(x);
            }
        }
    }
}
