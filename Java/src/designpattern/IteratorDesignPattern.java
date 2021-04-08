package designpattern;

/*
 *
 */

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Container {
    Iterator iterator();
}

class BinaryTree {
    int num;
    BinaryTree left;
    BinaryTree right;

    BinaryTree createBinaryTree(int num, BinaryTree root) {
        if (root == null) {
            root = new BinaryTree();
            root.num = num;
            root.left = null;
            root.right = null;
        } else if (root.num < num) {
            root.left = createBinaryTree(num, root.left);
        } else if (root.num > num) {
            root.right = createBinaryTree(num, root.right);
        } else {
            System.out.println("Duplicate Node");
        }
        return root;
    }

    void inorder(BinaryTree root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.num + " ");
            inorder(root.right);
        }
    }
}

class TreeIterator implements Container {

    public Iterator iterator() {
        return new BinaryTreeIterator();
    }

    class BinaryTreeIterator implements Iterator {

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            return null;
        }
    }

}

public class IteratorDesignPattern {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree root = null;
        int[] a = { 10, 20, 14, 6, 3, 4, 7, 9, 12, 1, 25 };
        for (int x : a) {
            root = tree.createBinaryTree(x, root);
        }
        tree.inorder(root);
    }
}
