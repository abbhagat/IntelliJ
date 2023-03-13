package recursion;

public class HCF {

    private static int findHCF(int x, int y) {
        return y == 0 ? x : findHCF(y, x % y);
    }

    public static void main(String[] args) {
        int[] a = {10, 150, 30, 50, 40, 60};
        int hcf = a[0];
        for (int i = 1; i < a.length; i++) {
            hcf = findHCF(hcf, a[i]);
        }
        System.out.println("HCF := " + hcf);
        System.out.println(findHCF(0,5));
    }
}
