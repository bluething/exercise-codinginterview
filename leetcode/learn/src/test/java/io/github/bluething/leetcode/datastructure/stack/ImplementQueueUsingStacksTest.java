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
            firstStack.push(x);
        }

        public int pop() {
            if (firstStack.empty()) {
                return -1;
            } else {
                while (!firstStack.empty()) {
                    secondStack.push(firstStack.pop());
                }
                int firstElement = secondStack.pop();
                while (!secondStack.empty()) {
                    firstStack.push(secondStack.pop());
                }
                return firstElement;
            }
        }

        public int peek() {
            if (firstStack.empty()) {
                return -1;
            } else {
                while (!firstStack.empty()) {
                    secondStack.push(firstStack.pop());
                }
                int firstElement = secondStack.peek();
                while (!secondStack.empty()) {
                    firstStack.push(secondStack.pop());
                }
                return firstElement;
            }
        }

        public boolean empty() {
            return firstStack.empty();
        }
    }
}
