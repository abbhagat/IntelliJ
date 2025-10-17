package leetcode;

// Time Complexity : O(n)
public class PrintMissingRangeInSortedArray {

    private static void printMissingRange(int[] a) {
        for (int i = 1; i < a.length; i++) {
             int n = a[i] - a[i - 1];
             switch (n) {
                case 1 : continue;
                case 2 : System.out.println(a[i - 1] + 1); break;
                case 3 : System.out.println(a[i - 1] + 1 + " " + (a[i] - 1)); break;
                default: System.out.println(a[i - 1] + 1 + "-" + (a[i] - 1));
             }
        }
    }

    public static void main(String[] args) {
        printMissingRange(new int[]{1, 2, 4, 7, 9, 10, 11, 15});
        System.out.println();
        printMissingRange(new int[]{2, 3, 4, 6, 9, 10});
        System.out.println();
        printMissingRange(new int[]{1, 2, 30, 33, 45, 60, 91, 910, 1100, 1500});
    }
}
