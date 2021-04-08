package core;

import java.io.IOException;

class Super {
    int z = 10;

    Super display(int x, Float y) throws IOException {
        System.out.println("Super");
        throw new IOException("");
    }
}

class Sub extends Super {
    //float z = 20f; valid
    int z = 10;

    protected Sub display(int x, Float y) { // IOException | RuntimeException | Subclass of IOException | No Exception at all
        System.out.println("Sub" + "\t" + super.z + "\t" + z);
        return null;
    }

    void play() {
        System.out.println("play");
    }
}

public class Override {

    public static void main(String[] args) throws IOException {
        Super sup = new Super();
        Sub sub = new Sub();
        sup = sub;
        // sup.play(); // super class don't define the play() method hence error
        sub = (Sub) sup;
        sub.play();
        sup.display(1, 2f);
        Sub c = null;
        System.out.println(null == null);  // true
        // System.out.println(c.equals(sup)); // NPE
    }
}
