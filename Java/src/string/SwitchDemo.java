package string;

public abstract class SwitchDemo {

    protected SwitchDemo() {

    }

    public static void main(String[] args) {
        final int y = 10;
        switch (y) {
            case 1:
                System.out.println("Case 1");
            case 2:
                System.out.println("Case 2");
                break;
            case 10:
                System.out.println("Case 10");
            default:
                System.out.println("Default");
        }
    }
}
