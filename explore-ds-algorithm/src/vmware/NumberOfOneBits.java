package vmware;

public class NumberOfOneBits {

  private static int numOfOneBit(int n) {
    int count = 0;
    while (n != 0) {
      count++;
      n &= (n - 1);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(numOfOneBit(11));
    System.out.println(numOfOneBit(128));
  }
}
