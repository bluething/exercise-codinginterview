package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class IntersectionofTwoLinkedListsTest {

    @Test
    public void successWhenInputIsRight() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4);
        four.next = five;
        ListNode eight = new ListNode(8);
        eight.next = four;
        ListNode oneA = new ListNode(1);
        oneA.next = eight;
        ListNode fourA = new ListNode(4);
        fourA.next = oneA;
        ListNode oneB = new ListNode(1);
        oneB.next = eight;
        ListNode sixB = new ListNode(6);
        sixB.next = oneB;
        ListNode fiveB = new ListNode(5);
        fiveB.next = sixB;

        Assert.assertEquals(eight, getIntersectionNode(fourA, fiveB));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2);
        two.next = four;
        ListNode oneA = new ListNode(1);
        oneA.next = two;
        ListNode nineA = new ListNode(9);
        nineA.next = oneA;
        ListNode oneAA = new ListNode(1);
        oneAA.next = nineA;
        ListNode threeB = new ListNode(3);
        threeB.next = two;

        Assert.assertEquals(two, getIntersectionNode(oneAA, threeB));
    }

    @Test
    public void successWhenInputIsRightThree() {
        ListNode fourA = new ListNode(4);
        ListNode sixA = new ListNode(6);
        sixA.next = fourA;
        ListNode twoA = new ListNode(2);
        twoA.next = sixA;
        ListNode fiveB = new ListNode(5);
        ListNode oneB = new ListNode(1);
        oneB.next = fiveB;

        Assert.assertNull(getIntersectionNode(twoA, oneB));
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // The idea is we concatenating the listNode each other. At the end A and B will have same size.
    // A+B, B+A.
    // Loop until last node of A and B have same value.
    // In each loop, if we reach the end of listNodes join with opposite. Otherwise give the next value.
    // During the concatenating process we will find intersection between two listNodes.
    // Last node of A and B will have value of null.
    // O(1) space complexity, we don't introduce new heap;
}
