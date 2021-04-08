package threads;

import java.io.Serializable;

public class Doubleton implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private static Doubleton _instance1, _instance2;
    private static int x = 1;

    private Doubleton() { }

    protected Object readResolve(){
        return getInstance();
    }

    public static synchronized Doubleton getInstance() {
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

    public Object clone(){
        return getInstance();
    }
}
