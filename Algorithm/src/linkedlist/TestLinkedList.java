package linkedlist;

public class TestLinkedList {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        TraverseList.traverseList(first);
        first = ReverseList.reverseList(first);
        TraverseList.traverseList(first);
        TraverseList.traverseList(LinkedListRotation.rotateList(first, 3));
        System.out.println(MidPointOfLinkedList.findMid(first).num);
    }
}
