package oracle;

public class ReplaceAllSpacesInAStringWithPercentage {

    public static void main(String[] args) {
        String s = "";
        for (char x : "Java is an OOP . ".toCharArray()) {
            s += (x != ' ') ? x : "%20";
        }
        System.out.println(s);
    }
}
