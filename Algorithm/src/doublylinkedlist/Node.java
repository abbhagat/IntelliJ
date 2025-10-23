package doublylinkedlist;

public class Node {

  public int num;
  public Node left, right;

  public Node(int num) {
    this.num = num;
    this.left = this.right = null;
  }
}
