package oracle;

public class ReplaceAllSpacesInAStringWithPercentage {

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for (char x : "Java is an OOP.".toCharArray()) {
            s.append(x != ' ' ? x : "%20");
        }
        System.out.println(s);
    }
}
