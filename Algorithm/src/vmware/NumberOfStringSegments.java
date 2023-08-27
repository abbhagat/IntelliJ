package vmware;

public class NumberOfStringSegments {
    private static int findNoOfSegments(String str) {
        return str.isEmpty() ? 0 : str.trim().split(" ").length;
    }

    public static void main(String[] args) {
        System.out.println(findNoOfSegments(""));
        System.out.println(findNoOfSegments("Hello"));
        System.out.println(findNoOfSegments("Hello, my name is John"));
        System.out.println(findNoOfSegments("love live! mu'sic forever"));
    }
}
