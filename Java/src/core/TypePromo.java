package core;

class TypePromo {

    private static void display(double x) {
        System.out.println("double");
    }

    private static void display(byte x) {
        System.out.println("byte");
    }

//    private static void display(long x) {
//        System.out.println("long");
//    }

    private static void display(float x) {
        System.out.println("float");
    }

//    private static void display(Object x) {
//        System.out.println("Object");
//    }

    public static void main(String[] args) {
        Short s = 5;
        display(s);
    }
}
