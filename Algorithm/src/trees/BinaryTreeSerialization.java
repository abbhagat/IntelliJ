package trees;

import java.util.LinkedList;
import java.util.List;

import static trees.TreeTraversal.inorder;

public class BinaryTreeSerialization {

    private static String serialize(Node root, String s) {
        if (root == null) {
            s += "null,";
        } else {
            s += root.num + ",";
            s = serialize(root.left, s);
            s = serialize(root.right, s);
        }
        return s;
    }

    private static Node deserialize(LinkedList<String> list) {
        String s = list.getFirst();
        if ("null".equals(s)) {
            list.removeFirst();
            return null;
        }
        Node root = new Node(Integer.parseInt(s));
        list.removeFirst();
        root.left  = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    public static void main(String[] args) {
        Node root        = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.right.left  = new Node(4);
        root.right.right = new Node(5);
        String s = serialize(root, "");
        System.out.println(s);
        LinkedList<String> list = new LinkedList<>(List.of(s.split(",")));
        root = deserialize(list);
        inorder(root);
    }
}
