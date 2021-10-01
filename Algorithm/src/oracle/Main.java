package oracle;

// Given input n stairs and i need to take 1 step or 2 step at a time

// 3 -> 1 + 1 + 1,  1 + 2, 2 +1

// 4 ->   [1+1+1+1] [1 + 2 + 1] [ 1+1+2] [2+2] [2,1,1], [


public class Main {

    private static int countWays(int n){
        switch (n){
            case 1 : return 1;
            case 2 : return 2;
            default: return countWays(n - 1) + countWays(n - 2);
        }
    }



    public static void main(String[] args) {
        int n = 1;
        System.out.println(countWays(n));
    }
}
