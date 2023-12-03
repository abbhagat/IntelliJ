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
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.num);  // insert additional node after every node of original list
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        temp = head;
        // adjust the random pointers of the newly added nodes
        while (temp != null) {
            if (temp.next != null) {
                temp.next.random = temp.random != null ? temp.random.next : temp.random;
            }
            temp = temp.next.next; // move to the next newly added node by skipping an original node
        }
        temp = head;
        Node copy = head.next;
        Node node = head.next;  // save the head of copied linked list and separate the original list and copied list
        while (temp != null) {
            temp.next = temp.next.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            temp = temp.next;
            copy = copy.next;
        }
        return node;
    }

    public static void main(String[] args) {
        Node node = clone(new Node(10));
        System.out.println(node.num);
    }
}
