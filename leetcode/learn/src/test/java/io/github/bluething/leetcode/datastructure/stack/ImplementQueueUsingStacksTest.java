package io.github.bluething.leetcode.datastructure.stack;

import org.junit.Test;

import java.util.Stack;

public class ImplementQueueUsingStacksTest {
    @Test
    public void case01() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    class MyQueue {

        private Stack<Integer> firstStack;
        private Stack<Integer> secondStack;

        public MyQueue() {
            firstStack = new Stack<>();
            secondStack = new Stack<>();
        }

        public void push(int x) {
            while (!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
            firstStack.push(x);
            while (!secondStack.empty()) {
                firstStack.push(secondStack.pop());
            }
        }

        public int pop() {
            return firstStack.pop();
        }

        public int peek() {
            return firstStack.peek();
        }

        public boolean empty() {
            return firstStack.empty();
        }
    }
}
