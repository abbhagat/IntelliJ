package doublylinkedlist;

public class CovertDLLToBST {

    private static Node head;

    private static Node sortedListToBST(int n) {                // n is the total no of nodes in the Link List
        if (n <= 0) {
            return null;
        }
        Node left = sortedListToBST(n / 2);               // Recursively construct the left subtree
        Node root = head;                                   // head_ref now refers to middle node, make middle node as root of BST
        root.left = left;                                  // Set pointer to left subtree
        head = head.right;                                // Change head pointer of Linked List for parent recursive calls
        root.right = sortedListToBST(n - n / 2 - 1);  // Recursively construct the right subtree and link it with root.
        return root;                                    // The number of nodes in right subtree  is total nodes - nodes in left subtree - 1 (for root)
    }

    private static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.num + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            head = CreateList.createList(i, null);
        }
        TraverseList.traverseList(head);
        Node root = sortedListToBST(CreateList.size);
        preOrder(root);
    }
}
