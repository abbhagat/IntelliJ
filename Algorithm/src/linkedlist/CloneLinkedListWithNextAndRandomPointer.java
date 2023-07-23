package linkedlist;

/*
Create the copy of node 1 and insert it between node 1 & node 2 in the original Linked List,
create a copy of 2 and insert it between 2 & 3. Continue in this fashion, add the copy of N after the Nth node
Now copy the random link in this fashion
original->next->random= original->random->next;
TRAVERSE TWO NODES
This works because original->next is nothing but a copy of the original and Original->random->next is nothing but a copy of the random.
Now restore the original and copy linked lists in this fashion in a single loop.
original->next = original->next->next;
     copy->next = copy->next->next;
Ensure that original->next is NULL and return the cloned list
 */
public class CloneLinkedListWithNextAndRandomPointer {

    private static class Node {
        public int num;
        public Node next, random;
        public Node(int num) {
            this.num = num;
        }
    }

    private static Node clone(Node head) {
        Node curr = head, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = new Node(curr.num); // insert additional node after every node of original list
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        // adjust the random pointers of the newly added nodes
        while (curr != null) {
            if (curr.next != null) {
                curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
            }
            curr = curr.next.next; // move to the next newly added node by skipping an original node
        }
        Node original = head, copy = head.next;
        temp = copy;  // save the head of copied linked list
        // now separate the original list and copied list
        while (original != null) {
            original.next = original.next.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node node = clone(new Node(10));
        System.out.println(node);
    }
}
