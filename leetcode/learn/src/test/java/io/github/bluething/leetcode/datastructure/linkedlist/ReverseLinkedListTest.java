package io.github.bluething.leetcode.datastructure.linkedlist;

import java.util.List;
import java.util.Stack;

public class ReverseLinkedListTest {

    // using recursion with 3 pointer, current-prev-next
    // in each loop
    // move next to front node, assign to next
    // assign prev to current.next (as temporary)
    // assign prev to current (current node)
    // assign current to next (move to the front node)
    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    private ListNode reverseListUsingStack(ListNode head) {
        if (head == null) {
            return head;
        }

        Stack<ListNode> nodes = new Stack<>();
        ListNode pointer = head;
        while (pointer != null) {
            nodes.push(pointer);
            pointer = pointer.next;
        }

        head = nodes.peek();

        ListNode tempPointer = head;
        nodes.pop();

        while (!nodes.empty()) {
            tempPointer.next = nodes.peek();
            nodes.pop();
            tempPointer = tempPointer.next;
        }

        tempPointer.next = null;

        return head;
    }

    // using recursion
    // divide the list into two, 1st and the rest (next node)
    // call reverseListUsingRecursion for the rest
    // link rest to the first
    // fix head pointer
    private ListNode reverseListUsingRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverse = reverseListUsingRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return reverse;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
