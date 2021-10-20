package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsinaString3Test {

    @Test
    public void case01() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
    }

    @Test
    public void case02() {
        Assert.assertEquals("doG gniD", reverseWords("God Ding"));
    }

    private String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] tokens = s.split("\\s+");
        char[] charS = null;
        int left = 0;
        int right = 0;
        char temp = (char) 0;
        for (String token : tokens) {
            charS = token.toCharArray();
            left = 0;
            right = charS.length - 1;
            while (left < right) {
                temp = charS[right];
                charS[right] = charS[left];
                charS[left] = temp;

                left++;
                right--;
            }
            result.append(new String(charS)).append(" ");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}
