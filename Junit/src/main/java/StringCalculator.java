public class StringCalculator {

    public static int invoke(String str, String delimeter) {
        if (str.isEmpty()) {
            return 0;
        }
        String[] listOfNum = str.split(delimeter);
        if (listOfNum.length > 2) {
            throw new RuntimeException();
        }
        int sum = 0;
        for (String s : listOfNum) {
            int x = Integer.parseInt(s);
            if (x < 0) {
                throw new RuntimeException();
            }
            if (x <= 1000) {
                sum += x;
            }
        }
        return sum;
    }
}
