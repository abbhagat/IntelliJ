package innerclass;

import java.util.ArrayList;
import java.util.List;

public class ReferenceDemo {

    void changeList(List<Integer> al) {
        al.add(10);
    }

    void changeInteger(Integer i) {
        i = 100;
    }

    void changeStringBuffer(StringBuffer sb) {
        sb.append(" is an OOP");
    }

    public static void main(String[] args) {
        ReferenceDemo referenceDemo = new ReferenceDemo();
        List<Integer> al = new ArrayList<>();
        al.add(1);
        System.out.println(al.hashCode());
        al.add(2);
        System.out.println(al.hashCode());
        al.add(3);
        System.out.println(al.hashCode());
        System.out.println(al);
        System.out.println(al.hashCode());
        referenceDemo.changeList(al);
        System.out.println(al);
        System.out.println(al.hashCode());
        Integer i = new Integer(10);
        referenceDemo.changeInteger(i);
        System.out.println(i);
        StringBuffer sb = new StringBuffer("Java");
        referenceDemo.changeStringBuffer(sb);
        System.out.println(sb);
    }
}
