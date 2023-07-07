package arrays;

public class RemoveDuplicatesInCharArray {

    private static void removeDuplicate() {
        final char[] a = {'A', 'B', 'B', 'C', 'D', 'E', 'R', 'R', 'D'};
        int[] temp = new int[128];
        for (char c : a) {
            temp[c]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 1) {
                System.out.print((char) (i));
            }
        }
    }

    public static void main(String[] args) {
        removeDuplicate();
    }
}
