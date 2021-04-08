package access;

import java.lang.instrument.Instrumentation;

class ObjectSizeFetcher {

    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        System.out.println(instrumentation);
        return instrumentation.getObjectSize(o);
    }
}

public class CalculateObjectSize {
    private int x = 10;
    private int y = 10;

    public static void main(String[] args) {
        System.out.println(ObjectSizeFetcher.getObjectSize(new CalculateObjectSize()));
    }
}
