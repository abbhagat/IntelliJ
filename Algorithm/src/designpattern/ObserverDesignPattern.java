package designpattern;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

class Subject {

    @Getter
    private int state;

    private final List<Observer> observers = new ArrayList<>();

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    private void notifyAllObservers() {
        this.observers.forEach(observer -> observer.notify(observer));
    }
}

abstract class Observer {
    protected Subject subject;
    public abstract void notify(Observer observer);
}

class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void notify(Observer observer) {
        System.out.println("Binary String " + Integer.toBinaryString(this.subject.getState()));
    }
}

class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void notify(Observer observer) {
        System.out.println("Octal String " + Integer.toOctalString(this.subject.getState()));
    }
}

class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void notify(Observer observer) {
        System.out.println("Hex String " + Integer.toHexString(this.subject.getState()));
    }
}

public class ObserverDesignPattern {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
