package sorting;

//import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        int i;
        for (i = 1; i <= 100; i++) {
            int n = (int)(Math.nextUp(i));
            System.out.println(n);
        }
    }
}
