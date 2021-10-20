package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void case01() {
        char[] input = new char[]{'h','e','l','l','o'};
        reverseString(input);
        char[] output = new char[]{'o','l','l','e','h'};

        Assert.assertArrayEquals(output, input);
    }

    @Test
    public void case02() {
        char[] input = new char[]{'H','a','n','n','a','h'};
        reverseString(input);
        char[] output = new char[]{'h','a','n','n','a','H'};

        Assert.assertArrayEquals(output, input);
    }

    private void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp = (char) 0;
        while (left < right) {
            temp = s[right];
            s[right] = s[left];
            s[left] = temp;

            right--;
            left++;
        }
    }
}
