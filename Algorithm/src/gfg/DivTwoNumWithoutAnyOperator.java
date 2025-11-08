package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

//Time  Complexity: O(x/y)
//Space Complexity: O(x/y)
public class DivTwoNumWithoutAnyOperator {

    private static void divide(int x, int y) {
        int q = 0;
        while (x >= y) {
            x = sub(x, y);
            q++;
        }
        System.out.println("Quotient  :" + q);
        System.out.println("Remainder :" + x);
    }

    private static int sub(int x, int y) {
        return y == 0 ? x : sub(x ^ y, (~x & y) << 1);
    }

    private static void divide(int x, int y, int c) {
        if (x >= y) {
            divide(sub(x, y), y, ++c);
            return;
        }
        System.out.println("Quotient  :" + c);
        System.out.println("Remainder :" + x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of x and y ");
        int x = Integer.parseInt(R.readLine());
        int y = Integer.parseInt(R.readLine());
        divide(max(x, y), min(x, y));
        divide(max(x, y), min(x, y), 0);
    }
}
