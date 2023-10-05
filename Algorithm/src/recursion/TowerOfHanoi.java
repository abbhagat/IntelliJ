package recursion;

public class TowerOfHanoi {

    private static void towerOfHanoi(int n, String src, String aux, String dest) {
        if (n == 1) {
            System.out.println(src + " -> " + dest);
        } else {
            towerOfHanoi(n - 1, src, dest, aux);
            System.out.println(src + " -> " + dest);
            towerOfHanoi(n - 1, aux, src, dest);
        }
    }

    public static void main(String[] args) {
        towerOfHanoi(3, "A", "B", "C");
    }
}
