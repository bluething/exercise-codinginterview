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
        boolean isValid = true;
        Stack<Integer> sequences = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushed.length || j < popped.length) {
            if (sequences.isEmpty() && i < pushed.length) {
                sequences.push(Integer.valueOf(pushed[i]));
                i++;
            } else {
                if (sequences.peek().equals(Integer.valueOf(popped[j]))) {
                    sequences.pop();
                    j++;
                } else {
                    if (i >= pushed.length) {
                        isValid = false;
                        j = popped.length;
                    } else {
                        sequences.push(Integer.valueOf(pushed[i]));
                        i++;
                    }
                }
            }
        }

        return isValid;
    }

    // Not readable code!
    // The idea is if the stack (sequences) empty, push the value from pushed
    // If the stack not empty, we have 2 choices
    // 1. pop the sequences, if the top stack is equal to current index popped
    // 2. if top stack not equal to current index popped we need to check
    // 2.1 if we already at the end of pushed array, it's mean we can't pop with popped array, return false
    // 2.2 else we push the value from pushed array
}
