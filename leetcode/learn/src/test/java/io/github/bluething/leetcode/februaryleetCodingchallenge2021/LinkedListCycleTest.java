package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleTest {

    @Test
    public void successWhenInputIsRight() {
        ListNode minFour = new ListNode(-4, null);
        ListNode zero = new ListNode(0, null);
        ListNode two = new ListNode(2, null);
        ListNode three = new ListNode(3, two);
        three.setNext(two);
        two.setNext(zero);
        zero.setNext(minFour);
        minFour.setNext(two);

        Assert.assertTrue(hasCycle(three));
    }

    private boolean hasCycle(ListNode head) {
        boolean isCycling = false;

        ListNode firstPointer = head;
        ListNode secondPointer = head;
        while (!isCycling && firstPointer != null && secondPointer != null && secondPointer.getNext() != null) {
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext().getNext();
            if (firstPointer == secondPointer) {
                isCycling = true;
            }
        }

        return isCycling;
    }

    // Floyd’s Cycle-Finding Algorithm
    // use two pointer
    // 1st pointer move once
    // 2nd pointer move twice
    // Distance between 1st and 2nd is +1 every loop
    // So after n loop they will meet (2nd will overlap 1st) if cyclic

    class ListNode {
        private int val;
        private ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
