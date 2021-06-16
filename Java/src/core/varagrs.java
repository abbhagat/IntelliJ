package core;


/**
 * While using the varargs, you must follow some rules otherwise program code won't compile. The rules are as follows:
 *
 * There can be only one variable argument in the method.
 * Variable argument (varargs) must be the last argument.
 */

public class varagrs {

    public static void display(int x) {
        System.out.println("Primitive one args");
    }

    public static void display(int x, int y) {
        System.out.println("Primitive two args");
    }

    public static void display(int x, int... y) {
        System.out.println("Primitive one args and one varargs");
    }

    public static void display(int[]... x) {
        System.out.println("Primitive 1D array args");
    }

//    public static void display(int[] x) {
//        System.out.println("Primitive 1D array args");
//    }

    // Array of 2D arrays
    public static void display(int[][]... x) {
        System.out.println("Primitive 2D array args");
    }

    public static void display(int... x) {
        System.out.println("Primitive vargars args");
    }

//    public static void display(int x, float... f, int... y) {   // Error as there can be only one varargs in a method
//        System.out.println("Primitive one args and one varargs");
//    }

    public static void main(String[] args) {
        display(1);
        display(1, 2);
        //display(1, 2, 3);
        int[][] x = {{1}, {2}};
        display(x);
        int[] y = {1};
        display(y);
    }
}
