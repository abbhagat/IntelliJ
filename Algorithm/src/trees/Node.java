package trees;

public class Node {

  public int num, vd = Integer.MAX_VALUE;

  public Node left, right;

  public Node() {}

  public Node(int num) {
    this.num = num;
  }
}
