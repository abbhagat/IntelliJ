package singleton;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static final Long serialVersionUID = 1L;

    private volatile static Singleton _instance;

    private Singleton() {
        if (null != _instance) {
            try {
                throw new InstantiationException();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    protected Object readResolve() {
        return getInstance();
    }

    public static Singleton getInstance() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                if (_instance == null) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }
}
