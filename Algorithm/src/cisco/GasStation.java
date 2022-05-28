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

    }
}
