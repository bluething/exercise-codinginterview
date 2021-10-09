package io.github.bluething.leetcode.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveLinkedListElementsTest {

    @Test
    public void case01() {
        ListNode six = new ListNode(6);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode six2 = new ListNode(6, three);
        ListNode two = new ListNode(2, six2);
        ListNode one = new ListNode(1, two);

        one = removeElements(one, 6);

        List<Integer> actual = new ArrayList<>();
        while (one.next != null) {
            actual.add(one.val);
            one = one.next;
        }

        List<Integer> expected = Arrays.asList(1,2,3,4,5);

        Assert.assertEquals(expected, actual);
    }

    // using recursion until next node == null
    private ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        if (head.next != null) {
            head.next = removeElements(head.next, val);
        }

        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    // using simple loop
    // keep check if the next node contain the val
    // if yes, set current to the next of next
    // if no, continue checking
    // at the end we will delete all mode contains val except 1st node
    // if 1st node value same with val, return the next element

    private ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                currentNode = currentNode.next.next;
            } else  {
                currentNode = currentNode.next;
            }
        }

        return head.val == val ? head.next : head;
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
