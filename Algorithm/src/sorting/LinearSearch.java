package sorting;

public class LinearSearch {

    public static void main(String[] args) {
        int[] a = { 20, 3, 15, 15, 15, 6, 9, 8, 2, 1 };
        int n = 15;
        boolean flag = false;
        for (int x : a) {
            if (x == n) {
                System.out.println("Present");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Not Present");
        }
    }
}
