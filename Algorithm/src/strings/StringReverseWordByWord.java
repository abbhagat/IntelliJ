package strings;

public class StringReverseWordByWord {

  public static void main(String[] args) {
    String str = "Java is an OOP";
    for (String s : str.split(" ")) {
      char[] c = s.toCharArray();
      for (int i = 0, j = c.length - 1; i < j; i++, j--) {
        c[i] = (char) (c[i] ^ c[j]);
        c[j] = (char) (c[i] ^ c[j]);
        c[i] = (char) (c[i] ^ c[j]);
      }
      System.out.print(c);
    }
  }
}
