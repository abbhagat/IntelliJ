package geeks;

public class StringSplitImplementation {

  private static void split(String s, char delimiter) {
    StringBuilder sb = new StringBuilder();
    for (char c : (s + delimiter).toCharArray()) {
      if (c != delimiter) {
        sb.append(c);
      } else {
        System.out.println(sb);
        sb.setLength(0);
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    split("Java is an OOP", ' ');
    split("Java, s;is;r an;w OOP", ';');
  }
}
