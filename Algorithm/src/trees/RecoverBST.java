package trees;

/* Two nodes of a BST are swapped, correct the BST
Input Tree:
         10
        /  \
       5    8
      / \
     2   20

In the above tree, nodes 20 and 8 must be swapped to fix the tree.
Following is the output tree
         10
        /  \
       5    20
      / \
     2   8
*/

import static trees.TreeTraversal.inorder;

// Time Complexity: O(n)
public class RecoverBST {

    private static Node first, middle, last, prev;

    private static void correctBSTUtil(Node root) {
        if (root != null) {
            correctBSTUtil(root.left);
            if (prev != null && root.num < prev.num) {
                if (first == null) {
                    first  = prev;
                    middle = root;
                }
                else {
                    last = root;
                }
            }
            prev = root;
            correctBSTUtil(root.right);
        }
    }

    private static void correctBST(Node root) {
        correctBSTUtil(root);
        if (first != null && last != null) {
            int temp  = first.num;
            first.num = last.num;
            last.num  = temp;
        }
        else if (first != null && middle != null) {
            int temp   = first.num;
            first.num  = middle.num;
            middle.num = temp;
        }
    }

    public static void main(String[] args) {
/*                       6
                        / \
                       10  2
                      / \ / \
                     1  3 7 12

                    10 and 2 are swapped
*/
        Node root        = new Node(6);
        root.left        = new Node(10);
        root.right       = new Node(2);
        root.left.left   = new Node(1);
        root.left.right  = new Node(3);
        root.right.right = new Node(12);
        root.right.left  = new Node(7);
        System.out.println("Inorder Traversal of the original tree");
        inorder(root);
        correctBST(root);
        System.out.println("Inorder Traversal of the fixed tree");
        inorder(root);
    }
}
