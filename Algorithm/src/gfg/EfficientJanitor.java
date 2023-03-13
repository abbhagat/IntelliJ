package gfg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EfficientJanitor {

    private static int efficientJanitor(List<Float> weight) {
        Collections.sort(weight);
        int low = 0, high = weight.size() - 1, trips = 0;
        while (low <= high) {
            if (low == high) {
                trips++;
                break;
            }
            if (weight.get(low) + weight.get(high) <= 3.0f) {
                trips++;
                low++;
                high--;
            } else {
                trips++;
                high--;
            }
        }
        return trips;
    }

    public static void main(String[] args) {
        System.out.println(efficientJanitor(Arrays.asList(1.01f, 1.99f, 2.5f, 1.5f, 1.01f)));
    }
}
