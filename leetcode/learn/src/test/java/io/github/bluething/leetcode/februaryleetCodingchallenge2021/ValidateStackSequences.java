package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ValidateStackSequences {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertTrue(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertFalse(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertTrue(validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
    }

    private boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> sequences = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushed.length) {
            sequences.push(Integer.valueOf(pushed[i]));
            i++;

            while (!sequences.isEmpty() && j < popped.length && sequences.peek().equals(Integer.valueOf(popped[j]))) {
                sequences.pop();
                j++;
            }
        }

        return j == popped.length;
    }

    // More readable solution
    // The idea is we push value from pushed array
    // Then if the top of stack is equals to current index of popped, pop it.
    // Continue it until the the top of stack is not equals to current index of popped.
    // Or the stack empty
    // The stack sequence is valid if we reach at the end of popped index (popped all value)
}
