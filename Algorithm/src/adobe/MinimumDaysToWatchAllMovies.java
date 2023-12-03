package adobe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDaysToWatchAllMovies {

    public static int findMinimumDays(List<Float> list) {
        Collections.sort(list);
        int i = 0, j = list.size() - 1, count = 0;
        while (i < j) {
            if (list.get(i) + list.get(j) <= 3.0f) {
                count++;
                i++;
                j--;
            } else {
                count++;
                j--;
            }
            if (i == j && list.get(i) <= 3.0f) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumDays(new ArrayList<>(List.of(1.94f, 2.5f, 1.25f, 1.01f, 1.75f))));
    }
}
