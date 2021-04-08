package enums;

public class EnumDemoo {

    String s;

    protected enum E {
        RED(10),
        BLUE(),
        GREEN(30);
        int x;

        private E() {
            x = 20;
        }

        private E(int x) {
            this.x = x;
        }

        public int getValue() {
            return x;
        }
    }

    public static void main(String[] args) {
        E e = EnumDemoo.E.RED;
        System.out.println(e instanceof E);
        System.out.println(e instanceof Object);
        System.out.println(new EnumDemoo().s == null);
        System.out.println(null == null);
        System.out.println(new EnumDemoo().s instanceof Object);
        System.out.println(e + "\t" + e.getValue() + "\t" + e.ordinal());
    }
}

class B {
    EnumDemoo.E e = EnumDemoo.E.GREEN;
    {
        e.getValue();
    }
}
