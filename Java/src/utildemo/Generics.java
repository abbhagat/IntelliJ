package utildemo;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List al = new ArrayList<Integer>();
        al.add(1);
        al.add(2L);
        al.add(2.0f);
        al.add(2.0d);
        System.out.println(al);
        List dl = new ArrayList<Double>();
        dl.add(2.0);
        dl.add(1);
        al = dl;
        System.out.println(al);
    }
}
