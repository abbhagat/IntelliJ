package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class MaxPossibleSumOfValuesInGraph {
    static int sum;

    static void depthFirst(int v, List<List<Integer>> graph, boolean[] visited, List<Integer> values) {
        visited[v] = true;
        sum += values.get(v - 1);
        System.out.println(sum);
        for (int i : graph.get(v - 1)) {
            if (!visited[i]) {
                depthFirst(i, graph, visited, values);
            }
        }
    }

    static void maximumSumOfValues(List<List<Integer>> graph, int vertices, List<Integer> values) {
        boolean[] visited = new boolean[values.size() + 1];
        int maxValueSum = Integer.MIN_VALUE;
        for (int i = 1; i < vertices; i++) {
            if (!visited[i]) {
                sum = 0;
                depthFirst(i, graph, visited, values);
                if (sum > maxValueSum) {
                    maxValueSum = Math.max(maxValueSum, sum);
                }
            }
        }
        System.out.print("Max Sum value = " + maxValueSum);
    }

    public static void main(String[] args) {
        int N = 5;
        int[] A = {2, 2, 1, 2};
        int[] B = {1, 3, 4, 4};

        List<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(4);
        values.add(3);
        values.add(2);
        values.add(1);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            graph.add(new ArrayList<>());
            graph.get(i).add(A[i]);
            graph.get(i).add(B[i]);
        }
        maximumSumOfValues(graph, N, values);
    }
}
