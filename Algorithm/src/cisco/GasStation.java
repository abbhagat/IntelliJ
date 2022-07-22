package cisco;

public class GasStation {
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int restGas = 0, prev = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            restGas += gas[i] - cost[i];
            if (restGas < 0) {
                prev += restGas;
                restGas = 0;
                start = i + 1;
            }
        }
        return prev + restGas >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
