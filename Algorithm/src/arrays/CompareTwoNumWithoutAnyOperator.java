package amazon;

public class CompareTwoNumWithoutAnyOperator {

    private static boolean isEqual(int x, int y) {
        boolean[] flag = new boolean[1];
        try {
            flag[x ^ y] = true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        System.out.println(isEqual(x, y) ? "Equal" : "Not Equal");
        System.out.println((x ^ y) == 0  ? "Equal" : "Not Equal");
    }
}
