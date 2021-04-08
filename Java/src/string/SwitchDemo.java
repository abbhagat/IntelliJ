package string;

public abstract class SwitchDemo {

    protected SwitchDemo() {

    }

    public static void main(String[] args) {
        final int y = 10;
        switch (y) {
            default:
                System.out.println("Default");
            case 1:
                System.out.println("Case 1");
            case 2:
                System.out.println("Case 2");
                break;
        }
    }
}
