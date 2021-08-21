package trees;

import java.util.Stack;

import static trees.BinaryTree.createBT;

interface Iterator {
    boolean hasNext();
    Node curr();
    Node next();
}

interface Container {
    Iterator iterator();
}

class TreeIterator implements Container {

    private Stack<Node> stack;

    public TreeIterator() {
        stack = new Stack<>();
    }

    public Stack<Node> getStack() {
        return stack;
    }

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
            Node temp = stack.peek().right;
            Node node = stack.pop();
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            return node;
        }
    }
}

public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBT(a[i], root);
        }
        TreeIterator treeIterator = new TreeIterator();
        Node curr = root;
        while (curr != null) {
            treeIterator.getStack().push(curr);
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
