package threads;

import java.io.Serializable;

public class Doubleton implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private static volatile Doubleton _instance1, _instance2;
    private static volatile int x = 1;

    private Doubleton() throws Exception {
        if (null != _instance1 || null != _instance2) {
            throw new Exception("Doubleton Already Initialized");
        }
    }

    protected Object readResolve() throws Exception {
        return getInstance();
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            return getInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized Doubleton getInstance() throws Exception {
        if (null == _instance1) {
            _instance1 = new Doubleton();
            return _instance1;
        }
        if (null == _instance2) {
            _instance2 = new Doubleton();
            return _instance2;
        }
        return x++ % 2 == 0 ? _instance1 : _instance2;
    }
}
