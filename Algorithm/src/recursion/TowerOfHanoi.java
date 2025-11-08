package recursion;

// Time  Complexity: O(2^n)
// Space Complexity: O(n)
public class TowerOfHanoi {

    private static void towerOfHanoi(String src, String aux, String dest, int n) {
        if (n == 1) {
            System.out.println(src + " -> " + dest);
            return;
        }
        towerOfHanoi(src, dest, aux, n - 1);
        System.out.println(src + " -> " + dest);
        towerOfHanoi(aux, src, dest, n - 1);
    }

    public static void main(String[] args) {
        towerOfHanoi("A", "B", "C", 2);
        System.out.println("------------------");
        towerOfHanoi("A", "B", "C", 3);
    }
}
