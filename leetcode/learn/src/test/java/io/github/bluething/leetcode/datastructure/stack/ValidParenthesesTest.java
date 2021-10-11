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
        if (s == null || s.length() == 0) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        Stack<Character> parentheses = new Stack<>();
        parentheses.push(s.charAt(0));
        Character current = Character.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            current = s.charAt(i);
            if (current.equals('(') || current.equals('{') || current.equals('[')) {
                parentheses.push(current);
            } else {
                if (pairs.get(current).equals(parentheses.peek())) {
                    parentheses.pop();
                } else {
                    return false;
                }
            }
        }

        if (!parentheses.empty()) {
            return false;
        }

        return true;
    }
}
