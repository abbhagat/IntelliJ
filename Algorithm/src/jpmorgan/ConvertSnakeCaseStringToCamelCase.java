package jpmorgan;

public class ConvertSnakeCaseStringToCamelCase {

  private static StringBuilder convert(String str) {
    StringBuilder sb = new StringBuilder();
    boolean capitalizeNext = false;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (Character.isAlphabetic(c)) {
        if (sb.isEmpty()) {
          c = Character.toLowerCase(c);
        } else if (capitalizeNext) {
          c = Character.toUpperCase(c);
          capitalizeNext = false;
        }
        sb.append(c);
      } else if (!sb.isEmpty()) {
        capitalizeNext = true;
      }
    }
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(convert("geeks_for_geeks"));                      // geeksForGeeks
    System.out.println(convert("Geeks_for_geeks"));                     //  geeksForGeeks
    System.out.println(convert("snake_case_to_camel_case"));           //   snakeCaseToCamelCase
    System.out.println(convert("_snake_case_to_camel_case"));         //    snakeCaseToCamelCase
    System.out.println(convert("_%$snake_case_to_camel_case"));      //     snakeCaseToCamelCase
    System.out.println(convert("_%$snake_case_%^to_camel_case"));   //      snakeCaseToCamelCase
    System.out.println(convert("_%$Snake_case_%^to_camel_case"));   //      snakeCaseToCamelCase
  }
}
