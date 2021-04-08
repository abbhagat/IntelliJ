package utildemo;

import java.io.FileNotFoundException;
import java.io.IOException;

class Super {
    protected Super getInstance() throws IOException {
        System.out.println("Super class getInstance() method");
        return new Super();
    }

    protected static Number display() {
        System.out.println("Super class static method");
        return Integer.valueOf(1);
    }
}

class Sub extends Super {

    public Sub getInstance() throws IOException, RuntimeException, FileNotFoundException {
        System.out.println("Sub class getInstance() method");
        return new Sub();
    }

    protected static Integer display() {
        System.out.println("Sub class static method");
        return Integer.valueOf(2);
    }
}

public class CovariantDemo {
    public static void main(String[] args) throws IOException {
        Super s = new Sub();
        s.getInstance();
        System.out.println(s.display());
    }
}
