package designpattern;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Memento pattern is used to restore the state of an object to a previous state.
 * Memento pattern uses three actor classes.
 * The Memento contains the state of an object to be restored.
 * The Originator creates and stores states in Memento objects.
 * Caretaker object restores object state from Memento.
 */
record Memento(String state) {

}

@Setter
@Getter
class Originator {

    private String state;

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.state();
    }
}

class CareTaker {

    List<Memento> list = new ArrayList<>();

    public boolean add(Memento state) {
        return list.add(state);
    }

    public Memento get(int index) {
        return list.get(index);
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
