package recursion;

/**
 * There are n people standing in a circle waiting to be executed.
 * The counting out begins at some point in the circle and proceeds around the circle in a fixed direction.
 * In each step, a certain number of people are skipped and the next person is executed.
 * The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed),
 * until only the last person remains, who is given freedom.
 * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle.
 * The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
 * For example, if n = 5 and k = 2, then the safe position is 3.
 * Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed.
 * Finally, the person at position 5 is killed. So the person at position 3 survives.
 * If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, 1 are killed in order, and the person at position 4 survives.
 * josephus(n, k) = (josephus(n - 1, k) + k-1) % n + 1
 * josephus(1, k) = 1
 * After the first person (kth from the beginning) is killed, n-1 persons are left.
 * So we call josephus(n – 1, k) to get the position with n-1 persons.
 * But the position returned by josephus(n – 1, k) will consider the position starting from k%n + 1.
 * So, we must make adjustments to the position returned by josephus(n – 1, k).
 */
public class JosephusProblem {

  private static int josephus(int n, int k) {
    return n == 1 ? 1 : (josephus(n - 1, k) + k - 1) % n + 1;
  }

  private static int josephusItr(int n, int k) {
    int res = 0;
    for (int i = 1; i <= n; i++) {
      res = (res + k) % i;
    }
    return res + 1;
  }

  public static void main(String[] args) {
    System.out.println(josephus(5, 2)  + "\t" + josephusItr(5,  2));
    System.out.println(josephus(6, 3)  + "\t" + josephusItr(6,  3));
    System.out.println(josephus(14, 2) + "\t" + josephusItr(14, 2));
  }
}
