package linkedlist;

class TreeNode {
    int num;
    TreeNode left, right;

    TreeNode(int num) {
        this.num = num;
        left = null;
        right = null;
    }
}

public class ConvertSortedListToBalancedTree {

    public static TreeNode sortedListToBST(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.num);
        }
        Node slow = head;
        Node fast = head.next;
        Node previousSlow = null;
        while (fast != null && fast.next != null) {
            previousSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previousSlow.next = null;
        TreeNode root = new TreeNode(slow.num);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.num + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        TreeNode root = sortedListToBST(first);
        preOrder(root);
    }
}
