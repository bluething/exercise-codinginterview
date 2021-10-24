package io.github.bluething.leetcode.algorithm.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

public class PermutationinStringTest {

    @Test
    public void case01() {
        Assert.assertTrue(checkInclusion("ab", "eidbaooo"));
    }

    public void case02() {
        Assert.assertFalse(checkInclusion("ab", "eidboaoo"));
    }

    private boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // array to store the frequency
        // index 0 represents 'a', 1 represents 'b', and so on until index 25, which represents 'z'.
        int[] s1CharCount = new int[26];
        int[] s2CharCount = new int[26];

        // count the character in s1 and s2 (up to s1.length())
        for (int i = 0; i < s1.length(); i++) {
            s1CharCount[s1.charAt(i) - 'a']++;
            s2CharCount[s2.charAt(i) - 'a']++;
        }

        // start sliding window technique
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            // if both array is equals, return true
            if (matches(s1CharCount, s2CharCount)) {
                return true;
            }

            s2CharCount[s2.charAt(i + s1.length()) - 'a']++;
            s2CharCount[s2.charAt(i) - 'a']--;
        }

        return matches(s1CharCount, s2CharCount);
    }

    // helper method to decide if two array have same value for all index
    private boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
