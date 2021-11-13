package geeks;

public class LargeNumberDivisibleBy11 {

    private static boolean isDivisibleBy11(long n){
        String s = Long.toString(n);
        int oddSum = 0, evenSum = 0;
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 1){
                oddSum  += s.charAt(i) - '0';
            }else{
                evenSum += s.charAt(i) - '0';
            }
        }
        return Math.abs(oddSum - evenSum) % 11 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isDivisibleBy11(76945));
        System.out.println(isDivisibleBy11(1234567589333892L));
    }
}
