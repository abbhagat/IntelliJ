package jpmorgan;

public class ConvertSnakeCaseStringToCamelCase {

  private static StringBuilder convert(String str) {
    StringBuilder sb = new StringBuilder();
    boolean flag = false;
    for (char c : str.toCharArray()) {
      if (Character.isAlphabetic(c)) {  // Add  (|| c == '_') to include '_' in output
        if (sb.isEmpty()) {
          c = Character.toLowerCase(c);
        } else if (flag) {
          c = Character.toUpperCase(c);
          flag = false;
        }
        sb.append(c);
      } else if (!sb.isEmpty()) {
        flag = true;
      }
    }
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(convert("geeksforgeeks"));                  // geeksforgeeks
    System.out.println(convert("geeks_for_geeks"));                // geeksForGeeks
    System.out.println(convert("Geeks_for_geeks"));                // geeksForGeeks
    System.out.println(convert("snake_case_to_camel_case"));       // snakeCaseToCamelCase
    System.out.println(convert("_snake_case_to_camel_case"));      // snakeCaseToCamelCase
    System.out.println(convert("_%$snake_case_to_camel_case"));    // snakeCaseToCamelCase
    System.out.println(convert("_%$snake_case_%^to_camel_case"));  // snakeCaseToCamelCase
    System.out.println(convert("_%$Snake_case_%^to_camel_case"));  // snakeCaseToCamelCase
  }
}
