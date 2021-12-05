package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class FormSmallestNumberFromGivenArray {

    public static String smallestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        int countZero = 0;
        for (int x : nums) {
            list.add(Integer.toString(x));
            if (x == 0) {
                countZero++;
            }
        }
        if (countZero == nums.length) {
            return "0";
        }
        list.sort((x, y) -> (x + y).compareTo(y + x));
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
