package arrays;

import java.util.BitSet;

public class BitSetDemo {

  private final BitSet bitSet = new BitSet(100000);

  public void addTelephoneNumber(int number) {
    bitSet.set(number);
  }

  public void removeTelephoneNumber(int number) {
    if (bitSet.get(number)) {
      bitSet.flip(number);
    }
  }

  public boolean isNumberPresent(int number) {
    return bitSet.get(number);
  }

  public static void main(String[] args) {
    BitSetDemo d = new BitSetDemo();
    d.addTelephoneNumber(12345);
    System.out.println(d.isNumberPresent(12345));
    d.removeTelephoneNumber(12345);
    System.out.println(d.isNumberPresent(12345));
  }
}
