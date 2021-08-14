package linkedlist;

class TNode {
    int num;
    TNode left, right;

    TNode(int num) {
        this.num = num;
    }
}

public class ConvertSortedListToBalancedTree {

    private static TNode sortedListToBST(Node node) {
        int n = countNodes(node);                   //Count the number of nodes in Linked List
        return sortedListToBSTRecur(node, n);      // Construct BST
    }

    private static TNode sortedListToBSTRecur(Node head, int n) {
        if (n <= 0) {   // Base Case
            return null;
        }
        TNode left = sortedListToBSTRecur(head, n / 2);  // Recursively construct the left subtree
        // head_ref now refers to middle node make middle node as root of BST
        TNode root = new TNode(head.num);
        // Set pointer to left subtree
        root.left = left;
        // Change head pointer of Linked List for parent recursive calls
        head = head.next;
        // Recursively construct the right subtree and link it with root. The number of nodes in right subtree  is total nodes - nodes in left subtree - 1 (for root)
        root.right = sortedListToBSTRecur(head, n - n / 2 - 1);
        return root;
    }

    private static int countNodes(Node node) {
        int count = 0;
        for (Node temp = node; temp != null; temp = temp.next) {
            count++;
        }
        return count;
    }

    private static void preOrder(TNode node) {
        if (node == null)
            return;
        System.out.print(node.num + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        TNode root = sortedListToBST(first);
        preOrder(root);
    }
}
