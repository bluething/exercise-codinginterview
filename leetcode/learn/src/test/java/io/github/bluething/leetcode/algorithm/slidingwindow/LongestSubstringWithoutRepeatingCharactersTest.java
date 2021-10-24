package io.github.bluething.leetcode.algorithm.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void case01() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void case02() {
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void case03() {
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void case04() {
        Assert.assertEquals(0, lengthOfLongestSubstring(""));
    }

    @Test
    public void case05() {
        Assert.assertEquals(4, lengthOfLongestSubstring("dabcabcbb"));
    }

    @Test
    public void case06() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abccabcbb"));
    }

    private int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        Set<Character> chars = new HashSet<>();
        char sChar = (char) 0;
        int maxLength = 0;

        while (end < s.length()) {
            sChar = s.charAt(end);
            if (chars.add(sChar)) {
                maxLength = Math.max(end - start + 1, maxLength);
                end++;
            } else {
                // if found duplicate
                // remove from chars that equal to s.charAt(start)
                // increment the start
                // after loop, start will point to the next 1st duplicate char -> start the new window
                while (chars.contains(sChar)) {
                    chars.remove(s.charAt(start));
                    start++;
                }
            }
        }

        return maxLength;
    }
}
