package trees;

import static java.lang.Integer.max;

public class MaxDistanceBetweenAnyNodes {

    private static int max_sum = Integer.MIN_VALUE;
    private static int lH, rH;

    public static void height(Node root) {
        if (root == null) {
            return;
        }else{
            if(root.left != null){
                lH++;
                height(root.left);
            }
            if(root.right != null){
                rH++;
                height(root.right);
            }
            System.out.println(lH + "\t" + rH);
            max_sum = max(max_sum, lH + rH - 2);
        }
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(6);
        root.left.left.left.right = new Node(7);
        root.left.left.left.right.left = new Node(17);
        root.left.left.left.right.left.left = new Node(27);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.left.right.right.right = new Node(25);
        height(root);
        System.out.println(max_sum);
    }
}
