package corejava;

class XYZ {

    private int x;

    static class xyz {
        private int x = 10;
    }

    class pqr {
        int y = 100;
    }
}

public class SwitchCaseDemo {
    public static void main(String[] args) {
        XYZ X = new XYZ();
        XYZ.pqr P = X.new pqr();
        //XYZ.xyz x = X.new xyz(); // error
        XYZ.xyz x = new XYZ.xyz();
    }
}
