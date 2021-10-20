package io.github.bluething.hackerrank.interviewpreparationkit.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BalancedBracketsTest {

    @Test
    public void case01() {
        Assert.assertEquals("YES", isBalanced("{[()]}"));
    }

    @Test
    public void case02() {
        Assert.assertEquals("NO", isBalanced("{[(])}"));
    }

    @Test
    public void case03() {
        Assert.assertEquals("YES", isBalanced("{{[[(())]]}}"));
    }

    @Test
    public void case04() {
        Assert.assertEquals("NO", isBalanced("}[]()"));
    }

    @Test
    public void case05() {
        Assert.assertEquals("NO", isBalanced("(()"));
    }

    private String isBalanced(String s) {
        if (s.length() <= 1) {
            return "NO";
        }

        Stack<Character> charStack = new Stack<>();
        char sChar = (char) 0;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            // push all open bracket
            if (sChar == '(' || sChar == '{' || sChar == '[') {
                charStack.push(sChar);
            } else {
                // if we meet close bracket
                // if the stack is empty, return NO, this mean we don't have open bracket
                // otherwise pop the stack and compare the type
                if (charStack.isEmpty()) {
                    return "NO";
                } else if (sChar == ')' && charStack.pop().charValue() != '(') {
                    return "NO";
                } else if (sChar == '}' && charStack.pop().charValue() != '{') {
                    return "NO";
                } else if (sChar == ']' && charStack.pop().charValue() != '[') {
                    return "NO";
                }
            }
        }
        // at the end of the loop, we will have either empty stack or not empty stack (open bracket without close bracket)
        return charStack.isEmpty() ? "YES" : "NO";
    }
}
