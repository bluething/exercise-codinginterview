package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class ImplementStrStrTest {
    private int strStr(String haystack, String needle) {
        int idxOf = -1;
        if (needle.length() > 0 && (needle.length() <= haystack.length())) {
            char[] haysStacks = haystack.toCharArray();
            char[] needles = needle.toCharArray();
            boolean search = true;
            int i = 0;
            while (search) {
                if (haysStacks[i] == needles[0]) {
                    idxOf = i;
                    search = false;
                    for (int j = 1; j < needle.length(); j++) {
                        if((i + j) == haystack.length()) {
                            break;
                        }
                        if(haysStacks[i + j] != needles[j]) {
                            idxOf = -1;
                            search = true;
                            break;
                        }
                    }
                }
                i++;
                if(i == haysStacks.length) {
                    search = false;
                }
            }
        } else if (needle.length() == 0){
            idxOf = 0;
        }
        return idxOf;
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
