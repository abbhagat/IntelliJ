package jpmorgan;

class Super {
    static {
        System.out.println("Super Static Block");
    }

    {
        System.out.println("Super Non Static Block");
    }

    Super() {
        System.out.println("Super Constructor");
    }
}

class Sub extends Super {
    static {
        System.out.println("Sub Static Block");
    }

    {
        System.out.println("Sub Non Static Block");
    }

    Sub() {
        System.out.println("Sub Constructor");
    }
}

public class BlockConstructor {
    static {
        System.out.println("BlockDemo Static Block");
        String s = "Java";
        s.concat("is an OOP");
        System.out.println(s);
    }

    public static void main(String[] args) {
        new Sub();
        new Sub();
        new Super();
    }
}
