package linkedlist;

import static java.lang.Integer.parseInt;
import static linkedlist.LinkList.add;
import static linkedlist.ReverseList.reverseList;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
Input: l1 = [0], l2 = [0]
Output: [0]
 */
public class AddTwoNumInLinkedList {

    public static void main(String[] args) {
        int[] a = {2, 4, 3};
        int[] b = {5, 6, 4};
        Node l1 = null, l2 = null;
        for (int x : a) {
            l1 = add(l1, x);
        }
        LinkList.temp = LinkList.last = null;
        for (int x : b) {
            l2 = add(l2, x);
        }
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        String num1 = "", num2 = "";
        for (Node temp = l1; temp != null; temp = temp.next) {
            num1 += temp.num;
        }
        for (Node temp = l2; temp != null; temp = temp.next) {
            num2 += temp.num;
        }
        System.out.println(parseInt(num1) + parseInt(num2));
    }
}
