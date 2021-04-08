package except;

public class StaticException {
    static {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
    }
}
