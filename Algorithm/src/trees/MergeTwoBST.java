package trees;

// Time Complexity = O(n + m)
// Space Complexity = O(N)
public class MergeTwoBST {

    private int n, k;

    public void inorder(Node root) {
        if (null != root) {
            inorder(root.left);
            n++;
            inorder(root.right);
        }
    }

    public void inorder(Node root, int[] a) {
        if (null != root) {
            inorder(root.left, a);
            a[k++] = root.num;
            inorder(root.right, a);
        }
    }

    private void merge(Node root1, Node root2) {
        if (root1 == null) {
            TreeTraversal.inorder(root2);
            return;
        }
        if (root2 == null) {
            TreeTraversal.inorder(root1);
            return;
        }
        n = 0;
        inorder(root1);
        k = 0;
        int[] a = new int[n];
        inorder(root1, a);
        n = 0;
        k = 0;
        inorder(root2);
        int[] b = new int[n];
        k = 0;
        inorder(root2, b);
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
                i++;
                j++;
            } else {
                System.out.print(a[i] < b[j] ? a[i++] + " " : b[j++] + " ");
            }
        }
        while (i < a.length) {
            System.out.print(a[i++] + " ");
        }
        while (j < b.length) {
            System.out.print(b[j++] + " ");
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);
        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);
        new MergeTwoBST().merge(root1, root2);
    }
}
