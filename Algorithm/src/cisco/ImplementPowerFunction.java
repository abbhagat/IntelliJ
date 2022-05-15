package cisco;

public class ImplementPowerFunction {

    private static double pow(float x, int n){
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        double result = 1;
        for(int i = 0; i < n; i++){
            result *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2.00000f, 10));
        System.out.println(pow(2.10000f, 3));
        System.out.println(pow(2.00000f, -2));
    }
}
