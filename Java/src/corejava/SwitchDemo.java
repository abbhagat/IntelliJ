package corejava;

interface I1 {
    int x = 10;
}

public class SwitchDemo {
    // final int y;

    public static void main(String[] args) {
        char c = 'A';
        // final int y, x = 10;
        // y= 90;
        switch (c) {
        case 65:
            System.out.println("Hello");
        default:
            System.out.println("Default");
            break;
        case 1:
            System.out.println(c);
        }
    }
}
