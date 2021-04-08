package jpmorgan;

public class ToBinaryFromDecimalWithFractionPart {

    static StringBuilder toBinary(String s) {

        int idx = s.indexOf('.');
        int x = Integer.parseInt(s.substring(0, idx));
        int y = Integer.parseInt(s.substring(idx + 1, s.length()));

        StringBuilder sb = new StringBuilder("");
        while (x != 0) {
            sb.append(x % 2);
            x /= 2;
        }
        sb.reverse();
        sb.append(".");
        while (y != 0) {
            sb.append(y % 2);
            y /= 2;
        }
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(toBinary("12.12"));
    }
}
