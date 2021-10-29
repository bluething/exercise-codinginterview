package io.github.bluething.leetcode.algorithm.recursion;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedListFirstNNodesTest {

    @Test
    public void case01() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode reversed = reverseN(one, 3);
        List<Integer> actual = toArrayList(reversed);

        List<Integer> expected = Arrays.asList(3, 2, 1, 4, 5);

        Assert.assertEquals(expected, actual);
    }

    private List<Integer> toArrayList(ListNode nodes) {
        List<Integer> vals = new ArrayList<>();
        while (nodes.next != null) {
            vals.add(nodes.val);
            nodes = nodes.next;
        }
        vals.add(nodes.val);

        return vals;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            return head;
        }

        // start from head.nex, reverse first n-1 nodes
        ListNode reversed = reverseN(head.next, n-1);

        // the successor, n+1 node
        ListNode tail = head.next.next;
        head.next.next = head;
        // head maybe not the last node
        // we assign the successor (n+1)
        head.next = tail;

        return reversed;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
