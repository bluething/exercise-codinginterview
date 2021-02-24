package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class ScoreofParenthesesTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(1, scoreOfParentheses("()"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(2, scoreOfParentheses("(())"));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(2, scoreOfParentheses("()()"));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(6, scoreOfParentheses("(()(()))"));
    }

    private int scoreOfParentheses(String S) {
        int score = 0;
        int power = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                power++;
            } else if (S.charAt(i - 1) == '(') {
                score += 1 << power--;
            } else {
                power--;
            }
        }

        return score;
    }

    // The idea is when we see problem with doubling operation and an incrementing operation we should at least think about a potential binary solution.
    // For this case example 4,
    // "(()(()))" -> "(1 + (1))" -> "2 * (1 + 2 * 1)" -> 2 + 2^2
    // Start loop from idx=1, we know idx=0 must be '('
    // If we meet '(' we increase the power
    // else if we meet at index before '(' "(()(()))" ( and of course we meet ')' ) aka closing parentheses we doubled the value (2 ^ power)
    // else we decrease the power -> The rest of ')'
}
