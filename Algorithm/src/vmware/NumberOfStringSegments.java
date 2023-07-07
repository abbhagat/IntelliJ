package vmware;

public class NumberOfStringSegments {

    private static int findNoOfSegments(String str) {
        if (str.length() == 0) {
            return 0;
        }
//        int count = 0;
//        for (String s : str.trim().split(" ")) {
//            count += s.isEmpty() ? 0 : 1;
//        }
        return str.trim().split(" ").length;
    }

    public static void main(String[] args) {
        System.out.println(findNoOfSegments(""));
        System.out.println(findNoOfSegments("Hello"));
        System.out.println(findNoOfSegments("Hello, my name is John"));
        System.out.println(findNoOfSegments("love live! mu'sic forever"));
    }
}
