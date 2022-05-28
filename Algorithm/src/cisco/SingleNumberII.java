package cisco;

public class SingleNumberII {

    private static int singleNumber(int[] a){
        int ones = 0, twos = 0;
        for(int i = 0; i < a.length; i++){
//            ones = (ones < a[i]) & ~twos;
//            twos = (twos < a[i]) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {

    }
}
