package paypal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static java.lang.Integer.max;

public class HurrySolution {

    public static int maxTasksInTheGivenBudget(int[][] tasks, int t) {
        Arrays.sort(tasks, Comparator.comparingInt(x -> x[0]));
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0, max = 0;
        for (int[] task : tasks) {
            sum += task[1];
            list.add(-task[1]);
            int time = 2 * task[0];
            while (!list.isEmpty() && sum + time > t) {
                sum += list.getFirst();
                list.removeFirst();
            }
            max = max(max, list.size());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxTasksInTheGivenBudget(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}}, 13));
    }
}
