package threads;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static final Long serialVersionUID = 1L;

    private static volatile Singleton _instance;

    private Singleton() throws Exception {
        if (null != _instance) {
            throw new Exception();
        }
    }

    // To prevent from Serializable
    protected Object readResolve() throws Exception {
        return getInstance();
    }

    public static Singleton getInstance() throws Exception {
        if (null == _instance) {
            synchronized (Singleton.class) {
                if (null == _instance) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }

    @Override
    public Singleton clone() {
        try {
            _instance = getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _instance;
    }
}
