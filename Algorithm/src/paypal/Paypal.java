package paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Paypal {

    public static void main(String[] args) throws IOException {
        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(R.readLine());
        int m = Integer.parseInt(R.readLine());
        String s = R.readLine();
        System.out.println(m + "\t" + n + "\t" + s);
    }
}
