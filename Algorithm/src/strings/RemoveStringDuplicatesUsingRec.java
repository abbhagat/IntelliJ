package strings;

public class RemoveStringDuplicatesUsingRec {

    private static final int[] temp = new int[128];

    private static void removeDuplicates(char[] c, int i) {
        if (i < c.length) {
            temp[c[i]]++;
            removeDuplicates(c, ++i);
        }
    }

    public static void main(String[] args) {
        char[] c = "JavavavaJi".toCharArray();
        removeDuplicates(c, 0);
        for (char x : c) {
            if (temp[x] >= 1) {
                System.out.print(x);
                temp[x] = 0;
            }
        }
        System.out.println();
    }

}
