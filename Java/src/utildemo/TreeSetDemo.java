package utildemo;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set ts = new TreeSet();
        //TreeSet<Integer> ts = new TreeSet<>((i1, i2) -> i2 - i1);
        ts.add("3");
        ts.add(5);
        ts.add(1);
        ts.add("4");
        ts.add(2);
        //ts.add(null); will cause NPE
        System.out.println(ts);
    }
}
