package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void case01() {
        char[] input = new char[]{'h','e','l','l','o'};
        reverseString(input);
        Assert.assertArrayEquals(new char[]{'o','l','l','e','h'}, input);
    }

    @Test
    public void case02() {
        char[] input = new char[]{'H','a','n','n','a','h'};
        reverseString(input);
        Assert.assertArrayEquals(new char[]{'h','a','n','n','a','H'}, input);
    }

    private void reverseString(char[] s) {
        int leftIdx = 0;
        int rightIdx = s.length - 1;
        char temp = 0;

        while (leftIdx < rightIdx) {
            temp = s[rightIdx];
            s[rightIdx] = s[leftIdx];
            s[leftIdx] = temp;

            leftIdx++;
            rightIdx--;
        }
    }
}
