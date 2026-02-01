package searching;

import java.util.Random;

public class RandomNumber {

  public static void main(String[] args) {
    System.out.println(new Random().nextInt(1));
    System.out.println(new Random().nextInt(1, 10));
  }
}
