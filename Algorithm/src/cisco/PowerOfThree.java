package cisco;

import static java.lang.Math.log10;

public class PowerOfThree {

    private static boolean isPowerOfThree(int n){
        return (log10(n) / log10(3)) % 1 == 0;
    }

    private static boolean isPowerOf3(int n){
        if(n < 1){
            return false;
        }
        while (n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfThree(2) + " " + isPowerOf3(2));
        System.out.println(isPowerOfThree(3) + " " + isPowerOf3(3));
        System.out.println(isPowerOfThree(6) + " " + isPowerOf3(6));
        System.out.println(isPowerOfThree(9) + " " + isPowerOf3(9));
        System.out.println(isPowerOfThree(81) + " " + isPowerOf3(81));
    }
}
