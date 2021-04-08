package designpattern;

/*
 * Observer pattern is used when there is one-to-many relationship between objects
 * such as if one object is modified,its depenedent objects are to be notified automatically
 */

import java.util.Observable;
import java.util.Observer;

class Student extends Observable {

    private int marks;

    public void setMarks(int marks) {
        this.marks = marks;
        setChanged(); // specifies that the state of the object has been changed
        notifyObservers(); // notify all the observer
    }

    public int getMarks() {
        return marks;
    }
}

class BinaryObserver implements Observer {

    private Student s;

    BinaryObserver(Student s) {
        this.s = s;
    }

    public void update(Observable o, Object arg) {
        System.out.println("Binary String: " + Integer.toBinaryString(s.getMarks()));
    }
}

class OctalObserver implements Observer {

    private Student s;

    OctalObserver(Student s) {
        this.s = s;
    }

    public void update(Observable o, Object arg) {
        System.out.println("Octal String: " + Integer.toOctalString(s.getMarks()));
    }
}

class HexObserver implements Observer {

    private Student s;

    HexObserver(Student s) {
        this.s = s;
    }

    public void update(Observable o, Object arg) {
        System.out.println("Hex String: " + Integer.toHexString(s.getMarks()));
    }
}

public class ObservablePattern {

    public static void main(String[] args) {
        Student s = new Student();
        BinaryObserver binary = new BinaryObserver(s);
        OctalObserver octal = new OctalObserver(s);
        HexObserver hex = new HexObserver(s);
        s.addObserver(hex);
        s.addObserver(octal);
        s.addObserver(binary);
        s.setMarks(100);
        s.setMarks(200);
    }
}
