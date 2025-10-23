package doublylinkedlist;

public class TraverseList {

  static void traverseList(Node node) {
    for (Node temp = node; temp != null; temp = temp.right) {
      System.out.print(temp.num + " ");
    }
    System.out.println("\nSize -> " + CreateList.size);
  }
}
