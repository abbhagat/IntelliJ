package adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMinPathSumFromTopToBottom {

    private static int minPathSum(List<List<Integer>> triangle) {
        System.out.println(triangle);
        List<Integer> list = new ArrayList<>();
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int result = Integer.min(list.get(j), list.get(j + 1) + triangle.get(i).get(j));
                list.set(j, result);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(Arrays.asList(List.of(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
    }
}
