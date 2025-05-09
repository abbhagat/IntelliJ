package jpmorgan;

public class ConvertSnakeCaseStringToCamelCase {

    private static String convert(String str) {
        str = str.substring(0, 1).toLowerCase() + str.substring(1);
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '_') {
                sb.deleteCharAt(i);
                sb.replace(i, i + 1, String.valueOf(sb.charAt(i)).toUpperCase());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("geeks_for_geeks"));
        System.out.println(convert("Geeks_for_geeks"));
        System.out.println(convert("snake_case_to_camel_case"));
    }
}
