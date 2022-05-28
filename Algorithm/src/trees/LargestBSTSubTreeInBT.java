package trees;

// Time Complexity O(n)
public class LargestBSTSubTreeInBT {

    private static class Value {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int max_size = 0;
        boolean isBST = false;
    }

    private static int largestBST(Node root, Value value) {
        largestBSTUtil(root, value, value, value, value);
        return value.max_size;
    }

    private static int largestBSTUtil(Node root, Value min_ref, Value max_ref, Value max_size_ref, Value isBST_ref) {
        if (root == null) {
            isBST_ref.isBST = true;
            return 0;
        }
        int min = Integer.MIN_VALUE;
        boolean left = false, right = false;
        int ls, rs;
        max_ref.max = Integer.MIN_VALUE;
        ls = largestBSTUtil(root.left, min_ref, max_ref, max_size_ref, isBST_ref);
        if (isBST_ref.isBST && root.num > max_ref.max) {
            left = true;
        }
        min = min_ref.min;
        min_ref.min = Integer.MAX_VALUE;
        rs = largestBSTUtil(root.right, min_ref, max_ref, max_size_ref, isBST_ref);
        if (isBST_ref.isBST && root.num < min_ref.min) {
            right = true;
        }
        if (min < min_ref.min) {
            min_ref.min = min;
        }
        if (root.num < min_ref.min)
        {
            min_ref.min = root.num;
        }
        if (root.num > max_ref.max) {
            max_ref.max = root.num;
        }
        if (left && right) {
            if (ls + rs + 1 > max_size_ref.max_size) {
                max_size_ref.max_size = ls + rs + 1;
            }
            return ls + rs + 1;
        } else {
            isBST_ref.isBST = false;
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
