package arrays;

public class RemoveDuplicatesInCharArray {

    private char[] a = {'A', 'B', 'B', 'C', 'D', 'E', 'R', 'R', 'D'};
    private int[] temp = new int[128];

    void removeDuplicate() {
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
        RemoveDuplicatesInCharArray array = new RemoveDuplicatesInCharArray();
        array.removeDuplicate();
    }
}
