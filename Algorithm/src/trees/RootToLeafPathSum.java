package trees;

public class RootToLeafPathSum {

    public static boolean pathExist(Node root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        return pathExist(root.left, sum - root.num) || pathExist(root.right, sum - root.num);
    }
}
