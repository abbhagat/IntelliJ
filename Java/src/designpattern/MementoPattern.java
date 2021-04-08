package designpattern;

import java.util.ArrayList;

/*
 * Memento pattern is used to restore state of an object to a previous state.
 * Memento pattern uses three actor classes.
 * Memento contains state of an object to be restored.
 * Originator creates and stores states in Memento objects.
 * Caretaker object restores object state from Memento.
 */
class Memento {

    private String state;

    Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

class CareTaker {

    ArrayList<Memento> al = new ArrayList<Memento>();

    public void add(Memento state) {
        al.add(state);
    }

    public Memento get(int index) {
        return al.get(index);
    }
}

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
