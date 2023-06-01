package amazon;

/*
  I/P :- int[] a = { 4, 3, 2, 0, 1 }; char[] c = { 'e', 'd', 'c', 'a', 'b' };
  O/P :- int[] a = { 0, 1, 2, 3, 4 }; char[] c = { 'a', 'b', 'c', 'd', 'e' };
  Both the array has to be sorted in O(n).
 */

// Time  Complexity  O(n)
public class SortinginBigO_n {

    private static void swap(int i, int j, int[] a) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void swap(int i, int j, char[] c) {
        char x = c[i];
        c[i] = c[j];
        c[j] = x;
    }

    private static void sort(int[] pos, char[] chars) {
        int i = 0;
        while (i < chars.length) {
            if (i != pos[i]) {
                swap(i, pos[i], chars);
                swap(i, pos[i], pos);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 0, 1};
        char[] c = {'e', 'd', 'c', 'a', 'b'};
        sort(a, c);
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (char x : c) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
