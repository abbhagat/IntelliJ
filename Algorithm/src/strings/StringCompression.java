package strings;

public class StringCompression {

  public static StringBuilder stringCompression(String str) {
    char[] c = str.toCharArray();
    StringBuilder sb = new StringBuilder();
    sb.append(c[0]);
    int count = 1;
    for (int i = 1; i < c.length; i++) {
      if (c[i] == c[i - 1]) {
        count++;
      } else {
        sb.append(count);
        sb.append(c[i]);
        count = 1;
      }
    }
    sb.append(count);
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(stringCompression("a"));
    System.out.println(stringCompression("ffilllttteeeeerredd"));
    System.out.println(stringCompression("abbcccddddeaaacc"));
    System.out.println(stringCompression("wwwwaaadexxxxxxq"));
  }
}
