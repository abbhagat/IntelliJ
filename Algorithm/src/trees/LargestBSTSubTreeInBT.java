package trees;

// Time Complexity O(n)
public class LargestBSTSubTreeInBT {
    private static class BST {
        int size; // Size of subtree
        int max; // Min value in subtree
        int min; // Max value in subtree
        boolean isBST; // If subtree is BST

        BST() {
        }

        BST(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    private static BST largestBST(Node root) {
        // Base case : When the current subtree is empty or the node corresponds to a null.
        if (root == null) {
            return new BST(0, Integer.MIN_VALUE,Integer.MAX_VALUE, true);
        }
        // We will here do the postorder traversal since we want our left and right subtrees to be computed first
        BST left  = largestBST(root.left);
        BST right = largestBST(root.right);
        // Create a new BST variable to store info about the current node.
        BST bst = new BST();
        bst.min = Math.min(left.min, root.num);
        bst.max = Math.max(right.max, root.num);
        bst.isBST = left.isBST && right.isBST && root.num > left.max && root.num < right.min;
        /*
        If suppose the left and right subtrees of the current node are BST and the current node value is greater than the maximum value in the left subtree
        and also the current node value is smaller that the
        minimum value in the right subtree (Basic conditions for the formation of BST) then our whole subtree with the root as current root can be considered as a
        BST. Hence the size of the BST will become size of left BST subtree + size of right BST subtree + 1(adding current node).
        Else we will consider the largest of the left BST or the  right BST.
        */
        // We need to find maximum height BST subtree then adding the height of left a right subtree will not give the maximum height, we need to find max.
        // Calculate the size of subtree if this is a BST
        bst.size =  bst.isBST ? left.size + right.size + 1 : Math.max(left.size, right.size);
        return bst;
    }

    // Return the size of the largest subtree which is also a BST
    private static int largestBst(Node root) {
        return largestBST(root).size;
    }

    public static void main(String[] args) {
        final Node root = new Node(60);
        root.left       = new Node(65);
        root.right      = new Node(70);
        root.left.left  = new Node(50);
        System.out.print("Size of the largest BST is " + largestBst(root));
    }
}
