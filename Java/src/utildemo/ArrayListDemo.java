package utildemo;

import access.Main;

import java.util.*;

public class ArrayListDemo {

    public String toString() {
        return "Java is an OOP";
    }

    public static void main(String[] args) {
        Vector v;
        Collection c;
        String String = "Hello";
        System.out.println(String);
        ArrayList<Integer> al = new ArrayList<>();
        al.ensureCapacity(4);
        LinkedList LinkedList;
        al.add(1);
        al.add(2);
        System.out.println(al.size());
        System.out.println(al);
        al.add(3);
        System.out.println(al.size());
        System.out.println(al);
        al.remove(2);
        Student s1 = new Student("A", 99);
        Main m = new Main(20);
        ListIterator<Integer> ltr = al.listIterator();
        while (ltr.hasNext()) {
            System.out.println(ltr.next());
        }
        while (ltr.hasPrevious()) {
            System.out.println(ltr.previous());
        }
    }
}
