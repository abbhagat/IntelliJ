package jpmorgan;

public class ConvertCamelCaseStringToSnakeCase {

  private static StringBuilder convert(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (Character.isUpperCase(c)) {
        if (sb.length() != 0) {
          sb.append("_");
        }
        c = Character.toLowerCase(c);
      }
      sb.append(c);
    }
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(convert("GeeksForGeeks"));
    System.out.println(convert("CamelCaseToSnakeCase"));
  }
}
