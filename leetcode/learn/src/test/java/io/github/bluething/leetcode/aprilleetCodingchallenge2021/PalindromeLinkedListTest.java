package io.github.bluething.leetcode.aprilleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class PalindromeLinkedListTest {

    @Test
    public void successWhenInputIsRight() {
        ListNode one2 = new ListNode(1, null);
        ListNode two2 = new ListNode(2, one2);
        ListNode two1 = new ListNode(2, two2);
        ListNode one1 = new ListNode(1, two1);

        Assert.assertTrue(isPalindrome(one1));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        ListNode two1 = new ListNode(2, null);
        ListNode one1 = new ListNode(1, two1);

        Assert.assertFalse(isPalindrome(one1));
    }

    private boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev;
        ListNode tmp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    // Floyd's Cycle Detection Algorithm.
    // 2 pointers.
    // slow, move 1 element.
    // fast, move twice as slow.
    // When the fast pointer reaches the end of the list, the slow pointer must then be in the middle.
    // With slow, we can reverse the back half of the list with the help of another variable to contain a reference to the previous node (prev) and a three-way swap.
    // prev.next = null prevent cycle (endless loop)
}
