package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class SwappingNodesinaLinkedListTest {

    @Test
    public void successWhenInputIsRight() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        Assert.assertEquals(4, swapNodes(one, 2).next.val);
    }

    @Test
    public void successWhenInputIsRightTwo() {
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        Assert.assertEquals(2, swapNodes(one, 2).next.val);
    }

    private ListNode swapNodes(ListNode head, int k) {
        ListNode slideA = head;
        ListNode slideB = head;
        ListNode nodeKth = head;

        for (int i = 1; i < k; i++) {
            slideA = slideA.next;
        }
        nodeKth = slideA;

        slideA = slideA.next;
        while (slideA != null) {
            slideA = slideA.next;
            slideB = slideB.next;
        }

        int tempVal = nodeKth.val;
        nodeKth.val = slideB.val;
        slideB.val = tempVal;

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

    // The key is distance kth node from the beginning and the kth node from the end is same
    // Prepare two list, slideA and slideB
    // Move slideA until kth node, assign to list nodeKth
    // Move slideA one more (behind kth node)
    // Loop slideA until end, in each loop move slideB
    // At the end of loop, slideA will reach the last node and slideB will reach kth node from the end
    // nodeKth val is kth node value from the beginning
    // slideB val is kth node value from the end

}
