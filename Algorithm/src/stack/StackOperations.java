package stack;

public class StackOperations {

    public static void main(String[] args) {
        StackPopNPush s = new StackPopNPush();
        Node first = null;
        String str = "abcde";
        for (char c : str.toCharArray()) {
            first = s.push(c);
        }
        s.display(first);
        first = s.pop(first);
        s.display(first);
    }
}
