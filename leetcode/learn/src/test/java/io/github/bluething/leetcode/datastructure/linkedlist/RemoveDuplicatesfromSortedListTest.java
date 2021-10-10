package io.github.bluething.leetcode.datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedListTest {
    private ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return pointer;
    }

    // compare current node with next node and deleting them until find not same value
    // set current to the next different
    private ListNode deleteDuplicatesUsingNestedWhile(ListNode head) {
        ListNode current = head;

        while (current != null) {
            ListNode temp = current;
            while (temp != null && temp.val == current.val) {
                temp = temp.next;
            }

            current.next = temp;
            current = current.next;
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
