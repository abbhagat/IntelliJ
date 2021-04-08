package package1;

class TestBuffer {

    public void myBuf(StringBuffer s2, StringBuffer s1) {
        s2.append("how are you");
        s2 = s1;
        System.out.println("muBuf:" + s2);
    }

    public static void main(String[] args) {

        TestBuffer tb = new TestBuffer();
        StringBuffer s1 = new StringBuffer("Hello");
        String Object = "a";
        System.out.println(Object);
        StringBuffer s2 = new StringBuffer("doing");
        tb.myBuf(s2, s1);
        System.out.print(s2);
    }
}
