package io.github.bluething.leetcode.algorithm.recursion;

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

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 ==null) {
            return l1;
        }

        ListNode merged = null;

        // if l1 <= l2
        // assign merge to l1
        // for the next merge node give to recursion next node of l1 and current l2
        if (l1.val <= l2.val) {
            merged = l1;
            merged.next = mergeTwoLists(l1.next, l2);
        } else {
            merged = l2;
            merged.next = mergeTwoLists(l1, l2.next);
        }

        return merged;
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
