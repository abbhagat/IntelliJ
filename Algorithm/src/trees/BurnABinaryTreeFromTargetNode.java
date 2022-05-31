package trees;

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



    public static void main(String[] args) {

    }
}
