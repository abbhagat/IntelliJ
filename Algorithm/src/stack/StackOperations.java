package stack;

public class StackOperations {
    public static void main(String[] args) {
        StackPopnPush s = new StackPopnPush();
        Node first = null;
        String str = "abcde";
        for (char c : str.toCharArray()) {
            first = s.push(c, null);
        }
        s.display(first);
        first = s.pop(first);
        s.display(first);
        System.out.println(s.c);
    }
}
