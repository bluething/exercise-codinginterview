package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class MaximumFrequencyStackTest {

    @Test
    public void successWhenInputIsRight() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        Assert.assertEquals(4, freqStack.pop());
    }

    @Test
    public void successWhenInputIsTwo() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        freqStack.pop();
        freqStack.pop();
        Assert.assertEquals(5, freqStack.pop());
        freqStack.pop();
    }

    @Test
    public void successWhenInputIsThree() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        freqStack.pop();
        Assert.assertEquals(7, freqStack.pop());
        freqStack.pop();
        freqStack.pop();
    }

    @Test
    public void successWhenInputIsFour() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        Assert.assertEquals(5, freqStack.pop());
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
    }

    class FreqStack {

        public FreqStack() {

        }

        public void push(int x) {

        }

        public int pop() {
            return 0;
        }
    }
}
