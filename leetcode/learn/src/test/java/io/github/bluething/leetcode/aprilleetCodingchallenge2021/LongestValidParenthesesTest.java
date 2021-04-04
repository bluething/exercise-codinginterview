package io.github.bluething.leetcode.aprilleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class LongestValidParenthesesTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(2, longestValidParentheses("(()"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(4, longestValidParentheses(")()())"));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(0, longestValidParentheses(""));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(4, longestValidParentheses("()()"));
    }

    private int longestValidParentheses(String s) {
        Stack<Integer> indexes = new Stack<>();
        int fakeIdx = -1;
        indexes.push(fakeIdx);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indexes.push(i);
            } else {
                indexes.pop();

                if (indexes.empty()) {
                    indexes.push(i);
                }

                count = Math.max(count, i - indexes.peek());
            }
        }

        return count;
    }

    // what we need is longest differences between ')' at i and last entry in the stack
    // but in case successWhenInputIsRightFour if we count from last entry, we can't get the answer
    // so we count from second last entry (peek)
    // another issue, in case successWhenInputIsRightFour, the stack will empty after we pop last '('
    // the solution is we put fake '(' index, say it -1
    // another issue, what if at i index we find ')' meanwhile stack already empty (it become invalid)
    // in that case only our fake index left
    // the solution is restart the stack, stack[0] = i
    // see case successWhenInputIsRightTwo
    // at 1st loop we don't have '(' yet, so we pop our fake idx then push 0 at stack[0]
}
