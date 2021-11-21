package geeks;

import static java.lang.Math.abs;

public class LargeNumberDivisibleBy11 {

    private static boolean isDivisibleBy11(long n){
        String s = Long.toString(n);
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int k = s.charAt(i) - '0';
            sum += i % 2 == 1 ? k : -k;
        }
        return abs(sum) % 11 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isDivisibleBy11(76945));
        System.out.println(isDivisibleBy11(1234567589333892L));
    }
}
