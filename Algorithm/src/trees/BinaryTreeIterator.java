package trees;

import lombok.Getter;

import java.util.Stack;

interface Iterator {
    boolean hasNext();
    Node curr();
    Node next();
}

interface Iterable {
    Iterator iterator();
}

@Getter
class TreeIterator implements Iterable {

    private final Stack<Node> stack = new Stack<>();

    @Override
    public Iterator iterator() {
        return new BSTreeIterator();
    }

    class BSTreeIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node curr() {
            return stack.peek();
        }

        @Override
        public Node next() {
            Node curr = stack.peek().right;
            Node node = stack.pop();
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            return node;
        }
    }
}

public class BinaryTreeIterator {

    public static void main(String[] args) {
        Node root  = new Node(2);
        root.left  = new Node(1);
        root.right = new Node(3);
        TreeIterator treeIterator = new TreeIterator();
        Stack<Node> stack = treeIterator.getStack();
        Node curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        System.out.println("Iterating the Tree");
        Iterator iterator = treeIterator.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.curr().num + " ");
            iterator.next();
        }
    }
}
