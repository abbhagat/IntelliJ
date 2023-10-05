package trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafLongestPath {

    public static List<Integer> longestPath(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> leftList  = longestPath(root.left);
        List<Integer> rightList = longestPath(root.right);
        boolean b = leftList.size() > rightList.size() ? leftList.add(root.num) : rightList.add(root.num);
        return      leftList.size() > rightList.size() ? leftList : rightList;
    }

    public static void main(String[] args) {
        Node root        = new Node(5);
        root.left        = new Node(3);
        root.right       = new Node(8);
        root.left.left   = new Node(1);
        System.out.println(longestPath(root));
    }
}
