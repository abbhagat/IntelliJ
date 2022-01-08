package interfacedemo;

public class VarArgs {

    static private String s;

    void display(int x, int y) {
        System.out.println("Two Int");
    }

    void display(int... y) {
        System.out.println("Varargs");
    }

    // void display(int []y){
    // System.out.println("Varargs");
    // }

    public static void main(String[] args) {
        VarArgs varArgs = new VarArgs();
        varArgs.display('A', 2);
        varArgs.display(1, 2, 3);
        float f = 10L;
        int[] a = {1, 2, 3};
        System.out.println(a instanceof Object);
        System.out.println(null instanceof Object);
    }
}
