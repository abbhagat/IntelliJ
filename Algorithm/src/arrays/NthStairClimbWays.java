package arrays;

public class NthStairClimbWays {

    public static void main(String[] args) {
        System.out.println(stairCount(5));
    }

    private static int stairCount(int n) {
        switch (n){
            case 1 : return 1;
            case 2 : return 2;
            default: return stairCount(n - 1) + stairCount(n - 2);
        }
    }
}
