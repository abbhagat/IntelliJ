package serialize;

import java.io.IOException;

public class TryQuestion {

    private static String s;

    private TryQuestion() {
        s = "XYZ";
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new TryQuestion();
        System.out.println(s);
    }
}
