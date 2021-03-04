package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class SingleRowKeyboardTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(4, calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(31, calculateTime("pqrstuvwxyzabcdefghijklmno", "hello"));
    }

    private int calculateTime(String keyboard, String word) {
        int time = 0;
        int idx = 0;
        for (int i = 0; i < word.length(); i++) {
            time += Math.abs(idx - keyboard.indexOf(word.charAt(i)));
            idx = keyboard.indexOf(word.charAt(i));
        }

        return time;
    }
}
