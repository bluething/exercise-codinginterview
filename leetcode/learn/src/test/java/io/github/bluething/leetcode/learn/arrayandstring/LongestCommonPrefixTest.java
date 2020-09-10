package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

/*
* The problem https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
* */
public class LongestCommonPrefixTest {

    // The idea is do looping, in each iteration compare character at n for each string
    // Stop loop if one of string already at the end (throw an exception)
    private String longestCommonPrefix(String[] strs) {
        boolean search = true;
        char searchChar = 0;
        int idx = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        while (search) {
            try {
                searchChar = strs[0].charAt(idx);
                for (int i = 1; i < strs.length; i++) {
                    if (searchChar != strs[i].charAt(idx)) {
                        search = false;
                        break;
                    }
                }
                idx++;
                if (search) {
                    stringBuilder.append(searchChar);
                }
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                break;
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    @Test
    public void successWhenInputIsRight2() {
        Assert.assertEquals("", longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

}
