package corejava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StudentDebugger {

    public static void main(String[] args) throws Exception {

        Class<?> stud = Class.forName("corejava.Student");
        Method meth = stud.getDeclaredMethod("setName", new Class[]{String.class});
        Object obj = stud.newInstance();
        meth.invoke(obj, new Object[]{"Java is an OOP"});
        meth = stud.getDeclaredMethod("getName", new Class[]{});
        String s = (String) meth.invoke(obj, new Object[]{});
        System.out.println(s);
        meth = stud.getDeclaredMethod("setName", new Class[]{String.class});
        System.out.println(stud instanceof Class);
        System.out.println(stud instanceof Object);
        System.out.println(stud.getPackage());
        System.out.println(stud.getSuperclass());
        System.out.println(stud.getSimpleName());
        Constructor[] cons = stud.getConstructors();
        for (Constructor c : cons) {
            System.out.println(c.getName() + "\t" + c.getClass() + "\t" + c.getModifiers());
        }
        Method[] method = stud.getDeclaredMethods();
        Field[] field = stud.getDeclaredFields();
        for (Method m : method) {
            System.out.println(m.getName() + "\t" + m.getClass() + "\t" + m.getModifiers());
        }
    }
}
