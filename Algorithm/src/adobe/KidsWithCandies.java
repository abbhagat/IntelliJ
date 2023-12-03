package adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandy) {
        int maxCandy = Arrays.stream(candies).reduce(Integer.MIN_VALUE, Integer::max);
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandy >= maxCandy);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 2));
    }
}
