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

    private boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean isValid = true;
        Stack<Integer> sequences = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushed.length || j < popped.length) {
            if (i < pushed.length) {
                sequences.push(Integer.valueOf(pushed[i]));
                i++;
            }
            if (sequences.peek() == Integer.valueOf(popped[j])) {
                sequences.pop();
                j++;
            } else if (sequences.peek() != Integer.valueOf(popped[j]) && i >= pushed.length) {
                isValid = false;
                j = popped.length;
            }
        }

        return isValid;
    }
}
