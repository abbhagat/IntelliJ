package cisco;

public class IntegerReplacement {

    private static int minIntReplacement(int n){
        if(n == Integer.MAX_VALUE){
            return 32;
        }
        int c = 0;
        while (n > 1){
            if(n % 2 == 0){
                n /=2;
            }else {
                n += ((n+1)%4 == 0 && (n-1 != 2)) ? 1 : -1;
            }
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(minIntReplacement(7));
        System.out.println(minIntReplacement(8));
    }
}
