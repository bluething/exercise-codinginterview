package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

        Map<Integer, Integer> freqMap;
        List<Stack<Integer>> stacks;

        public FreqStack() {
            freqMap = new HashMap<>();
            stacks = new ArrayList<>();
            stacks.add(new Stack<>());
        }

        public void push(int x) {
            int freq = freqMap.getOrDefault(Integer.valueOf(x), 0) + 1;
            freqMap.put(Integer.valueOf(x), freq);
            if (freq == stacks.size()) {
                stacks.add(new Stack<>());
            }
            stacks.get(freq).add(Integer.valueOf(x));
        }

        public int pop() {
            Stack<Integer> top = stacks.get(stacks.size() - 1);
            int x = top.pop();
            if (top.size() == 0) {
                stacks.remove(stacks.size() -  1);
            }
            freqMap.put(Integer.valueOf(x), freqMap.get(Integer.valueOf(x)) -  1);

            return x;
        }
    }
}
