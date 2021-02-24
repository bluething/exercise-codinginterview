package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        TreeofParentheses current = new TreeofParentheses();
        TreeofParentheses root = current;
        // create node for every '()'
        for (int i = 0; i < S.length(); i++) {
            // for every '(' add node as child
            if (S.charAt(i) == '(') {
                TreeofParentheses child = new TreeofParentheses();
                child.root = current;
                current.children.add(child);
                current = child;
            } else {
                // if we find ')' aka the pair is close, we move to the parent
                current = current.root;
            }
        }

        int score = root.computeScore();

        return score;
    }

    class TreeofParentheses {
        TreeofParentheses root;
        List<TreeofParentheses> children;

        TreeofParentheses() {
            children = new ArrayList<>();
        }

        int computeScore() {
            // base case
            if (children.isEmpty()) {
                return 1;
            }

            int score = 0;
            for (TreeofParentheses treeofParentheses : children) {
                score += treeofParentheses.computeScore();
            }

            if (root == null) {
                return score;
            }
            
            return 2 * score;
        }
    }

    // The idea is represent balance parentheses string with tree.
    // Why there are 2 object, root and current?
}
