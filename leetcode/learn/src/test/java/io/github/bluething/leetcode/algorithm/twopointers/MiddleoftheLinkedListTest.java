package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiddleoftheLinkedListTest {

    @Test
    public void case01() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode middle = middleNode(one);

        List<Integer> actual = new ArrayList<>();
        while (middle != null) {
            actual.add(middle.val);
            middle = middle.next;
        }

        List<Integer> expected = Arrays.asList(3, 4, 5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void case02() {
        ListNode six = new ListNode(6);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode middle = middleNode(one);

        List<Integer> actual = new ArrayList<>();
        while (middle != null) {
            actual.add(middle.val);
            middle = middle.next;
        }

        List<Integer> expected = Arrays.asList(4, 5, 6);

        Assert.assertEquals(expected, actual);
    }

    // the idea is using two pointers, slow (move 1 by 1) and fast (move 2)
    // iterate until fast pointer reach the end of the list
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
