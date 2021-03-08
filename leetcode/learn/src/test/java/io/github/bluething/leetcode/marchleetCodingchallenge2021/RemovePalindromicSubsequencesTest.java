package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class RemovePalindromicSubsequencesTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(1, removePalindromeSub("ababa"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(2, removePalindromeSub("abb"));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(2, removePalindromeSub("baabb"));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(0, removePalindromeSub(""));
    }

    private int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int numOfStep = 1;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                numOfStep = 2;
            }
            i++;
            j--;
        }

        return numOfStep;
    }

    // At first it seems difficult, because 'Subsequences' term
    // The key is "In a single step you can remove one palindromic subsequence from s"
    // The fact is:
    // 1. If given string is palindrome, we need only one removal (the string itself)
    // 2. Else we need 2 removal, 1 is for 'a' or 'b' to make it palindrome. 1 is for the rest (palindrome itself)
}
