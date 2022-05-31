package trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

Input :
                       12
                     /     \
                   13       10
                          /     \
                       14       15
                      /   \     /  \
                     21   24   22   23
target node = 14

Output :
14
21, 24, 10
15, 12
22, 23, 13

Explanation : First node 14 burns then it gives fire to its neighbours (21, 24, 10) and so on. This process continues until
the whole tree burns.

First search the target node in a binary tree recursively.
After finding the target node print it and save its left child(if exist) and right child(if exist) in a queue. and return.
Now, get the size of the queue and run while loop. Print elements in the queue.
 */
public class BurnABinaryTreeFromTargetNode {

    public static int search(Node root, int num, Map<Integer, Set<Integer>> map) {
        if (root != null) {
            if (root.num == num) {
                levelOrderStoredInMap(root.left,  1, map);
                levelOrderStoredInMap(root.right, 1, map);
                return 1;
            }
            int k = search(root.left, num, map);
            if (k > 0) {
                storeRootAtK(root, k, map);                        // store root in map with k
                levelOrderStoredInMap(root.right, k + 1, map); // store level order for other branch
                return k + 1;
            }
            k = search(root.right, num, map);
            if (k > 0) {
                storeRootAtK(root, k, map);                        // store root in map with k
                levelOrderStoredInMap(root.left, k + 1, map);  // store level order for other branch
                return k + 1;
            }
        }
        return -1;
    }

    public static void levelOrderStoredInMap(Node root, int k, Map<Integer, Set<Integer>> map) {
        if (root != null) {
            storeRootAtK(root, k, map);
            levelOrderStoredInMap(root.left,  k + 1, map);
            levelOrderStoredInMap(root.right, k + 1, map);
        }
    }

    private static void storeRootAtK(Node root, int k, Map<Integer, Set<Integer>> map) {
        if (map.containsKey(k)) {
            map.get(k).add(root.num);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(root.num);
            map.put(k, set);
        }
    }

    public static void main(String[] args) {
        Node root        = new Node(12);
        root.left        = new Node(13);
        root.right       = new Node(10);
        root.right.left  = new Node(14);
        root.right.right = new Node(15);
        Node left        = root.right.left;
        Node right       = root.right.right;
        left.left        = new Node(21);
        left.right       = new Node(24);
        right.left       = new Node(22);
        right.right      = new Node(23);
        Map<Integer, Set<Integer>> map = new HashMap<>(); // Utility Map to store the sequence of burning nodes
        search(root, 14, map);                      //  search node and store the level order from that node in map
        System.out.println(14);
        for (Integer level : map.keySet()) {
            for (Integer val : map.get(level)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
