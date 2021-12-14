package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class ReversePrefixofWordTest {
    @Test
    public void case01() {
        Assert.assertEquals("dcbaefd", reversePrefix("abcdefd", 'd'));
    }

    @Test
    public void case02() {
        Assert.assertEquals("zxyxxe", reversePrefix("xyxzxe", 'z'));
    }

    @Test
    public void case03() {
        Assert.assertEquals("abcd", reversePrefix("abcd", 'z'));
    }

    public String reversePrefix(String word, char ch) {
        int left = 0;
        int right = word.indexOf(ch);

        char[] wordChar = word.toCharArray();
        char temp = (char) 0;
        while (left < right) {
            temp = wordChar[left];
            wordChar[left] = wordChar[right];
            wordChar[right] = temp;
            left++;
            right--;
        }

        return new String(wordChar);
    }
}
