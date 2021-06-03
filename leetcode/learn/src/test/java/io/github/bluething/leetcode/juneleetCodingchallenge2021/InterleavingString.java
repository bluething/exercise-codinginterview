package io.github.bluething.leetcode.juneleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class InterleavingString {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertFalse(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertTrue(isInterleave("", "", ""));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertFalse(isInterleave("", "", "a"));
    }

    private boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }

        if (s3.length() == 0) {
            return false;
        }

        return (s1.length() != 0 && s3.charAt(0) == s1.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1))) ||
                (s2.length() != 0 && s3.charAt(0) == s2.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)));
    }
    // There are 2 conditions:
    // 1. If the 1st char in s3 match with 1st char in s1. Then we need to move to 2nd char s1 and s3 and check again (recursive).
    // 2. If the 1st char in s3 match with 1st char in s2. Then we need to move to 2nd char s2 and s3 and check again (recursive).
    // We move it by substring start from next character.
    // The base case is when s1, s2, s3 have 0 length. Because we will move all of them one by one.
    // At the end of recursive (if s3 can be build by interleaving s1 and s2) there are no remaining character.
    // This solution can pass all my test cases but in LeetCode it hit Time Limit Exceeded.
    // Other solution is using dynamic programming. I will come back later after study it.
}
