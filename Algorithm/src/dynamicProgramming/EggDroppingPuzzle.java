package dynamicProgramming;

public class EggDroppingPuzzle {

    private static int eggDrop(int eggs, int floor) {
        if (floor == 0 || floor == 1) {
            return floor;
        }
        if (eggs == 1) {
            return floor;
        }
        int mid = (floor + 1) / 2;
        return 1 + (floor - mid > mid - 1 ? eggDrop(eggs, floor - mid) : eggDrop(eggs - 1, mid - 1));
    }

    public static void main(String args[]) {
        System.out.println(eggDrop(2, 10));
        System.out.println(eggDrop(2, 36));
        System.out.println(eggDrop(2, 100));
    }
}
