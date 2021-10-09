package io.github.bluething.leetcode.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleTest {

    @Test
    public void case01() {
        ListNode four = new ListNode(-4);
        ListNode zero = new ListNode(0);
        zero.next = four;
        ListNode two = new ListNode(2);
        two.next = zero;
        four.next = two;
        ListNode three = new ListNode(3);
        three.next = two;

        Assert.assertTrue(hasCycle(three));
    }

    @Test
    public void case02() {
        ListNode two = new ListNode(2);
        two.next = null;
        ListNode one = new ListNode(1);
        one.next = two;

        Assert.assertFalse(hasCycle(one));
    }

    public void case03() {
        ListNode one = new ListNode(1);
        one.next = null;
    }

    // Floyd’s Cycle-Finding Algorithm
    // use two pointer
    // 1st pointer move once
    // 2nd pointer move twice
    // Distance between 1st and 2nd is +1 every loop
    // So after n loop they will meet (2nd will overlap 1st) if cyclic
    // loop when isCycled is true and 1st and 2nd ponter not null and 2nd pointer.next not null (avoid null pointer exception, because 2nd pointer always 1 step forward)

    private boolean hasCycle(ListNode head) {
        boolean isCycled = false;
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        while (!isCycled && firstPointer != null && secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
            if (firstPointer == secondPointer) {
                isCycled = true;
            }
        }

        return isCycled;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
