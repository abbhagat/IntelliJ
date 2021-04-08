package samsung;

public class ArrayMulOtherThanOwnPosition {

    public static void main(String[] args) {
        int a[] = { 2, 4, 3, 5, 6 };
        int mul = 1;
        for (int i : a) {
            mul *= i;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = mul / a[i];
        }
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
