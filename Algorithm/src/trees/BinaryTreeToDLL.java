package trees;

// Time Complexity : O(n)
// Auxiliary space: O(log N)
public class BinaryTreeToDLL {

    private static Node temp, head;

    private static void convertTreeToDLL(Node root) {
        if (root == null) {
            return;
        }
        convertTreeToDLL(root.left);
        if (head == null) {
            head = root;
        } else {
            temp.right = root;
            root.left = temp;
        }
        temp = root;
        convertTreeToDLL(root.right);
    }

    public static void main(String[] args) {
        Node root       = new Node(1);
        root.left       = new Node(2);
        root.right      = new Node(3);
        convertTreeToDLL(root);
        System.out.println("head -> " + head.num);
        System.out.println("temp -> " + temp.num);
        for (Node temp = head; temp != null; temp = temp.right) {
            System.out.print(temp.num + " ");
        }
    }
}
