package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
Input: l1 = [0], l2 = [0]
Output: [0]
 */
public class AddTwoNumInLinkedList {

  private static Node addTwoList(Node l1, Node l2) {
    Node head = new Node(0);
    Node temp = head;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry;
      if (l1 != null) {
         sum += l1.num;
         l1   = l1.next;
      }
      if (l2 != null) {
         sum += l2.num;
         l2   = l2.next;
      }
      carry   = sum / 10;
      int num = sum % 10;
      temp.next = new Node(num);
      temp = temp.next;
    }
    return head.next;
  }

  public static void main(String[] args) {
    int[] a = {9, 9, 9, 9, 9, 9, 9};
    int[] b = {9, 9, 9, 9};
    Node l1 = null, l2 = null;
    for (int x : a) {
      l1 = add(l1, x);
    }
    LinkList.temp = LinkList.last = null;
    for (int x : b) {
      l2 = add(l2, x);
    }
    Node l3 = addTwoList(l1, l2);
    traverseList(l3);
  }
}
