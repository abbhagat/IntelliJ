package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EfficientJanitor {

    private static int efficientJanitor(List<Float> weight) {
        Collections.sort(weight);
        int low = 0, high = weight.size() - 1, trips = 0;
        while (low <= high) {
            if (weight.get(low) + weight.get(high) <= 3.0f) {
                low++;
            }
            high--;
            trips++;
        }
        return trips;
    }

    public static void main(String[] args) {
        System.out.println(efficientJanitor(new ArrayList<>(List.of(1.01f, 1.99f, 2.5f, 1.5f, 1.01f))));
        System.out.println(efficientJanitor(new ArrayList<>(List.of(1.01f))));
    }
}
