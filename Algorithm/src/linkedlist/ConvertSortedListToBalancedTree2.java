package linkedlist;

import static linkedlist.MidPointOfLinkedList.findMid;

class TreeNode {
    int num;
    TreeNode left, right;

    TreeNode(int num) {
        this.num = num;
        left = null;
        right = null;
    }
}

public class ConvertSortedListToBalancedTree2 {

    private static TreeNode sortedListToBST(Node first, Node mid) {
        if (first == mid) {
            return null;
        }
        mid = findMid(first);
        Node first2 = mid.next;
        mid.next = null;
        TreeNode root = new TreeNode(mid.num);
        System.out.println(root.num);

        root.left = sortedListToBST(first,mid);
        root.right = sortedListToBST(first2,mid);
        return root;
    }

    private static void preOrder(TreeNode node) {
        if (node == null)
            return;
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
        TreeNode root = sortedListToBST(first, findMid(first));
        //preOrder(root);
    }
}
