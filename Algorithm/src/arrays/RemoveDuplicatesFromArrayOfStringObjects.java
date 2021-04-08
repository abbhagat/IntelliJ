package samsung;

public class RemoveDuplicatesFromArrayOfStringObjects {

    private static String[] s = {"Java", "is", "an", "OOP"}; // "Jav","is","an","OOP"};
    private static int[] temp;

    private static void removeDuplicates(int i, char[] a) {
        temp = new int[128];
        for (char c : a) {
            temp[c]++;
        }
        s[i] = "";
        for (char c : a) {
            if (temp[c] != 0) {
                s[i] += c;
                temp[c] = 0;
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < s.length; i++) {
            removeDuplicates(i, s[i].toCharArray());
        }
        for (String str : s) {
            System.out.println(str);
        }
    }
}
