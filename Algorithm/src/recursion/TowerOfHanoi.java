package recursion;

public class TowerOfHanoi {

    private static void towerOfHanoi(int n, String source, String destination, String aux) {
        if (n == 1) {
            System.out.println(source + " --> " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, aux, destination);
        System.out.println(source + " --> " + destination);
        towerOfHanoi(n - 1, aux, destination, source);
    }

    public static void main(String[] args) {
        towerOfHanoi(2, "A", "C", "B");
    }
}
