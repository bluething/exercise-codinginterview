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
        boolean answer = true;
        Stack<Integer> values = new Stack<>();
        ListNode traverseHead = head;
        while (traverseHead != null) {
            values.push(Integer.valueOf(traverseHead.val));
            traverseHead = traverseHead.next;
        }
        while (head != null) {
            if (!values.pop().equals(Integer.valueOf(head.val))) {
                answer = false;
                break;
            }
            head = head.next;
        }

        return answer;
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
}
