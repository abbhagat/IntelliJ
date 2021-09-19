package cisco;

import java.util.Arrays;
import java.util.List;

public class ThrottlingGateway {

    public static int droppedRequests(List<Integer> requestTime) {
        int result = 0;
        for (int i = 0; i < requestTime.size(); i++) {
            if (i > 2 && requestTime.get(i) == requestTime.get(i - 3)) {
                result++;
            } else if (i > 19 && (requestTime.get(i) - requestTime.get(i - 20) < 10)) {
                result++;
            } else if (i > 59 && (requestTime.get(i) - requestTime.get(i - 60) < 60)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(droppedRequests(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11)));
    }
}
