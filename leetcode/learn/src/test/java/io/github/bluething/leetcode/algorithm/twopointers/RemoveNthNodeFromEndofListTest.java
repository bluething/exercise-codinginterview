package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveNthNodeFromEndofListTest {
    @Test
    public void case01() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode result = removeNthFromEnd(one, 2);

        List<Integer> actual = new ArrayList<>();
        while (result != null) {
            actual.add(result.val);
            result = result.next;
        }

        List<Integer> expected = Arrays.asList(1,2,3,5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void case02() {
        ListNode one = new ListNode(1);

        ListNode result = removeNthFromEnd(one, 1);

        List<Integer> actual = new ArrayList<>();
        while (result != null) {
            actual.add(result.val);
            result = result.next;
        }

        List<Integer> expected = Arrays.asList();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void case03() {
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1, two);

        ListNode result = removeNthFromEnd(one, 1);

        List<Integer> actual = new ArrayList<>();
        while (result != null) {
            actual.add(result.val);
            result = result.next;
        }

        List<Integer> expected = Arrays.asList(1);

        Assert.assertEquals(expected, actual);
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (n-- > 0) {
            fast = fast.next;
        }

        // edge case, single element
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

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
