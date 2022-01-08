package singleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> classObj = Class.forName("singleton.Singleton");
        Singleton s = Singleton.getInstance();
        s = (Singleton) classObj.newInstance();
        Method[] m = classObj.getDeclaredMethods();
        Method m1;
        try {
            m1 = classObj.getMethod("display", null);
            //m1.invoke(null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
