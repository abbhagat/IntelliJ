package trees;

import static java.lang.Integer.max;

public class RootThatGivesMinHeight {

    private static int max = Integer.MIN_VALUE;

    private static int treeHeight(Node root, Node node){
        if(root == null){
            return -1;
        }
        int lh = treeHeight(root.left,  node);
        int rh = treeHeight(root.right, node);
        int height = max(lh, rh) + 1;
        if(max < height){
            max = height;
            System.out.println(root.num);
        }
        return height;
    }

    public static void main(String[] args) {
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.left.left      = new Node(4);
        root.left.right     = new Node(5);
        Node node = new Node();
        treeHeight(root, node);
        System.out.println(node.num);
    }
}
