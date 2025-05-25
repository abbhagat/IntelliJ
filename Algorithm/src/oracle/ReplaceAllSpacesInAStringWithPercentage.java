package oracle;

public class ReplaceAllSpacesInAStringWithPercentage {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (char x : "Java is an OOP.".toCharArray()) {
            sb.append(x == ' ' ? "%20" : x);
        }
        System.out.println(sb);
    }
}
