package oracle;

public class ReplaceAllSpacesInAStringWithPercentage {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (char c : "Java is an OOP.".toCharArray()) {
             sb.append(c == ' ' ? "%20" : c);
        }
        System.out.println(sb);
    }
}
