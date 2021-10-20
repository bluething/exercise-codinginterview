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

    @Test
    public void case03() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWordsWithoutStringBuilder("Let's take LeetCode contest"));
    }

    @Test
    public void case04() {
        Assert.assertEquals("doG gniD", reverseWordsWithoutStringBuilder("God Ding"));
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

    private String reverseWordsWithoutStringBuilder(String s) {
        char[] tokens = s.toCharArray();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] != ' ') {
                int j = i;
                // increment j until find space or reach the end of sting
                while (j + 1 < tokens.length && tokens[j+1] != ' ') {
                    j++;
                }

                // reverse the token from i to j
                int right = j;
                int left = i;
                char temp = (char) 0;
                while (left < right) {
                    temp = tokens[right];
                    tokens[right] = tokens[left];
                    tokens[left] = temp;

                    left++;
                    right--;
                }

                // i become j
                i = j;
            }
        }

        return new String(tokens);
    }
}
