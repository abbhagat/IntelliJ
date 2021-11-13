package cisco;

public class MaxProfit {

    public static void main(String[] args) {
        int[] a = {6, 2, 4, 7, 1};
        int buying = 0, selling = -a[0];
        for(int i = 1; i < a.length; i++){
            buying = Math.max(buying, selling + a[i]);
            selling = Math.max(selling, buying - a[i]);
        }
        System.out.println(buying);
    }
}
