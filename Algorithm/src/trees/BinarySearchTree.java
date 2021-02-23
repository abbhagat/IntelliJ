package trees;

public class BinarySearchTree {

    public static Node buildBST(Node root, int num){

        if(root == null){
            root = new Node();
            root.num = num;
            root.left = root.right=null;
        }else{

        }
        return root;
    }
}
