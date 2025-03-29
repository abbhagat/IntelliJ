package oracle;

public class ReplaceAllSpacesInAStringWithPercentage {

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for (char x : "Java is an OOP.".toCharArray()) {
            s.append(x == ' ' ? "%20" : x);
        }
        System.out.println(s);
    }
}
