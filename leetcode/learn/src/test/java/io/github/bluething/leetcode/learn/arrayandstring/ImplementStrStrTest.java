package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

/*
* The problem https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
* Next time try KMP algorithm http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
* */
public class ImplementStrStrTest {
    private int strStr(String haystack, String needle) {
        if(needle == null || haystack == null) {
            return 0;
        }
        if(needle.length() == 0) {
            return 0;
        }
        // iterate haystack
        for (int i = 0; i < haystack.length(); i++) {
            // we only search until haystack.length() - needle.length()
            if (i + needle.length() > haystack.length()) {
                return -1;
            }

            int j = i;
            // iterate needle
            for (int k = 0; k < needle.length(); k++) {
                // find 1st match
                if(needle.charAt(k) == haystack.charAt(j)) {
                    // if match and needle reach the end, return
                    // all needle character match to haystack substring start from j as much as needle.length()
                    if(k == needle.length() - 1) {
                        return i;
                    }
                    j++;
                } else {
                    // not match, exit needle iteration
                    break;
                }

            }
        }
        return -1;
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(2, strStr("hello", "ll"));
    }

    @Test
    public void successWhenInputIsRight2() {
        Assert.assertEquals(-1, strStr("aaaaa", "bba"));
    }

    @Test
    public void successWhenInputIsRight3() {
        Assert.assertEquals(-1, strStr("", "a"));
    }

    @Test
    public void successWhenInputIsRight4() {
        Assert.assertEquals(0, strStr("a", "a"));
    }
}
