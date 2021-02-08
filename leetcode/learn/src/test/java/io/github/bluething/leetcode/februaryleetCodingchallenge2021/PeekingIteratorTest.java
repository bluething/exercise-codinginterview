package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PeekingIteratorTest {

    @Test
    public void successWhenInputIsRight() {
        List<Integer> values = Arrays.asList(1, 2, 3);
        PeekingIterator listIterator = new PeekingIterator(values.iterator());
        listIterator.next();
        Assert.assertEquals(Integer.valueOf(2), listIterator.peek());
    }

    @Test
    public void successWhenInputIsRightTwo() {
        List<Integer> values = Arrays.asList(1, 2, 3);
        PeekingIterator listIterator = new PeekingIterator(values.iterator());
        listIterator.peek();
        Assert.assertEquals(Integer.valueOf(1), listIterator.next());
    }

    @Test
    public void successWhenInputIsRightThree() {
        List<Integer> values = new ArrayList<>();
        PeekingIterator listIterator = new PeekingIterator(values.iterator());
        listIterator.peek();
        Assert.assertEquals(null, listIterator.next());
    }

    public void successWhenInputIsRightFour() {
        List<Integer> values = Arrays.asList(1, 2, 3);
        PeekingIterator listIterator = new PeekingIterator(values.iterator());
        listIterator.next();
        listIterator.peek();
        listIterator.next();
        listIterator.next();
        Assert.assertEquals(false, listIterator.hasNext());
    }

    class PeekingIterator implements Iterator<Integer> {

        private Integer next;
        private boolean noSuchElement;
        private final Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            noSuchElement = false;
            localIteration();
        }

        private void localIteration() {
            if (iterator.hasNext()) {
                next = iterator.next();
            } else {
                noSuchElement = true;
            }
        }

        @Override
        public boolean hasNext() {
            return !noSuchElement;
        }

        @Override
        public Integer next() {
            Integer value = next;
            localIteration();
            return value;
        }

        // Returns the next element in the iteration without advancing the iterator
        public Integer peek() {
            return next;
        }
    }
}
