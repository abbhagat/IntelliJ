package string;

class Demo {
    final int y = 10;

    void display(final int y) {
        System.out.println(y);
        System.out.println(this.y);
    }

    public static void main(String[] args) {
        new Demo().display(9);
    }
}
