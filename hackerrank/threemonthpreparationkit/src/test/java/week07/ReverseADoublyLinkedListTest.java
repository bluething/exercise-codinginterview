package week07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseADoublyLinkedListTest {

    @Test
    public void case01() {
        DoublyLinkedListNode four = new DoublyLinkedListNode();
        four.data = 4;
        four.next = null;
        DoublyLinkedListNode three = new DoublyLinkedListNode();
        three.data = 3;
        three.next = four;
        DoublyLinkedListNode two = new DoublyLinkedListNode();
        two.data = 2;
        two.next = three;
        DoublyLinkedListNode one = new DoublyLinkedListNode();
        one.data = 1;
        one.next = two;
        one.prev = null;

        four.prev = three;
        three.prev = two;
        two.prev = one;

        DoublyLinkedListNode reversed = reverse(one);
        List<Integer> actual = new ArrayList<>();
        while (reversed != null) {
            actual.add(reversed.data);
            reversed = reversed.next;
        }

        Assertions.assertEquals(Arrays.asList(4, 3, 2, 1), actual);
    }

    private DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode next = null;
        DoublyLinkedListNode prev = null;
        while (llist != null) {
            next = llist.next;
            llist.next = prev;
            llist.prev = next;
            prev = llist;
            llist = next;
        }

        return prev;

    }

    private class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
    }
}
