package paypal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class HurrySoln {

    public static int maxTasksInTheGivenBudget(int[][] tasks, int t) {
        Arrays.sort(tasks, Comparator.comparingInt(x -> x[0]));
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0, ans = 0;
        for (int[] task : tasks) {
            sum += task[1];
            list.add(-task[1]);
            int time = 2 * task[0];
            while (!list.isEmpty() && sum + time > t) {
                sum += list.getFirst();
                list.removeFirst();
            }
            ans = Integer.max(ans, list.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        // maxTasksInTheGivenBudget();
    }
}
