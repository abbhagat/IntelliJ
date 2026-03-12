package jpmorgan;

public class ConvertSnakeCaseStringToCamelCase {

  private static StringBuilder convert(String str) {
    StringBuilder sb = new StringBuilder();
    boolean capitalizeNext = false;
    for (char c : str.toCharArray()) {
      if (c == '_') {
        capitalizeNext = true;
      } else if (capitalizeNext) {
        c = Character.toUpperCase(c);
        sb.append(c);
        capitalizeNext = false;
      } else {
        sb.append(c);
      }
    }
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(convert("geeksforgeeks"));            // geeksforgeeks
    System.out.println(convert("geeks_for_geeks"));          // geeksForGeeks
    System.out.println(convert("geeks_for_geeks"));          // geeksForGeeks
    System.out.println(convert("snake_case_to_camel_case")); // snakeCaseToCamelCase
  }
}
