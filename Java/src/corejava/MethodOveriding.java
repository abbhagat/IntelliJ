package corejava;

import java.io.IOException;

class P {
    private P display(int x) throws IOException {
        return null;
    }
}

class Q extends P {
    int display(int x, int y) {
        return 1;
    }
}

public class MethodOveriding {
    public static void main(String[] args) {
        P p = new Q();
        //p.display(10,20);  // Error
        Q q = new Q();
        q.display(10, 20); // Error if method is declared as private
        System.out.println(Double.NaN == Double.NaN);
    }
}
