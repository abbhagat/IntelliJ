package arrays;

public class FirstNonRepeatingChar {
  public static void main(String[] args) {
    char[] a = "aaabbbccddddefffgghhhiiijjjkkklmnooopppp".toCharArray();
    int[] temp = new int[128];
    for (char c : a) {
      temp[c]++;
    }
    for (char c : a) {
      if (temp[c] == 1) {
        System.out.println(c);
      }
    }
  }
}
