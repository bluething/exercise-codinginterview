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

        Set<ListNode> uniqueNode = new HashSet<>();
        while (head != null && !isCycling) {
            if (uniqueNode.contains(head)) {
                isCycling = true;
            }
            uniqueNode.add(head);
            head = head.getNext();
        }

        return isCycling;
    }

    // We can use Set to save next value, if the value already in Set, set true, else set false\
    // O(n) memory

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
