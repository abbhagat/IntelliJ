//package linkedlist;
//
//import trees.Node;
//
//public class ConvertSortedListToBalancedTree {
//
//       Node sortedListToBST() {
//        int n = countNodes(head);             //Count the number of nodes in Linked List
//        return sortedListToBSTRecur(n);      // Construct BST
//    }
//
//    trees.Node sortedListToBSTRecur(int n) {
//        if (n <= 0) {   // Base Case
//            return null;
//        }
//        trees.Node left = sortedListToBSTRecur(n / 2);  // Recursively construct the left subtree
//        // head_ref now refers to middle node make middle node as root of BST
//        trees.Node root = new trees.Node(head.data);
//        // Set pointer to left subtree
//        root.left = left;
//        // Change head pointer of Linked List for parent recursive calls
//        head = head.next;
//        // Recursively construct the right subtree and link it with root. The number of nodes in right subtree  is total nodes - nodes in left subtree - 1 (for root)
//        root.right = sortedListToBSTRecur(n - n / 2 - 1);
//        return root;
//    }
//
//    int countNodes(trees.Node head) {
//        int count = 0;
//        Node temp = head;
//        while (temp != null) {
//            temp = temp.next;
//            count++;
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Node root = sortedListToBST();
//    }
//}
