package corejava;

public class TryCatchDemo {
    public int display() {
        int i = 10;
        try {
            System.out.println(1 / 2);
            return 20;
        } catch (Exception e) {
            System.out.println(e.getCause());
        } finally {
            System.out.println("Finally");
            return 10;
        }

        // return 0;
    }

    public static void main(String[] args) {
        int i = 10;
        try {
            System.out.println("Inside Try Block");
            System.out.println(1 / 0);
        } catch (Exception e) {
            System.out.println("Inside Catch Block");
            //System.exit(0);
        } finally {
            System.out.println("Finally");
        }
        System.out.println(new TryCatchDemo().display());
        // for(;false;); // Error
    }
}
