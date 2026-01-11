package doublylinkedlist;

public class TraverseList {

  public static void traverseList(Node node) {
    int size = 0;
    for (Node temp = node; temp != null; temp = temp.right) {
      System.out.print(temp.num + " ");
      size++;
    }
    System.out.println("\nSize -> " + size);
  }
}
