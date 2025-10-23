package jpmorgan;

public class ConvertSnakeCaseStringToCamelCase {

  private static StringBuilder convert(String str) {
    StringBuilder sb = new StringBuilder(str);
    sb.replace(0, 1, String.valueOf(sb.charAt(0)).toLowerCase());
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '_') {
        sb.deleteCharAt(i);
        sb.replace(i, i + 1, String.valueOf(sb.charAt(i)).toUpperCase());
      }
    }
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(convert("geeks_for_geeks"));             // geeksForGeeks
    System.out.println(convert("Geeks_for_geeks"));            //  geeksForGeeks
    System.out.println(convert("snake_case_to_camel_case"));  //   snakeCaseToCamelCase
  }
}
