package io.github.bluething.leetcode.datastructure.string;

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqueCharacterinaStringTest {

    @Test
    public void case01() {
        Assert.assertEquals(0, firstUniqChar("leetcode"));
    }

    @Test
    public void case02() {
        Assert.assertEquals(2, firstUniqChar("loveleetcode"));
    }

    @Test
    public void case03() {
        Assert.assertEquals(-1, firstUniqChar("aabb"));
    }

    private int firstUniqChar(String s) {
        int idx = -1;
        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] == 1) {
                idx = i;
                break;
            }
        }

        return idx;
    }

    // other solutions:
    // using frequency map, my concern is additional space complexity
    // using indexOf() and lastIndexOf(), my concern is time complexity for both method
}