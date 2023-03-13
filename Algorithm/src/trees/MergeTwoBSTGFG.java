package trees;

// Time Complexity = O(n + m)
// Space Complexity = O(H1 + H2), H1 is the height of the first tree and H2 is the height of the second tree


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBSTGFG {

    public static void mergeTrees(Node root1, Node root2) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        while (root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {
            while (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }
            if (s2.isEmpty() || (!s1.isEmpty() && s1.peek().num <= s2.peek().num)) {
                root1 = s1.peek();
                s1.pop();
                list.add(root1.num);
                root1 = root1.right;
            } else {
                root2 = s2.peek();
                s2.pop();
                list.add(root2.num);
                root2 = root2.right;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Node root1  = new Node(3);
        root1.left  = new Node(1);
        root1.right = new Node(5);
        Node root2  = new Node(4);
        root2.left  = new Node(2);
        root2.right = new Node(6);
        mergeTrees(root1, root2);
    }
}
