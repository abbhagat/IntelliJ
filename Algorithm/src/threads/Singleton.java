package threads;

import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static volatile Singleton singleton;

    private Singleton() throws Exception {
        if (null != singleton) {
            throw new Exception("Singleton is already initialized. Use getInstance() method to access the singleton instance.");
        }
    }

    // To prevent from Serializable
    @Serial
    protected Object readResolve() throws Exception {
        return getInstance();
    }

    public static Singleton getInstance() throws Exception {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    @Override
    public Singleton clone() throws CloneNotSupportedException {
        try {
            singleton = getInstance();
        } catch (Exception e) {
            throw new CloneNotSupportedException();
        }
        return singleton;
    }
}
