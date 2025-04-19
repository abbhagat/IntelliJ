package designpattern;

import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static Singleton _instance;

    private Singleton() {
        throw new RuntimeException("Can't instantiate singleton twice");
    }

    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    @Override
    public Object clone() {
        return getInstance();
    }

    public static Singleton getInstance() {
        if (_instance == null) {
            synchronized (Singleton.class) { // Lock is taken on Singleton.class
                if (_instance == null) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }
}
