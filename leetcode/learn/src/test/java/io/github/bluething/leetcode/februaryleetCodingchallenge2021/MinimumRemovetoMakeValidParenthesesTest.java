package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class MinimumRemovetoMakeValidParenthesesTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals("lee(t(c)o)de", minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals("ab(c)d", minRemoveToMakeValid("a)b(c)d"));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals("", minRemoveToMakeValid("))(("));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals("a(b(c)d)", minRemoveToMakeValid("(a(b(c)d)"));
    }

    private String minRemoveToMakeValid(String s) {
        Stack<Integer> removeIdxs = new Stack<>();
        char currentChar = (char) 0;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (currentChar == '(') {
                removeIdxs.push(Integer.valueOf(i));
            } else if (currentChar == ')') {
                if (!removeIdxs.isEmpty() && s.charAt(removeIdxs.peek()) == '(') {
                    removeIdxs.pop();
                } else {
                    removeIdxs.push(Integer.valueOf(i));
                }
            }
        }

        StringBuilder validString = new StringBuilder(s);
        int removeIndex = 0;
        while (!removeIdxs.isEmpty()) {
            removeIndex = removeIdxs.pop().intValue();
            validString.deleteCharAt(removeIndex);
        }

        return validString.toString();
    }

    // 1st I think can use Stack to hold Parentheses pair
    // I think it's better to hold the idx of unpair parentheses
    // This index used at final loop to clean up string builder
    // If '(' found, push it
    // If ')' found, THIS IS TRICKY PART!
    // Normally we pop the stack (because pair), but there are one more condition
    // We need to see at peek stack if the value is ')'
    // Special case is when we have "))", if we don't peek the stack first, we will lose removeIndex
    // If stack is empty, push it
    // The final loop is clear the stack, in each loop, delete char at appropriate index
}
