package io.github.bluething.leetcode.algorithm.recursion;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedListTest {

    @Test
    public void case01() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode reversed = reverseList(one);
        List<Integer> actual = toArrayList(reversed);
        List<Integer> expected = Arrays.asList(5,4,3,2,1);

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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // divide the list into two, 1st and the rest (next node)
        // 1 -> reverseList(2 -> 3 -> 4 -> 5 -> null)
        ListNode reverse = reverseList(head.next);
        // 1 -> reverseList(2 -> 3 -> 4(pointing by head) -> 5(pointing by reverse) -> null)

        head.next.next = head;
        // 1 -> reverseList(2 -> 3 -> 4(pointing by head) -> 5(pointing by reverse) -> 4)

        head.next = null;
        // 1 -> reverseList(2 -> 3 -> 4(pointing by head) -> null and 5(pointing by reverse) -> 4)

        return reverse;
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
