package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class MergeStringsAlternately {
    @Test
    public void case01() {
       Assert.assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
    }

    @Test
    public void case02() {
        Assert.assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
    }

    @Test
    public void case03() {
        Assert.assertEquals("apbqcd", mergeAlternately("abcd", "pq"));
    }

    private String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(j));
            i++;
            j++;
        }

        if (i < word1.length()) {
            merged.append(word1.substring(i));
        }
        if (j < word2.length()) {
            merged.append(word2.substring(j));
        }

        return merged.toString();
    }
}
