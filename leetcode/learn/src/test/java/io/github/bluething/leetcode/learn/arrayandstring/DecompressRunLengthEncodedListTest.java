package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

// The problem https://leetcode.com/problems/decompress-run-length-encoded-list/
public class DecompressRunLengthEncodedListTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{2,4,4,4}, decompressRLElist(new int[]{1,2,3,4}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertArrayEquals(new int[]{1,3,3}, decompressRLElist(new int[]{1,1,2,3}));
    }

    private int[] decompressRLElist(int[] nums) {
        int sumFreq = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sumFreq += nums[i];
        }

        int[] decompressed = new int[sumFreq];
        int idx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 1; j <= nums[i]; j++) {
                decompressed[idx++] = nums[i+1];
            }
        }

        return decompressed;
    }
}
