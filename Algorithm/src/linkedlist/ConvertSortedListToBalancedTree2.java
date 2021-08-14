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

public class ConvertSortedListToBalancedTree2 {

    private static TreeNode root;

    private static TreeNode sortedListToBST(TreeNode root, Node first) {
        if (first.next != null) {
            Node mid = MidPointOfLinkedList.findMid(first);
            Node first2 = mid.next;
            mid.next = null;
            root = new TreeNode(mid.num);
            root.left = sortedListToBST(root.left, MidPointOfLinkedList.findMid(first));
            root.right = sortedListToBST(root.right, MidPointOfLinkedList.findMid(first2));
            return root;
        }else{
            return root;
        }
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
        TreeNode root = sortedListToBST(null, first);
        preOrder(root);
    }
}
