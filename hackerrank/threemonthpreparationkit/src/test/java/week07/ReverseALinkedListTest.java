package week07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseALinkedListTest {

    @Test
    public void case01() {
        SinglyLinkedListNode five = new SinglyLinkedListNode();
        five.data = 5;
        SinglyLinkedListNode four = new SinglyLinkedListNode();
        four.data = 4;
        four.next = five;
        SinglyLinkedListNode three = new SinglyLinkedListNode();
        three.data = 3;
        three.next = four;
        SinglyLinkedListNode two = new SinglyLinkedListNode();
        two.data = 2;
        two.next = three;
        SinglyLinkedListNode one = new SinglyLinkedListNode();
        one.data = 1;
        one.next = two;

        SinglyLinkedListNode reversed = reverse(one);
        List<Integer> actual = new ArrayList<>();
        while (reversed != null) {
            actual.add(reversed.data);
            reversed = reversed.next;
        }

        Assertions.assertEquals(Arrays.asList(5, 4, 3, 2, 1), actual);

    }

    private SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode current = llist;
        // pointer to the reversed list
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode next = null;
        while (current != null) {
            // pointer to the next node
            next = current.next;
            // pointing next to the left
            current.next = prev;
            // make current node as a prev node (head of reversed)
            prev = current;
            // move to the right
            current = next;
        }

        // reverse the list
        llist = prev;

        return llist;
    }

    private class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
