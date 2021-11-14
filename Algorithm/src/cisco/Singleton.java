package cisco;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static volatile Singleton _instance;
    private static final long serialVersionUID = 1L;

    private Singleton() throws Exception{
        if(_instance != null){
            throw new Exception("Singleton is Already Initialized");
        }
    }

    public static Singleton getInstance() throws Exception{
        if(null == _instance){
            synchronized (Singleton.class){
                if(null == _instance){
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }

    protected Object readResolve() throws Exception{
        return getInstance();
    }

    @Override
    protected Singleton clone()throws CloneNotSupportedException {
        try {
            return getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
