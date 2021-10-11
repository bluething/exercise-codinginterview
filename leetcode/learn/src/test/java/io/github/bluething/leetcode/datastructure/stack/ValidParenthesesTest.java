package io.github.bluething.leetcode.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesesTest {

    @Test
    public void case01() {
        Assert.assertTrue(isValid("()"));
    }

    @Test
    public void case02() {
        Assert.assertTrue(isValid("()[]{}"));
    }

    @Test
    public void case03() {
        Assert.assertFalse(isValid("(]"));
    }

    @Test
    public void case04() {
        Assert.assertFalse(isValid("([)]"));
    }

    @Test
    public void case05() {
        Assert.assertTrue(isValid("{[]}"));
    }

    @Test
    public void case06() {
        Assert.assertFalse(isValid("]"));
    }

    @Test
    public void case07() {
        Assert.assertFalse(isValid("(){}}{"));
    }

    private boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        char current = '\0';
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                parentheses.push(current);
            } else {
                if (parentheses.isEmpty()) {
                    return false;
                }
                if (current == ')' && parentheses.pop() != '(') {
                    return false;
                }
                if (current == '}' && parentheses.pop() != '{') {
                    return false;
                }
                if (current == ']' && parentheses.pop() != '[') {
                    return  false;
                }
            }
        }
         return  parentheses.isEmpty();
    }
    //An input string is valid if:
    //
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.
    //
    // no need to check equality between top of stack and current before we pop
    // just pop it and see if the value match the current
}
