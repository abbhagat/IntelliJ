package arrays;

import java.util.stream.IntStream;

public class ArrayDelete3rdElement {

    private static int[] n = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private static int size = n.length;

    void deleteElement(int pos) {
        for (int i = pos; i < size - 1; i++) {
            n[i] = n[i + 1];
        }
        size--;
    }

    public static void main(String[] args) {
        ArrayDelete3rdElement a = new ArrayDelete3rdElement();
        int pos = 3;
        for (int i = --pos; i < a.size; i += pos) {
            a.deleteElement(i);
        }
        IntStream.range(0, size).forEach(i -> System.out.print(n[i] + " "));
        System.out.println();
    }
}
