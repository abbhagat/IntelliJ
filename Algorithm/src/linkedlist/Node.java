package linkedlist;

public class Node {

  public int num;
  public Node next, random;

  public Node() {
  }

  public Node(int num) {
    this.num = num;
  }

  public Node(int num, Node next) {
    this.num = num;
    this.next = next;
  }
}
