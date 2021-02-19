package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
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
        StringBuilder validString = new StringBuilder("");
        Stack<Character> pairParenthese = new Stack<>();
        Character openParenthese = Character.valueOf('(');
        char currentChar = (char) 0;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (currentChar == '(') {
                pairParenthese.push(currentChar);
            } else if (currentChar == ')' && !pairParenthese.isEmpty()) {
                openParenthese = pairParenthese.pop();
                if (openParenthese != null) {
                    validString.append(openParenthese).append(currentChar);
                }
            } else {
                validString.append(currentChar);
            }
        }

        return validString.toString();
    }

    // 1st I think can use Stack, but I was wrong. I miss the detail in sample output
}
