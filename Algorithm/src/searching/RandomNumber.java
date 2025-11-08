package searching;

//import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            int n = (int) (Math.nextUp(i));
            System.out.println(n);
        }
    }
}
