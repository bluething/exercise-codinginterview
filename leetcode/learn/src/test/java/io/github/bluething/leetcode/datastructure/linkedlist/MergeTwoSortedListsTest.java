package io.github.bluething.leetcode.datastructure.linkedlist;

import org.junit.Test;

public class MergeTwoSortedListsTest {

    @Test
    public void case01() {
        ListNode fourOne = new ListNode(4);
        ListNode twoOne = new ListNode(2, fourOne);
        ListNode oneOne = new ListNode(1, twoOne);

        ListNode fourTwo = new ListNode(4);
        ListNode threeTwo = new ListNode(3, fourTwo);
        ListNode oneTwo = new ListNode(1, threeTwo);

        mergeTwoLists(oneTwo, oneOne);
    }

    // using recursion
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode merged = null;

        if (l1.val <= l2.val) {
            merged = l1;
            merged.next = mergeTwoLists(l1.next, l2);
        } else {
            merged = l2;
            merged.next = mergeTwoLists(l1, l2.next);
        }

        return merged;
    }

    // using loop
    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(-1);
        ListNode pointer = merged;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }

            pointer = pointer.next;
        }

        pointer.next = l1 != null ? l1 : l2;

        return merged.next;
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
