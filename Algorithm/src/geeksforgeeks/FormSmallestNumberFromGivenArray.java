package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class FormSmallestNumberFromGivenArray {

    public static String smallestNumber(int[] a) {
        List<String> list = new ArrayList<>();
        int countZero = 0;
        for (int x : a) {
            list.add(Integer.toString(x));
            if (x == 0) {
                countZero++;
            }
        }
        if (countZero == a.length) {
            return "0";
        }
        list.sort((x, y) -> (x + y).compareTo(y + x));
        StringBuilder result = new StringBuilder();
        list.forEach(result::append);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(smallestNumber(new int[]{0, 1, 2, 3, 4}));
        System.out.println(smallestNumber(new int[]{4, 5, 0, 8}));
        System.out.println(smallestNumber(new int[]{542, 60}));
    }
}
