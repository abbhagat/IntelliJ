package except;

import java.io.FileNotFoundException;
import java.io.IOException;

class Super {

    int x = 20;

    Super getInstance(Super s, String str) throws IOException {
        System.out.println(str + " inside Super class");
        return new Super();
    }
}

class Sub extends Super {

    int x = 10;

    protected Sub getInstance(Super s, String str) throws IOException, FileNotFoundException, RuntimeException {
        System.out.println(str + " inside Sub class");
        return new Sub();
    }
}

public class OverrideException {
    public static void main(String[] args) throws IOException {
        Super s = new Sub();
        System.out.println(s.x);
//        Sub s1 = s.getInstance(s, "String"); // Error
        Super s1 = s.getInstance(s, "String");
        System.out.println(s1.x); // s.getInstance(s, "String") -> returns an instanceof Super
        Sub sub = new Sub();
        System.out.println(sub instanceof Super);
        System.out.println(sub.x);
    }
}
