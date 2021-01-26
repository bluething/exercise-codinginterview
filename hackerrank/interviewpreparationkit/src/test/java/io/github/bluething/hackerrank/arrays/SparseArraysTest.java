package io.github.bluething.hackerrank.arrays;

import org.junit.Assert;
import org.junit.Test;

public class SparseArraysTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{2, 1, 0}, matchingStrings(new String[]{"aba", "baba", "aba", "xzxb"}, new String[]{"aba", "xzxb", "ab"}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertArrayEquals(new int[]{1, 0, 1}, matchingStrings(new String[]{"def", "de", "fgh"}, new String[]{"de", "lmn", "fgh"}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertArrayEquals(new int[]{1, 3, 4, 3, 2}, matchingStrings(
                new String[]{"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"},
                new String[]{"abcde", "sdaklfj", "asdjf", "na", "basdn"}));
    }


    private int[] matchingStrings(String[] strings, String[] queries) {
        int[] counters = new int[queries.length];
        int counter = 0;
        for (int i = 0; i < queries.length; i++) {
            counter = 0;
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].equals(strings[j])) {
                    counter++;
                }
            }
            counters[i] = counter;
        }

        return counters;
    }
}
